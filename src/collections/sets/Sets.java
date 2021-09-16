package collections.sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        /*
           SET - неупорядоченное множество уникальных объктов.
           HashSet строится на основе HashMap. HashMap(key, value) поддерживает уникальность хранимых ключей.
           Значения при этом могут быть НЕ уникальными.

           Все объекты SETа кладутся в HashMap в виде КЛЮЧА !!! Вместо ЗНАЧЕНИЯ подставляется ПУСТОЙ Object !!!

           Из этого исходят 2 основных применения HashSet:
           1. HashSet удаляет(автоматически) дублирующиеся объекты, оставляя лишь один экземпляр.
              NULL  тоже может находится В ЕДИНСТВЕННОМ ЭКЗЕМПЛЯРЕ !
           2. Проверка на наличие в SETе УЖЕ ИМЕЮЩЕГОСЯ объекта (метод contains()).
        */
        List<String> listStrings = new ArrayList<>(List.of("A", "B", "C", "A"));
        Set<String> setLists = new HashSet<>(listStrings);
        System.out.println("listStrings: " + listStrings);
        System.out.println("changed setLists: " + setLists);
        if (setLists.contains("A")) {
            setLists.remove("A");
            setLists.add("F");
            System.out.println(setLists);
        } else {
            System.out.println("Element not found!");
        }
    }
}
