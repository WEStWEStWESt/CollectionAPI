package collections.maps;

import java.util.*;

public class Maps {
    public static void main(String[] args) {
        /*
           MAP - интерфейс, концептуально описывающий работу со списком пар (ключ, значение).
           Пара (key,value) называется ENTRY.

           Часто используемые методы:

           put() , putAll() - положить элемент;
           get() - по ключу ВОЗВРАЩАЕТ ЗНАЧЕНИЕ;
           keySet() - возвращает Set ключей;
           values() - восвращает список значений;
           entrySet() - восвращает Set пар(entries);
           containsKey() - проверяет, есть ли ключ, или нет;
           containsValue() - проверяет, есть ли значение, или нет;
           replace() - заменяет указанное значение по ключу;
           replaceAll() - бинарная функция, принимает (key,value);
           remove() - удаляет значение по ключу.
            */

        /* HashMap - класс, реализующий интерфейс Map.
           Представляет собой динамический массив односвязных списков.
           Элементы массива называются BUCKET-ами. Bucket содержит ссылку на первую ноду(NODE).
           Node содержит в себе ENTRY ссылку на следующую Ноду(Node<K,V> next).
           Основывается на определении HashCode и Equals.
           Изначально, capacity = 16. При первичном заполнении HashMap, каждый элемент ложится в отдельный Bucket.
           По мере увеличения размера Bucket-ов, происходит вычисление LoadFactor-а.
           При достижении  LoadFactor-а 75%, происходят расширяется сам массив HashMap и пререраспределяются все
           элементы в Bucket.
         */

        Map<Integer, String> hashMaps = new HashMap<>();
        Map<Integer, String> treeMaps = new TreeMap<>();
        Map<Integer, String> linkedHashMaps = new LinkedHashMap<>();
    }
}
