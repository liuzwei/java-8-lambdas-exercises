package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Question1 {
    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (initial, sum) -> initial + sum);
    }

    public static List<String> getNamesAndOrigins(List<Artist> artists) {
        return artists.stream().flatMap(artist -> {
            return Stream.of(artist.getName(), artist.getNationality());
        }).collect(toList());
    }

    public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
        return input.stream().filter(album -> album.getTrackList().size() <= 3).collect(toList());
    }

    public static void main(String[] args) {
        int i = addUp(Stream.of(1, 2, 3, 4));
        System.out.println("i is "+i);
    }
}
