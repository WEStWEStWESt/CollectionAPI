package collections.sets;

import java.util.*;

public class Sets {
    public static void main(String[] args) {
        /*
           SET - неупорядоченное множество уникальных объектов.
           HashSet строится на основе HashMap. HashMap(key, value) поддерживает уникальность хранимых ключей.
           Значения при этом могут быть НЕ уникальными.

           Все объекты SETа кладутся в HashMap в виде КЛЮЧА !!! Вместо ЗНАЧЕНИЯ подставляется ПУСТОЙ Object !!!

           Из этого исходят 2 основных применения HashSet:
           1. HashSet удаляет(автоматически) дублирующиеся объекты, оставляя лишь один экземпляр.
              NULL  тоже может находится В ЕДИНСТВЕННОМ ЭКЗЕМПЛЯРЕ !
           2. Проверка на наличие в SETе УЖЕ ИМЕЮЩЕГОСЯ объекта (метод contains()).
        */
        /*
          В конструктор любой коллекции можно передать уже существующую коллекцию и создать на её основе новую,
          при этом типы коллекций могут отличаться. При этом элементы передаваемые из одной колл.в.другую,
          пройдут "фильтрацию" в соответствии с требованиями коллекции, в которую передают эти элементы.
          Такой способ создания коллекции использует дополнительный цикл !

          Пример: из List в Set !
          При этом дублирующиеся элементы будут удалены в связи с требованием к уникальности объектов в Сете !

          */
        List<String> listStrings = new ArrayList<>(List.of("Z", "B", "C", "A", "D"));
        Set<String> setLists = new HashSet<>(listStrings);
        System.out.println("listStrings: " + listStrings);
        System.out.println("changed setLists: " + setLists);
        if (setLists.contains("A")) {
            /* Добавление .add() в конец HashSet элементов НЕ ГАРАНТИРУЕТСЯ !
               Так же при добавлении новых элементов может произойти реорганизация(изментся порядок)
               всех имеющихся объектов. Связано с работой Map и её load-фактором(см.секцию про HashMap)...
             */
            setLists.remove("A");
            setLists.add("F");
            System.out.println(setLists);
        } else {
            System.out.println("Element not found!");
        }

        /* LinkedHashSet гарантирует порядок вставки в конец множества.
           Остальные свойства такие же, как и у HashSet.*/
        Set<String> linkedHashSets = new LinkedHashSet<>(listStrings);

        /* TreeSet - реализован при помощи TreeMap, которая всегда сохраняет ЕСТЕСТВЕННЫЙ ПОРЯДОК СОРТИРОВКИ,
           который обеспечивается интерфейсом Comparable. Если такого порядка нет(Comparable не реализован),
           в процессе использования TreeSet будет выбрасываться ошибка ClassCastException, т.к. TreeMap пытается
           Кастить(приводить к типу) все объекты в Comparable.
           Если в конструктор предан Comparator, то вместо Comparable(естественного порядка), будет использоваться он.

           Некоторые объекты(String, обёрточные типы(Враперы) и др) имеют ЕСТЕСТВЕННЫЙ ПОРЯДОК СОРТИРОВКИ по умолчанию.
        */
        Set<String> treeSetStrings = new TreeSet<>(listStrings);
        Set<Object> treeSetObjects = new TreeSet<>(Collections.reverseOrder());
        /*  Внимание! Обратить внимание на тип treeSetObjects. Сет содержит  <Object>,
            т.к. TreeSet<>() создаётся при помощи передачи в конструктор компаратора
            с использованием утилиты Collections.reverseOrder(),
            которая не принимает конкретного типа(она типизирована под Object! ).*/
        /*Set<Object> treeSetObjectExceptions = new TreeSet<>(List.of(new Object(), new Object())); - Exception !!! */
        treeSetObjects.addAll(listStrings);
        System.out.println("native order: " + treeSetStrings);
        System.out.println("reversed order(Comparator): " + treeSetObjects);

        class LocalComparable implements Comparable<LocalComparable> {

            private int number;

            public LocalComparable(int number) {
                this.number = number;
            }

            @Override
            public int compareTo(LocalComparable localComparable) {

                return Integer.compare(number, localComparable.number);
            }

            @Override
            public String toString() {
                return "" + number;
            }
        }
        Set<Object> treeSetLocalComparable = new TreeSet<>(List.of(new LocalComparable(2), new LocalComparable(1)));
        System.out.println("treeSetLocalComparable: " + treeSetLocalComparable);

        class LocalComparator implements Comparator<LocalComparable> {

            @Override
            public int compare(LocalComparable t1, LocalComparable t2) {
                return t2.number < t1.number ? -1 : (t2.number == t1.number ? 0 : 1);
            }
        }
        Set<LocalComparable> treeSetLocalComparator = new TreeSet<>(new LocalComparator());
        treeSetLocalComparator.addAll(List.of(new LocalComparable(1), new LocalComparable(2)));
        System.out.println("treeSetLocalComparator: " + treeSetLocalComparator);
    }
}
