package org.example.sem1.homework2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Напишите программу, которая использует Stream API для обработки списка чисел.
 * Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */
public class Numbers {


    public static void averageOfEvenNumbers(List<Integer> numbers){
        AtomicInteger sum = new AtomicInteger(0);
        AtomicInteger cntr = new AtomicInteger(0);
        numbers.stream().filter(n -> n%2 == 0).forEach(n -> {
            sum.set(sum.intValue() + n);
            cntr.incrementAndGet();
        });
        System.out.println("Average value: " + sum.intValue()/cntr.intValue());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7, 9, 8, 53, 1, 102, 15, 52, 8, 17);
        averageOfEvenNumbers(numbers);
    }
}
