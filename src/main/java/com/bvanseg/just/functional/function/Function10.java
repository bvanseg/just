package com.bvanseg.just.functional.function;

import com.bvanseg.just.functional.function.memo.Memo10;
import com.bvanseg.just.functional.tuple.Tuple10;

@FunctionalInterface
public interface Function10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, R> {

    R apply(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10);

    default <Z> Function10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, Z> andThen(Function<? super R, ? extends Z> after) {
        return (a1, a2, a3, a4, a5, a6, a7, a8, a9, a10) -> after.apply(
            this.apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10)
        );
    }

    default Memo10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, R> memoize() {
        return new Memo10<>(this);
    }

    default Function<A1, Function<A2, Function<A3, Function<A4, Function<A5, Function<A6, Function<A7, Function<A8, Function<A9, Function<A10, R>>>>>>>>>> curried() {
        return a1 -> a2 -> a3 -> a4 -> a5 -> a6 -> a7 -> a8 -> a9 -> a10 -> this.apply(
            a1,
            a2,
            a3,
            a4,
            a5,
            a6,
            a7,
            a8,
            a9,
            a10
        );
    }

    default Function<Tuple10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10>, R> tupled() {
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
            tuple.v10()
        );
    }

    default Function9<A2, A3, A4, A5, A6, A7, A8, A9, A10, R> partialFirst(A1 fixed) {
        return (a2, a3, a4, a5, a6, a7, a8, a9, a10) -> this.apply(fixed, a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }

    default Function9<A1, A2, A3, A4, A5, A6, A7, A8, A9, R> partialLast(A10 fixed) {
        return (a1, a2, a3, a4, a5, a6, a7, a8, a9) -> this.apply(a1, a2, a3, a4, a5, a6, a7, a8, a9, fixed);
    }

    static <A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, R> Function10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, R> from(
        Function<? super A1, ? extends Function<? super A2, ? extends Function<? super A3, ? extends Function<? super A4, ? extends Function<? super A5, ? extends Function<? super A6, ? extends Function<? super A7, ? extends Function<? super A8, ? extends Function<? super A9, ? extends Function<? super A10, ? extends R>>>>>>>>>> curried
    ) {
        return (A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8, A9 a9, A10 a10) -> curried.apply(a1)
            .apply(a2)
            .apply(a3)
            .apply(a4)
            .apply(a5)
            .apply(a6)
            .apply(a7)
            .apply(a8)
            .apply(a9)
            .apply(a10);
    }
}
