package Stream;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
        public static void main(String[] args) {

            List<Integer> numbers = new ArrayList<>();
            numbers.add(0);
            numbers.add(11);
            numbers.add(99);
            numbers.add(7);
            numbers.add(5);
            numbers.add(3);
            numbers.add(8);
            numbers.add(14);
            numbers.add(22);
            numbers.add(42);
            numbers.add(6);


            findMinMax(numbers.stream().parallel(),Integer::compareTo,((integer, integer2) -> System.out.println(integer+" "+integer2)));
            System.out.println(printTheNumberOfEvenNumbers(numbers ) + "количество четных чисел");
        }
    //Задание 1
    //Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в
    // соответствии порядком, заданным Comparator'ом.
    //Данный метод принимает на вход 3 элемента:
    //Stream<? extends T> stream,
    //Comparator<? super T> order,
    //BiConsumer<? super T, ? super T> minMaxConsumer
    //Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
    //minMaxConsumer.accept(min, max);
    //Если стрим не содержит элементов, то вызовите:
    //minMaxConsumer.accept(null, null);
        public static<T> void findMinMax(Stream<? extends T> stream,
                                         Comparator<? super T> order,
                                         BiConsumer<? super T, ? super T> minMaxConsumer) {
            List<? extends T> list = stream.collect(Collectors.toList());
            //Optional<? extends T> min=numbs.stream().min(order);
            //Optional<? extends T> max=numbs.stream().max(order);
            //List<? extends T> min = number.stream().sorted(order).collect(Collectors.toList());
            // List < ? extends T> max = number.stream().sorted((o1, o2) ->-1*order.compare(o1,o2) ).collect(Collectors.toList());

            minMaxConsumer.accept(list.stream().min(order).orElse(null),list.stream().max(order).orElse(null));
        }

    //Задание 2
    //Реализуйте метод, который принимает на вход список целых чисел и определяет количество четных и
    // выводит их в консоль. Решать именно с применением Stream API.
    public static Integer printTheNumberOfEvenNumbers(List<Integer> list) {

        return (int) list.stream()
                     .filter(i->i % 2 == 0)
                     .count();
    }
}