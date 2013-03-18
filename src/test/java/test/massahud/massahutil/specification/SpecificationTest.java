/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.massahud.massahutil.specification;

import massahud.massahutil.specification.Specification;
import static org.fest.assertions.Assertions.*;
import org.testng.annotations.Test;

/**
 *
 * @author massahud
 */
@Test
public class SpecificationTest {

    final True sTrue = new True();
    final False sFalse = new False();
    final Object object = new Object();

    class True extends Specification<Object> {

        @Override
        public boolean isSatisfiedBy(Object obj) {
            return true;
        }
    }

    class False extends Specification<Object> {

        @Override
        public boolean isSatisfiedBy(Object obj) {
            return false;
        }
    }

    public void testAnd() {
        assertThat(sTrue.and(sFalse).isSatisfiedBy(object)).isFalse();
        assertThat(sFalse.and(sTrue).isSatisfiedBy(object)).isFalse();
        assertThat(sFalse.and(sFalse).isSatisfiedBy(object)).isFalse();
        assertThat(sTrue.and(sTrue).isSatisfiedBy(object)).isTrue();
    }

    public void testOr() {
        assertThat(sTrue.or(sFalse).isSatisfiedBy(object)).isTrue();
        assertThat(sFalse.or(sTrue).isSatisfiedBy(object)).isTrue();
        assertThat(sFalse.or(sFalse).isSatisfiedBy(object)).isFalse();
        assertThat(sTrue.or(sTrue).isSatisfiedBy(object)).isTrue();
    }

    public void testNot() {
        assertThat(sTrue.not().isSatisfiedBy(object)).isFalse();
        assertThat(sFalse.not().isSatisfiedBy(object)).isTrue();
    }
    
    public void testBooleanChain() {
        assertThat(sTrue.and(sFalse.or(sTrue)).isSatisfiedBy(object)).isEqualTo(true && (false || true));
        assertThat(sTrue.and(sFalse).or(sTrue).isSatisfiedBy(object)).isEqualTo(true && false || true);
        assertThat(sTrue.or(sFalse).and(sTrue).isSatisfiedBy(object)).isEqualTo(true || false && true);        
        assertThat(sTrue.and(sFalse).and(sTrue).isSatisfiedBy(object)).isEqualTo(true && false && true);
        assertThat(sTrue.and(sFalse.not()).and(sTrue).isSatisfiedBy(object)).isEqualTo(true && (!false) && true);
        assertThat(sTrue.and((sFalse.and(sTrue)).not()).isSatisfiedBy(object)).isEqualTo(true && (!(false && true)));
        assertThat(sTrue.and(sFalse).or(sTrue).isSatisfiedBy(object)).isEqualTo(true && false || true);
        assertThat(sTrue.and(sFalse).or(sFalse.not()).and(sTrue).isSatisfiedBy(object)).isEqualTo(true && false || !false && true);
        assertThat(sTrue.and(sFalse).or(sFalse).or(sTrue).isSatisfiedBy(object)).isEqualTo(true);
    }
}
