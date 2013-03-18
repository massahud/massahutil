/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import javax.faces.component.html.HtmlOutputLink;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder that builds OutputPanels
 * 
 * @author massahud
 */
public class HtmlOutputLinkBuilder extends PrimefacesComponentBuilderBase<HtmlOutputLink> {
    
    private String value;       
    
    public static HtmlOutputLinkBuilder createNew() {
        return new HtmlOutputLinkBuilder();
    }

    public HtmlOutputLinkBuilder() {
        super(HtmlOutputLink.class);
    }   
    
    public HtmlOutputLinkBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public HtmlOutputLink build() {
        HtmlOutputLink component = super.build();        
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        return component;
    }        
    
        
}
