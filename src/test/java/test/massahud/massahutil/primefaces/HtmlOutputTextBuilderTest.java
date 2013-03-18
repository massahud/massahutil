/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.el.ValueExpression;
import javax.faces.component.html.HtmlOutputText;
import massahud.massahutil.primefaces.HtmlOutputTextBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class HtmlOutputTextBuilderTest {

    public void shouldCreateHtmlOutputTextWithDefaults() {
        final HtmlOutputText htmlOutputText = HtmlOutputTextBuilder.createNew().build();
        assertThat(htmlOutputText).isNotNull();
        assertThat(htmlOutputText.getValue()).isNull();
        assertThat(htmlOutputText.getChildCount()).isZero();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final HtmlOutputText htmlOutputText = HtmlOutputTextBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(htmlOutputText.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final HtmlOutputText htmlOutputText = HtmlOutputTextBuilder.createNew()
                .withId(id)
                .build();
        assertThat(htmlOutputText.getId()).isEqualTo(id);
    }

    public void shouldSetValue() {
        final String value = "lorem ipsum";
        final HtmlOutputText htmlOutputText = HtmlOutputTextBuilder.createNew()
                .withValue(value)
                .build();
        assertThat(htmlOutputText.getValue()).isEqualTo(value);
    }

    public void shouldSetValueExpression() {
        final String property = "value";
        ValueExpression expression = mock(ValueExpression.class);

        final HtmlOutputText htmlOutputText = HtmlOutputTextBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(htmlOutputText.getValueExpression(property)).isEqualTo(expression);
    }
}
