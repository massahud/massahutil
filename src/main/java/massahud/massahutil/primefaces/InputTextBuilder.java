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

    public InputTextBuilder() {
        super(InputText.class);
    }

    public InputTextBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public InputTextBuilder disabled() {
        this.disabled = true;
        return this;
    }

    @Override
    public InputText build() {
        InputText component = super.build();
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        component.setDisabled(disabled);
        return component;
    }
}
