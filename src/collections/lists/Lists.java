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
        List<?> emptyGenerics = new ArrayList<>();/* нельзя добавить НИЧЕГО !!! ??? */

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

        /*  ---  Linked list  ---  */
        /* Список связей.
           Константно храниться только ссылка на ПЕРВЫЙ и ПОСЛЕДНИЙ элементы.
           Ссылки на другие элементы получаются итеративно.

           Добавление элемента в середину списка по индексу:
           - Находится текущий элемент по индексу, при этом учитывается его отдалённость от ПЕРВОГО
             или ПОСЛЕДНЕГО элемента (ближе к первому -инкрементируестя, ближе к последнему - декрементруестя).
           - Берётся ссылка на предыдущий элемент"Cc" относительно текущего"Dd".
           - Созаётся новый элемент(Node...тут-"S"). При этом, как предыдущий в него задаётся "Cc", а последующий - "Dd".
           - a b i - не трогаются вообще.
           - Тперь у элемента "Cc" ссылка на следующий объект, а у эл-та "Dd" ссылка на предыдущий ЗАМЕНЯЮТСЯ НА "S" !!

           - При вставке НЕ ПЕРВЫМ и НЕ ПОСЛЕДНИМ ЭЛЕМЕНТОМ, изменяются лишь ссылки у 2х объектов и создаётся один новый.
             Но если вставка вместо первого или последнего, то ссылка изменяется у одного объекта и создаётся один новый.
           */
        List<String> linkedStringLists = new LinkedList<>(List.of("Aa", "Bb", "Cc", "Dd", "Ii"));
        linkedStringLists.add(3, "S");
    }
}
