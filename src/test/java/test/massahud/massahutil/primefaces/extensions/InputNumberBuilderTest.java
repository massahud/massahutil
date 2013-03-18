/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces.extensions;

import javax.el.ValueExpression;
import javax.faces.component.behavior.ClientBehavior;
import massahud.massahutil.primefaces.extensions.InputNumberBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;

import org.primefaces.extensions.component.inputnumber.InputNumber;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class InputNumberBuilderTest {

    public void shouldCreateInputNumberWithDefaults() {
        final InputNumber inputNumber = InputNumberBuilder.createNew().build();
        assertThat(inputNumber).isNotNull();
        assertThat(inputNumber.getValue()).isNull();
        assertThat(inputNumber.getChildCount()).isZero();
        assertThat(inputNumber.isDisabled()).isFalse();
        assertThat(inputNumber.getEmptyValue()).isEqualTo("empty");
        assertThat(inputNumber.getDecimalPlaces()).isEmpty();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(inputNumber.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withId(id)
                .build();
        assertThat(inputNumber.getId()).isEqualTo(id);
    }

    public void shouldSetValue() {
        final String value = "lorem ipsum";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withValue(value)
                .build();
        assertThat(inputNumber.getValue()).isEqualTo(value);
    }

    public void shouldSetValueExpression() {
        final String property = "value";
        final ValueExpression expression = mock(ValueExpression.class);

        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(inputNumber.getValueExpression(property)).isEqualTo(expression);
    }

    public void shouldAddClientBehavior() {
        final String event = "change";
        final ClientBehavior behavior = mock(ClientBehavior.class);
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withClientBehavior(event, behavior)
                .build();
        assertThat(inputNumber.getClientBehaviors().get(event)).contains(behavior);
    }
    
    public void shouldDisable() {
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .disabled()
                .build();
        assertThat(inputNumber.isDisabled()).isTrue();
    }
    
    public void shouldSetMaxLength() {
        final int maxLength = 255;
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withMaxLength(maxLength)
                .build();
        assertThat(inputNumber.getMaxlength()).isEqualTo(maxLength);
    }
    
    public void shouldSetOnFocus() {
        final String onFocus = "return true";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withOnfocus(onFocus)
                .build();
        assertThat(inputNumber.getOnfocus()).isEqualTo(onFocus);
    }
    
    public void shouldSetSeparators() {
        final String decimalSeparator = ",";
        final String thousandSeparator = ".";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withDecimalSeparator(decimalSeparator)
                .withThousandSeparator(thousandSeparator)
                .build();
        assertThat(inputNumber.getDecimalSeparator()).isEqualTo(decimalSeparator);
        assertThat(inputNumber.getThousandSeparator()).isEqualTo(thousandSeparator);
    }

    public void shouldSetEmptyValue() {
        final String emptyValue = "zero";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withEmptyValue(emptyValue)                
                .build();
        assertThat(inputNumber.getEmptyValue()).isEqualTo(emptyValue);
    }
    
    public void shoudlSetDecimalPlaces() {
        final String decimalPlaces = "3";
        final InputNumber inputNumber = InputNumberBuilder.createNew()
                .withDecimalPlaces(decimalPlaces)
                .build();        
        assertThat(inputNumber.getDecimalPlaces()).isEqualTo(decimalPlaces);
    }
    
}
