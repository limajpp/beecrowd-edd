package av2.tadpilha.questao1068;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String expression = sc.nextLine();

            if (StaticStack.isBalanced(expression)) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }

        sc.close();
    }

    private static class StaticStack {
        private final Character[] STACK;
        private final int LENGTH;
        private int elements, top;

        private StaticStack(int LENGTH) {
            if (LENGTH <= 0) throw new IllegalArgumentException("Invalid length. It must be bigger than zero.");

            this.LENGTH = LENGTH;
            STACK = new Character[LENGTH];
            elements = 0;
            top = -1;
        }

        private boolean isEmpty() {
            return elements == 0;
        }

        private boolean isFull() {
            return elements == LENGTH;
        }

        private void push(Character ch) {
            if (isFull()) throw new IllegalStateException("Stack is full. Operation not allowed.");
            if (ch == null) throw new IllegalArgumentException("Cannot push null to the stack."); // Checando se é nulo

            top += 1;
            STACK[top] = ch;
            elements++;
        }

        private void pop() {
            if (isEmpty()) throw new IllegalStateException("Stack is empty. Operation not allowed.");

            STACK[top] = null;
            top -= 1;
            elements--;
        }

        public static boolean isBalanced(String expression) {
            StaticStack stack = new StaticStack(expression.length());

            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }

        /* For debugging...
        @Override
        public String toString() {
            if (isEmpty()) return "Bottom -> null -> Top";

            StringBuilder staticStackString = new StringBuilder("Bottom -> ");

            for (int i = 0; i <= top; i++) {
                staticStackString.append(STACK[i]).append(" -> ");
            }

            staticStackString.append("Top");
            return staticStackString.toString();
        } */
    }
}
