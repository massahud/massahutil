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
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

/**
 * Base class for component builders. Already implements common functionality
 *
 * @author massahud
 */
public abstract class PrimefacesComponentBuilderBase<T extends UIComponent> {

    private Class<T> classe;
    private Object[] args;
    private Set<String> styleClasses = new LinkedHashSet<String>();
    private String id;
    private List<UIComponent> filhos = new LinkedList<UIComponent>();
    private Map<String, ValueExpression> valueExpressions = new HashMap<String, ValueExpression>();

    protected PrimefacesComponentBuilderBase(Class<T> classe, Object... args) {
        this.classe = classe;
        this.args = args;
    }

    public PrimefacesComponentBuilderBase<T> withStyleClass(String classe) {
        styleClasses.add(classe);
        return this;
    }

    public PrimefacesComponentBuilderBase<T> withId(String id) {
        this.id = id;
        return this;
    }

    public PrimefacesComponentBuilderBase<T> withChild(UIComponent filho) {
        this.filhos.add(filho);
        return this;
    }
    
    public PrimefacesComponentBuilderBase<T> withValueExpression(ELContext elContext, ExpressionFactory expressionFactory, String property, String valueExpression, Class<?> expectedType) {
        ValueExpression expression = expressionFactory.createValueExpression(elContext, valueExpression, expectedType);
        valueExpressions.put(property, expression);
        return this;
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
            return component;
        } catch (Exception ex) {
            throw new RuntimeException("Error creating outputPanel: " + ex.getMessage(), ex);
        }
    }
}
