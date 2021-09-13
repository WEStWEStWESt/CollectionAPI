package collections.lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {
    public static void main(String[] args) {
        /* Инициализация пустых списков. */
        List<String> emptyStrings = new ArrayList<>();/* пустой изменяемый список строк.*/
        List<?> emptyGenerics = new ArrayList<>();/* нельзя доваить НИЧЕГО !!! ???*/
        List<? extends Number> emptyNumbers = new ArrayList<>();/*коллекция елементов типа Number и наследников*/
        List<? super Number> emptySuperNumbers = new ArrayList<>();/*коллекция елементов типа Number и суперклассов(Object) ????*/
        List rawTypes = new ArrayList();/* коллекция из Objects */
        var rawTypeReferences = new ArrayList<>();/* коллекция из Objects */
        var stringReferences = new ArrayList<String>();/* пустой изменяемый список строк.*/
        List<String> immutableListStrings = List.of();/* пустой НЕ изменяемый список строк.*/
        List<String> collUtilStrings = Collections.emptyList();/* пустой НЕ изменяемый список строк.*/
        List<String> arraysUtilStrings = Arrays.asList();/* пустой НЕ изменяемый список строк.*/
    }
}
