package main.leetcode;

public class DesignCircularQueue {

    private int arr[];
    int rear = -1;
    int front = 0;
    int capacity = 0;

    public DesignCircularQueue(int k) {
        arr = new int[k];
        for (int i = 0; i < arr.length; i++) arr[i] = -1;
    }

    public boolean enQueue(int value) {

        if (isFull()) return false;
        rear = (rear + 1) % arr.length;
        if (rear < arr.length) arr[rear] = value;
        capacity++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % arr.length;
        arr[front] = -1;
        capacity--;
        return true;
    }

    public int Front() {
        return arr[front];
    }

    public int Rear() {
        return arr[rear];
    }

    public boolean isEmpty() {
        return capacity == 0;
    }

    public boolean isFull() {
        return capacity == arr.length;
    }

    public static void main(String[] args) {
        DesignCircularQueue queue = new DesignCircularQueue(6);
        System.out.println(queue.enQueue(6));
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(5));
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
        System.out.println(queue.Front());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }

}

