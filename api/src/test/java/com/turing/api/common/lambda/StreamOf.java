package com.turing.api.common.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {

    @Test
    public void testSame(){
        int arr[] = { 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(arr);
        System.out.println(" --------- Using Arrays.stream() ---------");
        intStream.forEach(str -> System.out.print(str + " "));

        System.out.println("\n --------- Using Stream.of() ---------");
        Stream<int[]> stream = Stream.of(arr);
        stream.forEach(str -> System.out.print(str + " "));

//        결과
//       --------- Using Arrays.stream() ---------
//       1 2 3 4 5
//       --------- Using Stream.of() ---------
//       [I@ec756bd

    }

    @Test
    public void testDifferent(){
        int arr[] = { 1, 2, 3, 4, 5 };
        IntStream intStream = Arrays.stream(arr);
        System.out.println("\n --------- Using Arrays.stream() ---------");
        intStream.forEach(str -> System.out.print(str + " "));

        Stream<int[]> stream = Stream.of(arr);
        IntStream intStreamNew = stream.flatMapToInt(Arrays::stream);
        System.out.println("\n --------- Using Stream.of() ---------");
        intStreamNew.forEach(str -> System.out.print(str + " "));

//        결과
//        --------- Using Arrays.stream() ---------
//        1 2 3 4 5
//        --------- Using Stream.of() ---------
//        1 2 3 4 5
    }


}
