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

        Queue<String> priorityQueue = new PriorityQueue<>(List.of("Zz", "Bb", "Cc", "Dd"));
        priorityQueue.add("Aa");
        print(priorityQueue);

        Queue<List<String>> priorityQueue1 = new PriorityQueue<>(
                Comparator.comparing(list -> list.get(0)));
        priorityQueue1.addAll(List.of(List.of("Bbs"), List.of("OaO")));

        print(priorityQueue1);

        Queue<String> priorityQueueComparator = new PriorityQueue<>(Comparator.reverseOrder());
        priorityQueueComparator.addAll(List.of("Zz", "Bb", "Cc", "Dd"));
        print(priorityQueueComparator);
    }

    private static void print(Queue<?> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println();
    }
}
