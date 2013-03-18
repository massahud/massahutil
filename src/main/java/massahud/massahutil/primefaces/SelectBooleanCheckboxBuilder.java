/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.component.inputtext.InputText;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;

/**
 * Builder that builds OutputPanels
 *
 * @author massahud
 */
public class SelectBooleanCheckboxBuilder extends PrimefacesComponentBuilderBase<SelectBooleanCheckbox> {

    private Boolean selected;

    public static SelectBooleanCheckboxBuilder createNew() {
        return new SelectBooleanCheckboxBuilder();
    }
    private boolean disabled;

    public SelectBooleanCheckboxBuilder() {
        super(SelectBooleanCheckbox.class);
    }
    
    public SelectBooleanCheckboxBuilder selected() {
        this.selected = true;
        return this;
    }
    
    public SelectBooleanCheckboxBuilder unselected() {
        this.selected = false;
        return this;
    }

    public SelectBooleanCheckboxBuilder disabled() {
        this.disabled = true;
        return this;
    }

    @Override
    public SelectBooleanCheckbox build() {
        SelectBooleanCheckbox component = super.build();
        if (selected != null) {
            component.setSelected(selected);
        }
        
        component.setDisabled(disabled);
        return component;
    }
}
