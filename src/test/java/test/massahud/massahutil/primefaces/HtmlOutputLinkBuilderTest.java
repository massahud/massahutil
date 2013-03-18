/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.primefaces;

import javax.el.ValueExpression;
import javax.faces.component.html.HtmlOutputLink;
import massahud.massahutil.primefaces.HtmlOutputLinkBuilder;
import static org.fest.assertions.Assertions.*;
import static org.mockito.Mockito.*;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class HtmlOutputLinkBuilderTest {

    public void shouldCreateHtmlOutputLinkWithDefaults() {
        final HtmlOutputLink htmlOutputLink = HtmlOutputLinkBuilder.createNew().build();
        assertThat(htmlOutputLink).isNotNull();
        assertThat(htmlOutputLink.getValue()).isNull();
        assertThat(htmlOutputLink.getChildCount()).isZero();
    }

    public void shouldAddStyleClasses() {
        final String styleClass1 = "class-1";
        final String styleClass2 = "class-2";
        final HtmlOutputLink htmlOutputLink = HtmlOutputLinkBuilder.createNew()
                .withStyleClass(styleClass1)
                .withStyleClass(styleClass2)
                .build();
        assertThat(htmlOutputLink.getStyleClass()).isEqualTo(styleClass1 + " " + styleClass2);
    }

    public void shouldSetId() {
        final String id = "myId";
        final HtmlOutputLink htmlOutputLink = HtmlOutputLinkBuilder.createNew()
                .withId(id)
                .build();
        assertThat(htmlOutputLink.getId()).isEqualTo(id);
    }

    public void shouldSetValue() {
        final String value = "lorem ipsum";
        final HtmlOutputLink htmlOutputLink = HtmlOutputLinkBuilder.createNew()
                .withValue(value)
                .build();
        assertThat(htmlOutputLink.getValue()).isEqualTo(value);
    }

    public void shouldSetValueExpression() {
        final String property = "value";
        ValueExpression expression = mock(ValueExpression.class);

        final HtmlOutputLink htmlOutputLink = HtmlOutputLinkBuilder.createNew()
                .withValueExpression(property, expression)
                .build();
        assertThat(htmlOutputLink.getValueExpression(property)).isEqualTo(expression);
    }
}
