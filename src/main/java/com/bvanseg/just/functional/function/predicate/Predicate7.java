package com.bvanseg.just.functional.function.predicate;

import com.bvanseg.just.functional.function.Function7;

@FunctionalInterface
public interface Predicate7<A1, A2, A3, A4, A5, A6, A7> extends Function7<A1, A2, A3, A4, A5, A6, A7, Boolean> {

    boolean test(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7);

    @Override
    default Boolean apply(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
        return test(a1, a2, a3, a4, a5, a6, a7);
    }

    @Override
    default Predicate6<A2, A3, A4, A5, A6, A7> partialFirst(A1 fixed) {
        return Function7.super.partialFirst(fixed)::apply;
    }

    @Override
    default Predicate6<A1, A2, A3, A4, A5, A6> partialLast(A7 fixed) {
        return Function7.super.partialLast(fixed)::apply;
    }

    default Predicate7<A1, A2, A3, A4, A5, A6, A7> and(
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> other
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> this.test(a1, a2, a3, a4, a5, a6, a7) && other.test(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7
        );
    }

    default Predicate7<A1, A2, A3, A4, A5, A6, A7> or(
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> other
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> this.test(a1, a2, a3, a4, a5, a6, a7) || other.test(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7
        );
    }

    default Predicate7<A1, A2, A3, A4, A5, A6, A7> xor(
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> other
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> this.test(a1, a2, a3, a4, a5, a6, a7) ^ other.test(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7
        );
    }

    default Predicate7<A1, A2, A3, A4, A5, A6, A7> implies(
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> other
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> !this.test(a1, a2, a3, a4, a5, a6, a7) || other.test(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7
        );
    }

    default Predicate7<A1, A2, A3, A4, A5, A6, A7> negate() {
        return (a1, a2, a3, a4, a5, a6, a7) -> !this.test(a1, a2, a3, a4, a5, a6, a7);
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> lift(
        Predicate6<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6> predicate
    ) {
        return (a1, a2, a3, a4, a5, a6, $7) -> predicate.test(a1, a2, a3, a4, a5, a6);
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> alwaysTrue() {
        return ($1, $2, $3, $4, $5, $6, $7) -> true;
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> alwaysFalse() {
        return ($1, $2, $3, $4, $5, $6, $7) -> false;
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> not(
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> predicate
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> !predicate.test(a1, a2, a3, a4, a5, a6, a7);
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> from(
        java.util.function.Function<? super A1, ? extends java.util.function.Function<? super A2, ? extends java.util.function.Function<? super A3, ? extends java.util.function.Function<? super A4, ? extends java.util.function.Function<? super A5, ? extends java.util.function.Function<? super A6, ? extends java.util.function.Function<? super A7, Boolean>>>>>>> fn
    ) {
        return (a1, a2, a3, a4, a5, a6, a7) -> fn.apply(a1).apply(a2).apply(a3).apply(a4).apply(a5).apply(a6).apply(a7);
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> from(
        Function7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7, Boolean> fn
    ) {
        return fn::apply;
    }

    static <A1, A2, A3, A4, A5, A6, A7> Predicate7<A1, A2, A3, A4, A5, A6, A7> named(
        String name,
        Predicate7<? super A1, ? super A2, ? super A3, ? super A4, ? super A5, ? super A6, ? super A7> delegate
    ) {
        return new Predicate7<>() {

            @Override
            public boolean test(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7) {
                return delegate.test(a1, a2, a3, a4, a5, a6, a7);
            }

            @Override
            public String toString() {
                return "Predicate7." + name;
            }
        };
    }

}
