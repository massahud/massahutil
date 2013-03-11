package massahud.massahutil.specification;

/**
 * Base interface for Specification pattern
 *
 * @author massahud
 */
public abstract class Specification<T> {

    /**
     * returns true if the object satisfies this specification
     *
     * @param obj object that will be tested
     */
    public abstract boolean isSatisfiedBy(T obj);

    /**
     * Combines this specification with the one passed into one specification
     * that must satisfy both.
     *
     * @param spec the specification that will be combined with this one
     * @return a specification that must satisfy both specifications
     */
    public Specification<T> and(Specification<T> spec) {
        return new AndSpecification<T>(this, spec);
    }

    /**
     * Combines this specification with the one passed into one specification
     * that must satisfy any of them.
     *
     * @param spec the specification that will be combined with this one
     * @return a specification that must satisfy any specification
     */
    public Specification<T> or(Specification<T> spec) {
        return new OrSpecification<T>(this, spec);
    }

    /**
     * Creates a specification that is negates this one
     *
     * @return a specification that negates this specification
     */
    public Specification<T> not() {
        return new NotSpecification<T>(this);
    }

    class AndSpecification<T> extends Specification<T> {

        private Specification<T> spec1;
        private Specification<T> spec2;

        public AndSpecification(Specification<T> spec1, Specification<T> spec2) {
            this.spec1 = spec1;
            this.spec2 = spec2;
        }

        @Override
        public boolean isSatisfiedBy(T obj) {
            return spec1.isSatisfiedBy(obj) && spec2.isSatisfiedBy(obj);
        }
    }

    class OrSpecification<T> extends Specification<T> {

        private Specification<T> spec1;
        private Specification<T> spec2;

        public OrSpecification(Specification<T> spec1, Specification<T> spec2) {
            this.spec1 = spec1;
            this.spec2 = spec2;
        }

        @Override
        public boolean isSatisfiedBy(T obj) {
            return spec1.isSatisfiedBy(obj) || spec2.isSatisfiedBy(obj);
        }
    }

    class NotSpecification<T> extends Specification<T> {

        private Specification<T> spec;

        public NotSpecification(Specification<T> spec) {
            this.spec = spec;
        }

        @Override
        public boolean isSatisfiedBy(T obj) {
            return !spec.isSatisfiedBy(obj);
        }
    }
}
