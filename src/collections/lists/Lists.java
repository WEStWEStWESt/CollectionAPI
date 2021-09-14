package collections.lists;

import java.util.*;

public class Lists {
    public static void main(String[] args) {
        /* Инициализация ПУСТЫХ списков. */
        /* часто используемые*/
        List<String> emptyStrings = new ArrayList<>();/* пустой изменяемый список строк.*/
        var stringReferences = new ArrayList<String>();/* пустой изменяемый список строк.*/
        List<String> immutableListStrings = List.of();/* пустой НЕ изменяемый список строк.*/
        List<String> collUtilStrings = Collections.emptyList();/* пустой НЕ изменяемый список строк.*/
        List<String> arraysUtilStrings = Arrays.asList();/* пустой НЕ изменяемый список строк.*/

        /* редко используемые*/
        List<? extends Number> emptyNumbers = new ArrayList<>();/*коллекция елементов типа Number и наследников*/
        List<? super Number> emptySuperNumbers = new ArrayList<>();/*коллекция елементов типа Number и суперклассов(Object) ????*/
        var rawTypeReferences = new ArrayList<>();/* коллекция из Objects */
        List rawTypes = new ArrayList();/* коллекция из Objects */
        List<?> emptyGenerics = new ArrayList<>();/* нельзя доваить НИЧЕГО !!! ??? */

        /* Инициализация НЕ ПУСТЫХ списков. */
        List<String> filledList = List.of("sa", "GG"); // иммутаб
        List<String> filledArrAsList = Arrays.asList("sa", "asas");// иммутаб
        List<String> filledSingletonList = Collections.singletonList("sa");// иммутаб
        var strings = new ArrayList<>(filledList);// создание мутабельной копии коллекции !!!
        List<String> filledListCopy = List.copyOf(filledList);// иммутаб

        /* Добавление элементов в коллекцию */
        strings.add("sddddd");
        strings.addAll(List.of("www", "eee"));
        strings.add(0, "OOOO");
        strings.addAll(0, List.of("kkk"));
        System.out.println("add: " + strings);

        /* ИТЕРАТОР */
        Iterator<String> iterator = filledList.iterator();
        while (iterator.hasNext()) {
            emptyStrings.add(iterator.next());
        }
        System.out.println("iterator: " + emptyStrings);
    }
}
