/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;
import org.primefaces.component.outputpanel.OutputPanel;

/**
 * Builder that builds OutputPanels
 * 
 * @author massahud
 */
public class OutputPanelBuilder extends PrimefacesComponentBuilderBase<OutputPanel, OutputPanelBuilder> {
    
    private boolean layoutblock = false;
    
    public static OutputPanelBuilder createNew() {
        return new OutputPanelBuilder();
    }

    protected OutputPanelBuilder() {
        super(OutputPanel.class);
    }
    
    public OutputPanelBuilder withBlockLayout() {
        layoutblock = true;
        return this;
    }

    @Override
    public OutputPanel build() {
        OutputPanel component = super.build();
        if (layoutblock) {
            component.setLayout("block");
        }        
        return component;
    }
    
        
}
