package com.bvanseg.just.functional.function.memo;

import java.util.function.BiPredicate;

import com.bvanseg.just.functional.function.Function8;

public class Memo8<A1, A2, A3, A4, A5, A6, A7, A8, R> implements Function8<A1, A2, A3, A4, A5, A6, A7, A8, R> {

    private A1 a1Ref;

    private A2 a2Ref;

    private A3 a3Ref;

    private A4 a4Ref;

    private A5 a5Ref;

    private A6 a6Ref;

    private A7 a7Ref;

    private A8 a8Ref;

    private R cachedResult;

    private final Function8<A1, A2, A3, A4, A5, A6, A7, A8, R> fn;

    private final BiPredicate<A1, A1> eq1;

    private final BiPredicate<A2, A2> eq2;

    private final BiPredicate<A3, A3> eq3;

    private final BiPredicate<A4, A4> eq4;

    private final BiPredicate<A5, A5> eq5;

    private final BiPredicate<A6, A6> eq6;

    private final BiPredicate<A7, A7> eq7;

    private final BiPredicate<A8, A8> eq8;

    public Memo8(Function8<A1, A2, A3, A4, A5, A6, A7, A8, R> fn) {
        this(
            fn,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef,
            (oldRef, newRef) -> newRef == oldRef
        );
    }

    public Memo8(
        Function8<A1, A2, A3, A4, A5, A6, A7, A8, R> fn,
        BiPredicate<A1, A1> eq1,
        BiPredicate<A2, A2> eq2,
        BiPredicate<A3, A3> eq3,
        BiPredicate<A4, A4> eq4,
        BiPredicate<A5, A5> eq5,
        BiPredicate<A6, A6> eq6,
        BiPredicate<A7, A7> eq7,
        BiPredicate<A8, A8> eq8
    ) {
        this.fn = fn;
        this.eq1 = eq1;
        this.eq2 = eq2;
        this.eq3 = eq3;
        this.eq4 = eq4;
        this.eq5 = eq5;
        this.eq6 = eq6;
        this.eq7 = eq7;
        this.eq8 = eq8;
    }

    @Override
    public R apply(A1 a1, A2 a2, A3 a3, A4 a4, A5 a5, A6 a6, A7 a7, A8 a8) {
        if (
            eq1.test(a1Ref, a1) && eq2.test(a2Ref, a2) && eq3.test(a3Ref, a3) && eq4.test(a4Ref, a4) && eq5.test(
                a5Ref,
                a5
            ) && eq6.test(a6Ref, a6) && eq7.test(a7Ref, a7) && eq8.test(a8Ref, a8)
        ) {
            return cachedResult;
        }

        this.cachedResult = fn.apply(a1, a2, a3, a4, a5, a6, a7, a8);
        this.a1Ref = a1;
        this.a2Ref = a2;
        this.a3Ref = a3;
        this.a4Ref = a4;
        this.a5Ref = a5;
        this.a6Ref = a6;
        this.a7Ref = a7;
        this.a8Ref = a8;
        return cachedResult;
    }
}
