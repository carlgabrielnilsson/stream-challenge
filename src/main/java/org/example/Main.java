package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        final int[] nCounter = {31};

        Stream<String> bStream = IntStream.rangeClosed(1, 15)
                .mapToObj(num -> "B" + num);

        Stream<String> iStream = Stream.iterate(16, n -> n + 1)
                .limit(15)
                .map(num -> "I" + num);

        Stream<String> nStream = Stream.generate(() -> nCounter[0]++)
                .limit(15)
                .map(num -> "N" + num);

        Integer[] gNumbers = IntStream.rangeClosed(46, 60)
                .boxed()
                .toArray(Integer[]::new);
        Stream<String> gStream = Arrays.stream(gNumbers)
                .map(num -> "G" + num);

        List<Integer> oList = IntStream.rangeClosed(61, 75)
                .boxed()
                .toList();
        Stream<String> oStream = oList.stream()
                .map(num -> "O" + num);

        Stream<String> bingoStream = Stream.concat(
                Stream.concat(
                        Stream.concat(
                                Stream.concat(bStream, iStream),
                                nStream
                        ),
                        gStream
                ),
                oStream
        );

        bingoStream.forEach(System.out::println);
    }
}
