/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.ClientBehavior;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * Base class for component builders. Already implements common functionality
 *
 * @param <T> component return type
 * @param <ME> must be the same subclass type, or some methods throw exceptions
 * @author massahud
 */
public abstract class PrimefacesComponentBuilderBase<T extends UIComponentBase, ME extends PrimefacesComponentBuilderBase<T, ME>> {

    private Class<T> classe;
    private Object[] args;
    private Set<String> styleClasses = new LinkedHashSet<String>();
    private String id;
    private List<UIComponent> filhos = new LinkedList<UIComponent>();
    private Map<String, ValueExpression> valueExpressions = new HashMap<String, ValueExpression>();
    private Map<String, ClientBehavior> clientBehaviors = new HashMap<String, ClientBehavior>();    

    protected PrimefacesComponentBuilderBase(Class<T> classe, Object... args) {
        this.classe = classe;
        this.args = args;
    }

    @SuppressWarnings("unchecked")
    public ME withStyleClass(String classe) {
        styleClasses.add(classe);
        return (ME) this;
    }

    @SuppressWarnings("unchecked")
    public ME withId(String id) {
        this.id = id;
        return (ME) this;
    }

    @SuppressWarnings("unchecked")
    public ME withChild(UIComponent filho) {
        this.filhos.add(filho);
        return (ME) this;
    }
    
    @SuppressWarnings("unchecked")
    public ME withValueExpression(String property, ValueExpression expression) {        
        valueExpressions.put(property, expression);
        return (ME) this;
    }
    
    @SuppressWarnings("unchecked")
    public ME withClientBehavior(String event, ClientBehavior behavior) {
        clientBehaviors.put(event, behavior);
        return (ME) this;
    }        

    public T build() {
        try {
            T component = ConstructorUtils.invokeConstructor(classe, args);
            if (!styleClasses.isEmpty()) {
                MethodUtils.invokeMethod(component, "setStyleClass", StringUtils.join(styleClasses, " "));
            }
            if (id != null) {
                component.setId(id);
            }
            for (UIComponent filho : filhos) {
                component.getChildren().add(filho);
            }
            if (!valueExpressions.isEmpty()) {
                for (Map.Entry<String, ValueExpression> entry : valueExpressions.entrySet()) {
                    component.setValueExpression(entry.getKey(), entry.getValue());
                }
            }   
            if (!clientBehaviors.isEmpty()) {
                for (Map.Entry<String, ClientBehavior> entry : clientBehaviors.entrySet()) {
                    component.addClientBehavior(entry.getKey(), entry.getValue());
                }
            }
            return component;
        } catch (Exception ex) {
            throw new RuntimeException("Error creating outputPanel: " + ex.getMessage(), ex);
        }
    }
}