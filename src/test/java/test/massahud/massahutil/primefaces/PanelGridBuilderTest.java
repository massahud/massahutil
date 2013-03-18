/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.faces.component.UIComponent;
import massahud.massahutil.primefaces.PanelGridBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.primefaces.component.panelgrid.PanelGrid;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class PanelGridBuilderTest {

    public void shouldCreatePanelGridWithDefaults() {
        final PanelGrid panelGrid = PanelGridBuilder.createNew().build();
        assertThat(panelGrid).isNotNull();
        assertThat(panelGrid.getChildCount()).isZero();
        assertThat(panelGrid.getColumns()).isEqualTo(0);
    }

    public void shouldAddChildren() {
        final UIComponent filho1 = mock(UIComponent.class);
        final UIComponent filho2 = mock(UIComponent.class);
        final PanelGrid panelGrid = PanelGridBuilder.createNew()
                .withChild(filho1)
                .withChild(filho2)
                .build();

        assertThat(panelGrid.getChildCount()).isEqualTo(2);
        assertThat(panelGrid.getChildren()).containsExactly(filho1, filho2);
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final PanelGrid panelGrid = PanelGridBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(panelGrid.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }
    
    public void shouldSetId() {
        final String id = "myId";
        final PanelGrid panelGrid = PanelGridBuilder.createNew()
                .withId(id)
                .build();
        assertThat(panelGrid.getId()).isEqualTo(id);
    }
    
    public void shouldSetColumns() {
        final int cols = 6;
        final PanelGrid panelGrid = PanelGridBuilder.createNew()
                .withColumns(cols)                
                .build();        
        assertThat(panelGrid.getColumns()).isEqualTo(cols);
    }
    
    public void shouldSetHeaderFooter() {
        final UIComponent header = mock(UIComponent.class);
        final UIComponent footer = mock(UIComponent.class);
        final PanelGrid panelGrid = PanelGridBuilder.createNew()
                .withHeader(header)
                .withFooter(footer)
                .build();        
        assertThat(panelGrid.getFacet("header")).isEqualTo(header);
        assertThat(panelGrid.getFacet("footer")).isEqualTo(footer);
    }
}
