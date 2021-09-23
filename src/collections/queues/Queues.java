package collections.queues;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Queues {
    public static void main(String[] args) {
        /*
          E element(): возвращает, но не удаляет, элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
          boolean offer(E obj): добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
          E peek(): возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
          E poll(): возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
          E remove(): возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException*/

        /* QUEUE.
           Коллекция, предоставляющая доступ к элементам в нужном порядке, без применения прямой итерации.

           FIFO (first in, first out) - базовый функционал(порядок вставки элементов) интерфейса Queue.

           Вставка - add() , offer();
           Извлечение - poll()+ , remove();
           Просмотр - element() , peek()+;

           ЕСТЕСТВЕННЫЙ ПОРЯДОК СОРТИРОВКИ - NORMAL SORTING ORDER (ASCENDING), обратный ему - DESCENDING.
        */

        /* PriorityQueue.
        *  Предоставляет функционал Queue, но порядок сортировки объектов либо нативный(естественный) -
           - для Comparable-элементов, либо через Comparator - для прочих.
           !!! СРАВНИВАЕМЫЕ В КОМПАРАТОРЕ ПАРАМЕТРЫ ИЛИ ПОЛЯ ЭЛЕМЕНТОВ ДОЛЖНЫ БЫТЬ COMPARABLE !!!
           PriorityQueue - "ТЯЖЁЛЫЙ РЕСУРС" из-за использования внутреннего автоматического механизма сортировки.
         */

        /* priorityQueue.
           Тут независимо от порядка вставки элементов, при их получении, они будут отсортированы
           ЕСТЕСТВЕННЫМ ПОРЯДКОМ СОРТИРОВКИ АТВОМАТИЧЕСКИ.
           */
        Queue<String> priorityQueue = new PriorityQueue<>(List.of("Zz", "Bb", "Cc", "Dd"));
        priorityQueue.add("Aa");
        print(priorityQueue);

        /* priorityQueueIncomparable.
           Очередь содержит элементы, не сортируемые естетсвенным образом(Лист листов - МУЛЬТИЛИСТ).
           Для их сортировки применяется Comparator.
           */
        Queue<List<String>> priorityQueueIncomparable = new PriorityQueue<>(
                Comparator.comparing(list -> list.get(0)));
        priorityQueueIncomparable.addAll(List.of(List.of("Bbs"), List.of("OaO")));
        print(priorityQueueIncomparable);

        /* priorityQueueReversed.
           Естественный порядок сортировки заменяется на обратный при помощи Компаратора.
           */
        Queue<String> priorityQueueReversed = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueueReversed.addAll(List.of("Zz", "Bb", "Cc", "Dd"));
        print(priorityQueueReversed);
    }

    private static void print(Queue<?> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }

    /*  DEQUE.
        Двунапрвленная очередь.
        Помимо методов Queue, добавляются их аналоги для Головы(Head - first) и Хвоста(Tail - last),
        а так же методы стека:
        LIFO (last in , first out).
        Вставка - push() , addFirst();
        Извлечение - pop() , removeFirst();
        Просмотр - peek() , peekFirst();

        ArrayDeque - аналогично как и ArrayList, используется для вставки элементов в конец коллекции.
        LinkedList - для вставки в начало и в середину.
       */
}
