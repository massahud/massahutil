/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.faces.component.UIComponent;
import massahud.massahutil.primefaces.OutputPanelBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.primefaces.component.outputpanel.OutputPanel;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class OutputPanelBuilderTest {

    public void shouldCreateOutputPanelWithDefaults() {
        final OutputPanel outputPanel = OutputPanelBuilder.createNew().build();
        assertThat(outputPanel).isNotNull();
        assertThat(outputPanel.getChildCount()).isZero();
    }

    public void shouldAddChildren() {
        final UIComponent filho1 = mock(UIComponent.class);
        final UIComponent filho2 = mock(UIComponent.class);
        final OutputPanel outputPanel = OutputPanelBuilder.createNew()
                .withChild(filho1)
                .withChild(filho2)
                .build();

        assertThat(outputPanel.getChildCount()).isEqualTo(2);
        assertThat(outputPanel.getChildren()).containsExactly(filho1, filho2);
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final OutputPanel outputPanel = OutputPanelBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(outputPanel.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }
    
    public void shouldSetId() {
        final String id = "myId";
        final OutputPanel outputPanel = OutputPanelBuilder.createNew()
                .withId(id)
                .build();
        assertThat(outputPanel.getId()).isEqualTo(id);
    }
    
    public void shouldSetBlockLayout() {
        final OutputPanel outputPanel = OutputPanelBuilder.createNew()
                .setLayoutBlock()
                .build();
        assertThat(outputPanel.getLayout()).isEqualTo("block");
    }
}
