package av2.tadfila.questao3139;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    private static final int MAX_DAYS = 30;
    private static final long[] QUEUE = new long[MAX_DAYS];
    private static int front = 0;
    private static int rear = -1;
    private static int size = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long currentFollowers = scanner.nextLong();
        long goalFollowers = scanner.nextLong();

        long sum = 0;
        for (int i = 0; i < MAX_DAYS; i++) {
            QUEUE[i] = scanner.nextLong();
            sum += QUEUE[i];
            size++;
            rear++;
        }

        long days = 0;

        while (currentFollowers < goalFollowers) {
            long mean = (long) Math.ceil((double) sum / MAX_DAYS);

            currentFollowers += mean;
            sum = sum - dequeue() + mean;
            enqueue(mean);
            days++;
        }

        System.out.println(days);

        scanner.close();
    }

    private static void enqueue(long value) {
        rear = (rear + 1) % MAX_DAYS;
        QUEUE[rear] = value;

        if (size < MAX_DAYS) {
            size++;
        } else {
            front = (front + 1) % MAX_DAYS; // Circular QUEUE behavior
        }
    }

    private static long dequeue() {
        long value = QUEUE[front];
        front = (front + 1) % MAX_DAYS;
        size--;
        return value;
    }
}
