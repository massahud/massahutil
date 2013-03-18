/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import massahud.massahutil.primefaces.extensions.InputNumberBuilder;

/**
 *
 * @author massahud
 */
public class PrimefacesComponentBuilderFactory {
    private PrimefacesComponentBuilderFactory() {}
    
    public static OutputPanelBuilder newOutputPanel() {
        return OutputPanelBuilder.createNew();
    }
    
    public static HtmlOutputTextBuilder newOutputText() {
        return HtmlOutputTextBuilder.createNew();
    }
    
    public static HtmlOutputLinkBuilder newOutputLink() {
        return HtmlOutputLinkBuilder.createNew();
    }
    
    public static InputTextBuilder newInputText() {
        return InputTextBuilder.createNew();
    }
    
    public static InputTextareaBuilder newInputTextarea() {
        return InputTextareaBuilder.createNew();        
    }
    
    public static InputNumberBuilder newInputNumber() {
        return InputNumberBuilder.createNew();
    }
    
    public static SelectBooleanCheckboxBuilder newSelectBooleanCheckbox() {
        return SelectBooleanCheckboxBuilder.createNew();
    }
}
