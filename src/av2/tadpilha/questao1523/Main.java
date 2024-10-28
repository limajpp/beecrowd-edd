package av2.tadpilha.questao1523;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (k == 0 && n == 0) break;

            StaticStack p = new StaticStack(k);
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int ci = scanner.nextInt();
                int si = scanner.nextInt();

                if (possible) {
                    if (p.isEmpty()) {
                        p.push(ci, si, k);
                    } else {
                        while (ci >= p.DEPARTURE[p.top - 1]) {
                            p.pop();
                            if (p.isEmpty()) break;
                        }
                        if (p.isFull(k)) {
                            possible = false;
                        } else {
                            p.push(ci, si, k);
                            if (p.top > 1) {
                                possible = p.ARRIVAL[p.top - 1] > p.ARRIVAL[p.top - 2] &&
                                        p.DEPARTURE[p.top - 1] < p.DEPARTURE[p.top - 2];
                            }
                        }
                    }
                }
            }
            System.out.println(possible ? "Sim" : "Nao");
        }
        scanner.close();
    }

    private static class StaticStack {
        private int top;
        private final int[] ARRIVAL;
        private final int[] DEPARTURE;

        public StaticStack(int length) {
            top = 0;
            ARRIVAL = new int[length];
            DEPARTURE = new int[length];
        }

        private boolean isEmpty() {
            return top == 0;
        }

        private boolean isFull(int spaces) {
            return top == spaces;
        }

        private void push(int c, int s, int spaces) {
            if (!isFull(spaces)) {
                ARRIVAL[top] = c;
                DEPARTURE[top] = s;
                top++;
            }
        }

        private void pop() {
            if (!isEmpty()) {
                top--;
            }
        }
    }
}
