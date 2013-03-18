/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package massahud.massahutil.primefaces;

import javax.faces.component.UIComponent;
import org.primefaces.component.panelgrid.PanelGrid;

/**
 * Builder that builds PanelGrids
 *
 * @author massahud
 */
public class PanelGridBuilder extends PrimefacesComponentBuilderBase<PanelGrid> {

    public static PanelGridBuilder createNew() {
        return new PanelGridBuilder();
    }
    private Integer columns;
    private UIComponent header;
    private UIComponent footer;

    protected PanelGridBuilder() {
        super(PanelGrid.class);
    }

    public PanelGridBuilder withColumns(int cols) {
        this.columns = cols;
        return this;
    }

    public PanelGridBuilder withHeader(UIComponent header) {
        this.header = header;
        return this;
    }

    public PanelGridBuilder withFooter(UIComponent footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public PanelGrid build() {
        PanelGrid component = super.build();
        if (columns != null) {
            component.setColumns(columns);
        }
        if (header != null) {
            component.getFacets().put("header", header);
        }
        if (footer != null) {
            component.getFacets().put("footer", footer);
        }
        return component;
    }
}
