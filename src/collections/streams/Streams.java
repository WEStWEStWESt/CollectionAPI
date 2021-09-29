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
              а после, снова оборачивает его в стрим. ПРИ ЭТОМ ТИП ОБЪЕКТА СТРИМА МОЖЕТ БЫТЬ ИЗМЕНЁН !!!
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

        /* .filter("a1A"::equals) - фильтр принимает предикат(функц.интерфейс).
           Все элементы стрима, не прошедшие фильтр - далее не обрабатываются,
           т.е. игнорируются во всех дальнейших методах стрима, включая терминальный.
           .count() - считает количество элементов, прошедших все обработки(filter, skip, limit...). Возвращает Long.
           */
        System.out.println("stream count: " + strings.stream()
                .filter("a1A"::equals)
                .map(s -> s.substring(0, s.lastIndexOf("A")))
                .count());
        /*.collect() - пересобирает элементы стрима в новую коллекцию(или массив).
                    Тут используется группирующий коллектор, возвращающий map,
          где типом Ключа явл.тип возвращаемого значения функции, переданной в метод .groupingBy(),
          а типом Значения явл. List типов, содержащихся в стриме.

          Метод collect() вызывает группирующий коллектор для каждого элемента стрима.
          Работа: для текущего элемента вызавается функция, переданная в метод .groupingBy().
                 Таким образом определяется ключ для текущего элемента.
                 Далее проверяется, есть ли такой ключ в Map.
                 - если такого ключа НЕТ, то в Map кладётся ключ,
                   а в качестве значения создаётся List с одним значением - текущим элементом стрима.
                 - если ключ ЕСТЬ, у Map вызывается метод get() [по ключу получает значение] и в полученный List
                   добавляется текущий элемент стрима.
          */
        Map<Character, List<String>> collect = strings.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(1)));
        System.out.println("groupingBy first character: " + collect);

        /* .anyMatch() возвращает boolean.
            Каждому элементу стрима применяется предикат, переданный в этот метод, до тех пор, пока он не вернёт TRUE.
            Если ничего не соответствовало, то возвр.FALSE.
            Похожие методы:
               - allMatch() - вернёт true, если ВСЕ ЭЛЕМЕНТЫ СТРИМА СООТВЕТСТВУЮТ ПРЕДИКАТУ, иначе - false.
               - noneMatch() - обратный allMatch(). */
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
