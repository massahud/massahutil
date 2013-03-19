/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import javax.faces.component.html.HtmlOutputText;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder that builds OutputPanels
 *
 * @author massahud
 */
public class HtmlOutputTextBuilder extends PrimefacesComponentBuilderBase<HtmlOutputText, HtmlOutputTextBuilder> {

    private String value;

    public static HtmlOutputTextBuilder createNew() {
        return new HtmlOutputTextBuilder();
    }
    private Boolean noescape;

    public HtmlOutputTextBuilder() {
        super(HtmlOutputText.class);
    }

    public HtmlOutputTextBuilder withValue(String value) {
        this.value = value;
        return this;
    }

    @Override
    public HtmlOutputText build() {
        HtmlOutputText component = super.build();
        if (StringUtils.isNotEmpty(value)) {
            component.setValue(value);
        }
        if (noescape != null) {
            component.setEscape(noescape);
        }
        return component;
    }

    public HtmlOutputTextBuilder withNoEscape() {
        this.noescape = true;
        return this;
    }
}
