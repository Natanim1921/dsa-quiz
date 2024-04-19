public class Mmain {
    private int maxSize;
    private int[] linearQueue;
    private int linearFront;
    private int linearRear;

    private int[] circularQueue;
    private int circularFront;
    private int circularRear;

    private int[] stack1;
    private int[] stack2;
    private int top1;
    private int top2;

    public Mmain(int size) {
        maxSize = size;
        linearQueue = new int[maxSize];
        linearFront = -1;
        linearRear = -1;

        circularQueue = new int[maxSize];
        circularFront = -1;
        circularRear = -1;

        stack1 = new int[maxSize];
        stack2 = new int[maxSize];
        top1 = -1;
        top2 = -1;
    }

    // Linear Queue Operations

    public void linearEnqueue(int data) {
        if (linearRear == maxSize - 1) {
            System.out.println("Linear Queue is full. Cannot enqueue " + data);
            return;
        }
        if (linearFront == -1) {
            linearFront = 0;
        }
        linearQueue[++linearRear] = data;
        System.out.println(data + " enqueued to the Linear Queue.");
    }

    public int linearDequeue() {
        if (linearFront == -1 || linearFront > linearRear) {
            System.out.println("Linear Queue is empty. Cannot dequeue.");
            return -1;
        }
        int dequeuedItem = linearQueue[linearFront++];
        System.out.println(dequeuedItem + " dequeued from the Linear Queue.");
        if (linearFront > linearRear) {
            linearFront = -1;
            linearRear = -1;
        }
        return dequeuedItem;
    }

    // Circular Queue Operations

    public void circularEnqueue(int data) {
        if ((circularRear == maxSize - 1 && circularFront == 0) || (circularRear + 1 == circularFront)) {
            System.out.println("Circular Queue is full. Cannot enqueue " + data);
            return;
        }
        if (circularRear == maxSize - 1 && circularFront != 0) {
            circularRear = -1;
        }
        circularQueue[++circularRear] = data;
        if (circularFront == -1) {
            circularFront = 0;
        }
        System.out.println(data + " enqueued to the Circular Queue.");
    }

    public int circularDequeue() {
        if (circularFront == -1) {
            System.out.println("Circular Queue is empty. Cannot dequeue.");
            return -1;
        }
        int dequeuedItem = circularQueue[circularFront++];
        System.out.println(dequeuedItem + " dequeued from the Circular Queue.");
        if (circularFront > circularRear) {
            circularFront = -1;
            circularRear = -1;
        } else if (circularFront == maxSize) {
            circularFront = 0;
        }
        return dequeuedItem;
    }

    // Queue with Stacks Operations

    public void stackEnqueue(int data) {
        while (top1 != -1) {
            stack2[++top2] = stack1[top1--];
        }
        stack1[++top1] = data;
        while (top2 != -1) {
            stack1[++top1] = stack2[top2--];
        }
        System.out.println(data + " enqueued to the Queue with Stacks.");
    }

    public int stackDequeue() {
        if (top1 == -1) {
            System.out.println("Queue with Stacks is empty. Cannot dequeue.");
            return -1;
        }
        int dequeuedItem = stack1[top1--];
        System.out.println(dequeuedItem + " dequeued from the Queue with Stacks.");
        return dequeuedItem;
    }

    public void printLinearQueue() {
        if (linearFront == -1 || linearFront > linearRear) {
            System.out.println("Linear Queue is empty.");
            return;
        }
        System.out.print("Linear Queue: ");
        for (int i = linearFront; i <= linearRear; i++) {
            System.out.print(linearQueue[i] + " ");
        }
        System.out.println();
    }

    public void printCircularQueue() {
        if (circularFront == -1) {
            System.out.println("Circular Queue is empty.");
            return;
        }
        System.out.println("Circular Queue: ");
        if (circularRear >= circularFront) {
            for (int i = circularFront; i <= circularRear; i++) {
                System.out.println(circularQueue[i] + " ");
            }
        } else {
            for (int i = circularFront; i < maxSize; i++) {
                System.out.println(circularQueue[i] + " ");
            }
            for (int i = 0; i <= circularRear; i++) {
                System.out.println(circularQueue[i] + " ");
            }
        }
        System.out.println();
    }

    public void printStackQueue() {
        if (top1 == -1) {
            System.out.println("Queue with Stacks is empty.");
            return;
        }
        System.out.print("Queue with Stacks: ");
        for (int i = top1; i >= 0; i--) {
            System.out.print(stack1[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Mmain queueDemo = new Mmain(5);

        queueDemo.linearEnqueue(10);
        queueDemo.linearEnqueue(20);
        queueDemo.linearEnqueue(30);
        queueDemo.printLinearQueue();

        queueDemo.linearDequeue();
        queueDemo.printLinearQueue();

        queueDemo.circularEnqueue(40);
        queueDemo.circularEnqueue(50);
        queueDemo.circularEnqueue(60);
        queueDemo.printCircularQueue();

        queueDemo.circularDequeue();
        queueDemo.printCircularQueue();

        queueDemo.stackEnqueue(70);
        queueDemo.stackEnqueue(80);
        queueDemo.stackEnqueue(90);
        queueDemo.printStackQueue();

        queueDemo.stackDequeue();
        queueDemo.printStackQueue();
    }
}