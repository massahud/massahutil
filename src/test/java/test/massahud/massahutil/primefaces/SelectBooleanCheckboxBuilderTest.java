/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.el.ValueExpression;
import javax.faces.component.behavior.ClientBehavior;
import massahud.massahutil.primefaces.SelectBooleanCheckboxBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.primefaces.component.selectbooleancheckbox.SelectBooleanCheckbox;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class SelectBooleanCheckboxBuilderTest {

    public void shouldCreateInputTextWithDefaults() {
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew().build();
        assertThat(selectBooleanCheckbox).isNotNull();
        assertThat(selectBooleanCheckbox.getValue()).isNull();
        assertThat(selectBooleanCheckbox.getChildCount()).isZero();
        assertThat(selectBooleanCheckbox.isDisabled()).isFalse();
        assertThat(selectBooleanCheckbox.isSelected()).isFalse();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(selectBooleanCheckbox.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .withId(id)
                .build();
        assertThat(selectBooleanCheckbox.getId()).isEqualTo(id);
    }    

    public void shouldSetValueExpression() {
        final String property = "value";
        final ValueExpression expression = mock(ValueExpression.class);

        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(selectBooleanCheckbox.getValueExpression(property)).isEqualTo(expression);
    }

    public void shouldAddClientBehavior() {
        final String event = "change";
        final ClientBehavior behavior = mock(ClientBehavior.class);
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .withClientBehavior(event, behavior)
                .build();
        assertThat(selectBooleanCheckbox.getClientBehaviors().get(event)).contains(behavior);
    }
    
    public void shouldDisable() {
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .disabled()
                .build();
        assertThat(selectBooleanCheckbox.isDisabled()).isTrue();
    }
    
    public void shouldSetSelected() {
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .selected()
                .build();
        assertThat(selectBooleanCheckbox.isSelected()).isTrue();
    }
    
    public void shouldSetUnselected() {
        final SelectBooleanCheckbox selectBooleanCheckbox = SelectBooleanCheckboxBuilder.createNew()
                .unselected()
                .build();
        assertThat(selectBooleanCheckbox.isSelected()).isFalse();
    }
}
