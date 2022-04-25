package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        return stream.reduce(new ArrayList<I>(), (List<I> acc, I t) -> {
            List<I> newList = new ArrayList<>(acc);
            if (predicate.test(t)){
                newList.add(t);
            }
            return newList;
        }, (List<I> left, List<I> right) -> {
            List<I> newLeft = new ArrayList<>(left);
            newLeft.addAll(right);
            return newLeft;
        });
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.forEach(consumerStrFunction);
    }
    static Consumer<String> consumerStrFunction = str -> {
        System.out.println(str);
    };

}
