package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        return stream.reduce(new ArrayList<O>(), (List<O> acc, I x) -> {
            ArrayList arrayList = new ArrayList<O>(acc);
            arrayList.add(mapper.apply(x));
            return arrayList;
        }, (List<O> left, List<O> right) -> {
            List<O> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

}
