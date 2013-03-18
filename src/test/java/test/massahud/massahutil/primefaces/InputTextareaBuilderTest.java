/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.el.ValueExpression;
import javax.faces.component.behavior.ClientBehavior;
import massahud.massahutil.primefaces.InputTextareaBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.primefaces.component.inputtextarea.InputTextarea;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class InputTextareaBuilderTest {

    public void shouldCreateInputTextWithDefaults() {
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew().build();
        assertThat(inputTextarea).isNotNull();
        assertThat(inputTextarea.getValue()).isNull();
        assertThat(inputTextarea.getChildCount()).isZero();
        assertThat(inputTextarea.isDisabled()).isFalse();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(inputTextarea.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .withId(id)
                .build();
        assertThat(inputTextarea.getId()).isEqualTo(id);
    }

    public void shouldSetValue() {
        final String value = "lorem ipsum";
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .withValue(value)
                .build();
        assertThat(inputTextarea.getValue()).isEqualTo(value);
    }

    public void shouldSetValueExpression() {
        final String property = "value";
        final ValueExpression expression = mock(ValueExpression.class);

        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(inputTextarea.getValueExpression(property)).isEqualTo(expression);
    }

    public void shouldAddClientBehavior() {
        final String event = "change";
        final ClientBehavior behavior = mock(ClientBehavior.class);
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .withClientBehavior(event, behavior)
                .build();
        assertThat(inputTextarea.getClientBehaviors().get(event)).contains(behavior);
    }
    
    public void shouldDisable() {
        final InputTextarea inputTextarea = InputTextareaBuilder.createNew()
                .disabled()
                .build();
        assertThat(inputTextarea.isDisabled()).isTrue();
    }
}
