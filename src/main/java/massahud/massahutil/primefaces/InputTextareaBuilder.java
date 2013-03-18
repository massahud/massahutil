/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import javax.faces.component.UIInput;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.inputtextarea.InputTextarea;

/**
 * Builder that builds OutputPanels
 *
 * @author massahud
 */
public class InputTextareaBuilder extends PrimefacesComponentBuilderBase<InputTextarea> {

    private String value;

    public static InputTextareaBuilder createNew() {
        return new InputTextareaBuilder();
    }
    private Integer cols;
    private boolean disabled;

    protected InputTextareaBuilder() {
        super(InputTextarea.class);
    }

    public InputTextareaBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    public InputTextareaBuilder withCols(int cols) {
        this.cols = cols;
        return this;
    }

    public InputTextareaBuilder disabled() {
        this.disabled = true;
        return this;
    }

    @Override
    public InputTextarea build() {
        InputTextarea component = super.build();
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        if (cols != null) {
            component.setCols(cols);
        }
        component.setDisabled(disabled);

        return component;
    }
}
