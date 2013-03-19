/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces.extensions;

import massahud.massahutil.primefaces.PrimefacesComponentBuilderBase;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.extensions.component.inputnumber.InputNumber;

/**
 * Builder that builds OutputPanels
 *
 * @author massahud
 */
public class InputNumberBuilder extends PrimefacesComponentBuilderBase<InputNumber, InputNumberBuilder> {

    private String value;
    private boolean disabled;
    private String onfocus;
    private String decimalSeparator;
    private String thousandSeparator;
    private String emptyValue;// = "empty";
    private String decimalPlaces;// = "0";
    private Integer maxLength;

    public static InputNumberBuilder createNew() {
        return new InputNumberBuilder();
    }
    

    protected InputNumberBuilder() {
        super(InputNumber.class);
    }

    public InputNumberBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public InputNumberBuilder withDecimalSeparator(String separator) {
        this.decimalSeparator = separator;
        return this;
    }

    public InputNumberBuilder withThousandSeparator(String separator) {
        this.thousandSeparator = separator;
        return this;
    }

    public InputNumberBuilder withOnfocus(String javascript) {
        this.onfocus = javascript;
        return this;
    }
    
    public InputNumberBuilder withEmptyValue(String emptyValue) {
        this.emptyValue = emptyValue;
        return this;
    }
        

    public InputNumberBuilder disabled() {
        this.disabled = true;
        return this;
    }
    
    public InputNumberBuilder withDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
        return this;
    }
    
    public InputNumberBuilder withMaxLength(int maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    @Override
    public InputNumber build() {
        InputNumber component = super.build();
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        if (this.onfocus != null) {
            component.setOnfocus(this.onfocus);
        }
        if (decimalSeparator != null) {
            component.setDecimalSeparator(decimalSeparator);
        }
        if (thousandSeparator != null) {
            component.setThousandSeparator(thousandSeparator);
        }
        if (emptyValue != null) {
            component.setEmptyValue(emptyValue);
        }        
        if (decimalPlaces != null) {
            component.setDecimalPlaces(decimalPlaces);
        }
        if (maxLength != null) {
            component.setMaxlength(maxLength);
        }                        
        component.setDisabled(disabled);
        return component;
    }
}
