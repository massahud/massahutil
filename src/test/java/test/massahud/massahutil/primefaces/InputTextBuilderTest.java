/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.el.ValueExpression;
import javax.faces.component.behavior.ClientBehavior;
import massahud.massahutil.primefaces.InputTextBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.primefaces.component.inputtext.InputText;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class InputTextBuilderTest {

    public void shouldCreateInputTextWithDefaults() {
        final InputText inputText = InputTextBuilder.createNew().build();
        assertThat(inputText).isNotNull();
        assertThat(inputText.getValue()).isNull();
        assertThat(inputText.getChildCount()).isZero();
        assertThat(inputText.isDisabled()).isFalse();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final InputText inputText = InputTextBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(inputText.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final InputText inputText = InputTextBuilder.createNew()
                .withId(id)
                .build();
        assertThat(inputText.getId()).isEqualTo(id);
    }

    public void shouldSetValue() {
        final String value = "lorem ipsum";
        final InputText inputText = InputTextBuilder.createNew()
                .withValue(value)
                .build();
        assertThat(inputText.getValue()).isEqualTo(value);
    }

    public void shouldSetValueExpression() {
        final String property = "value";
        final ValueExpression expression = mock(ValueExpression.class);

        final InputText inputText = InputTextBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(inputText.getValueExpression(property)).isEqualTo(expression);
    }

    public void shouldAddClientBehavior() {
        final String event = "change";
        final ClientBehavior behavior = mock(ClientBehavior.class);
        final InputText inputText = InputTextBuilder.createNew()
                .withClientBehavior(event, behavior)
                .build();
        assertThat(inputText.getClientBehaviors().get(event)).contains(behavior);
    }
    
    public void shouldDisable() {
        final InputText inputText = InputTextBuilder.createNew()
                .disabled()
                .build();
        assertThat(inputText.isDisabled()).isTrue();
    }
    
    public void shouldSetMaxLength() {
        final int maxLength = 255;
        final InputText inputText = InputTextBuilder.createNew()
                .withMaxLength(maxLength)
                .build();
        assertThat(inputText.getMaxlength()).isEqualTo(maxLength);
    }
}
