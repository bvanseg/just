package com.bvanseg.just.functional.function;

import com.bvanseg.just.functional.function.memo.Memo15;
import com.bvanseg.just.functional.tuple.Tuple15;

@FunctionalInterface
public interface Function15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, R> {

    R apply(
        A1 a1,
        A2 a2,
        A3 a3,
        A4 a4,
        A5 a5,
        A6 a6,
        A7 a7,
        A8 a8,
        A9 a9,
        A10 a10,
        A11 a11,
        A12 a12,
        A13 a13,
        A14 a14,
        A15 a15
    );

    default <Z> Function15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, Z> andThen(
        Function<? super R, ? extends Z> after
    ) {
        return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) -> after.apply(
            this.apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15)
        );
    }

    default Memo15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, R> memoize() {
        return new Memo15<>(this);
    }

    default Function<A1, Function<A2, Function<A3, Function<A4, Function<A5, Function<A6, Function<A7, Function<A8, Function<A9, Function<A10, Function<A11, Function<A12, Function<A13, Function<A14, Function<A15, R>>>>>>>>>>>>>>> curried() {
        return a1 -> a2 -> a3 -> a4 -> a5 -> a6 -> a7 -> a8 -> a9 -> a10 -> a11 -> a12 -> a13 -> a14 -> a15 -> this
            .apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
    }

    default Function<Tuple15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15>, R> tupled() {
        return tuple -> this.apply(
            tuple.v1(),
            tuple.v2(),
            tuple.v3(),
            tuple.v4(),
            tuple.v5(),
            tuple.v6(),
            tuple.v7(),
            tuple.v8(),
            tuple.v9(),
            tuple.v10(),
            tuple.v11(),
            tuple.v12(),
            tuple.v13(),
            tuple.v14(),
            tuple.v15()
        );
    }

    default Function14<A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, R> partialFirst(A1 fixed) {
        return (a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15) -> this.apply(
            fixed,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7,
            a8,
            a9,
            a10,
            a11,
            a12,
            a13,
            a14,
            a15
        );
    }

    default Function14<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, R> partialLast(A15 fixed) {
        return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14) -> this.apply(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7,
            a8,
            a9,
            a10,
            a11,
            a12,
            a13,
            a14,
            fixed
        );
    }

    static <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, R> Function15<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15, R> from(
        Function<? super A1, ? extends Function<? super A2, ? extends Function<? super A3, ? extends Function<? super A4, ? extends Function<? super A5, ? extends Function<? super A6, ? extends Function<? super A7, ? extends Function<? super A8, ? extends Function<? super A9, ? extends Function<? super A10, ? extends Function<? super A11, ? extends Function<? super A12, ? extends Function<? super A13, ? extends Function<? super A14, ? extends Function<? super A15, ? extends R>>>>>>>>>>>>>>> curried
    ) {
        return (
            A1 a1,
            A2 a2,
            A3 a3,
            A4 a4,
            A5 a5,
            A6 a6,
            A7 a7,
            A8 a8,
            A9 a9,
            A10 a10,
            A11 a11,
            A12 a12,
            A13 a13,
            A14 a14,
            A15 a15
        ) -> curried.apply(a1)
            .apply(a2)
            .apply(a3)
            .apply(a4)
            .apply(a5)
            .apply(a6)
            .apply(a7)
            .apply(a8)
            .apply(a9)
            .apply(a10)
            .apply(a11)
            .apply(a12)
            .apply(a13)
            .apply(a14)
            .apply(a15);
    }
}
