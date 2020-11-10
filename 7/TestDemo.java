package K_7;


import java.util.PriorityQueue;

public class TestDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(31);
        priorityQueue.offer(24);
        priorityQueue.offer(61);

        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
    }
    public static void main1(String[] args) {
        int[] array = { 27,15,19,18,28,34,65,49,25,37};

        TestHeap testHeap = new TestHeap();
        testHeap.initHeap( array );
        testHeap.push(99);
        testHeap.pop();

        for (int i = 0; i < testHeap.usedSize ; i++) {
            System.out.println(testHeap.elem[i]);
        }
    }


}
