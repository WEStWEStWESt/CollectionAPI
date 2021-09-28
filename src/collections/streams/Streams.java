package collections.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        String[] arr = {"a1", "b1", "c1", "z1", "a"};

        /* 1 СТАДИЯ. Из массива создаётся ресурс Stream-а, т.е.каждый объект оборачивается в Stream.
           2 СТАДИЯ. Выполняются промежуточные действия. Результатом выполнения ЛЮБОГО промежуточного метода
                     всегда будет Stream.
           3 СТАДИЯ. Терминальная. Возвращение результата работы StreamAPI
                     через вызов каждого из промежуточных методов для каждого из объектов в Stream-е.
            */

        /* 1. Вызов метода Stream.of()
              Преобразование массива arr в Stream(каждый объект массива оборачивается в Stream).
           2. Вызов метода peek(). НЕ ИЗМЕНЯЕТ объект стрима. Тут объект просто выводится в консоль.
           3. Вызов метода map(). ИЗМЕНЯЕТ объект стрима(НО НЕ ИЗМЕНЯЕТ ИСХОДНЫХ ОБЪЕКТОВ),
              а после, снова оборачивает его в стрим.
              Тут посредством работы лямда-выражения происходит добавление строки со значением "А",
              к КАЖДОМУ ЭЛЕМЕНТУ СТРИМА.
           4. Метод sorted() сортирует Stream-объекты исходя из естественного порядка сортировки внутри них.
              Объекты ДОЛЖНЫ БЫТЬ Comparable !!!
           5. Вызов ТЕРМИНАЛЬНОГО МЕТОДА collect().
              Для определения порядка и характера производимых промежуточных операций, терминальный метод использует
              метаданные объекта stream, из которого он вызывается. После выполнения всех операций, объекты стрима
              собираюстя(collect()) при помощи Коллектора, пререданного в метод.
              В данном примере всё собирается в List, А САМ STREAM - ЗАКРЫВАЕТСЯ !!!!
           */

        /*1*/
        Stream<String> stream = Stream.of(arr);
        /*2*/
        stream = stream.peek(System.out::println);
        /*3*/
        stream = stream.map(string -> string + "A");
        /*4*/
        stream = stream.sorted();
        /*5*/
        List<String> strings = stream.collect(Collectors.toList());

        System.out.println("sorted stream: " + strings);
        System.out.println("initial array: " + Arrays.toString(arr));

        System.out.println("stream count: " + strings.stream()
                .filter("a1A"::equals)
                .map(s -> s.substring(0, s.lastIndexOf("A")))
                .count());

        Map<Character, List<String>> collect = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(1)));
        System.out.println("groupingBy first character: " + collect);

        System.out.println("any elements startsWith \"a\": " + strings.stream()
                .anyMatch(s -> s.startsWith("a")));

        System.out.println("filtering with Optional, if exists - remove the last \"A\": " + strings.stream()
                .filter(s -> s.endsWith("A"))
                .findAny()
                .map(s -> s.substring(0, s.lastIndexOf("A")))
                .orElse("unknown"));

        System.out.println("PRINTING STREAM USING FOREACH: ");
        strings.forEach(System.out::println);
    }
}
