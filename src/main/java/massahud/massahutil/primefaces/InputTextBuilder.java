/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.inputtext.InputText;

/**
 * Builder that builds OutputPanels
 *
 * @author massahud
 */
public class InputTextBuilder extends PrimefacesComponentBuilderBase<InputText> {

    private String value;

    public static InputTextBuilder createNew() {
        return new InputTextBuilder();
    }
    private boolean disabled;
    private String onfocus;
    private Integer maxLength;

    protected InputTextBuilder() {
        super(InputText.class);
    }

    public InputTextBuilder withValue(String value) {
        this.value = value;
        return this;
    }
    
    public InputTextBuilder withOnfocus(String javascript) {
        this.onfocus = javascript;
        return this;
                
    }

    public InputTextBuilder disabled() {
        this.disabled = true;
        return this;
    }
    
    public InputTextBuilder withMaxLength(int length) {
        this.maxLength = length;
        return this;
    }
    

    @Override
    public InputText build() {
        InputText component = super.build();
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        if (this.onfocus != null) {
            component.setOnfocus(this.onfocus);
        }
        if (maxLength != null) {
            component.setMaxlength(maxLength);
        }       
        component.setDisabled(disabled);
        return component;
    }
}
