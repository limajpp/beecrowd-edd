package av2.tadfila.questao2460;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int peopleAmount = sc.nextInt();
        if (peopleAmount < 1 || peopleAmount > 50000) throw new RuntimeException("Invalid amount of people.");

        sc.nextLine();

        WorldCupQueue queue = new WorldCupQueue(peopleAmount);
        String[] ids = sc.nextLine().split(" ");

        for (int i = 0; i < peopleAmount; i++) {
            queue.addPerson(Integer.parseInt(ids[i]));
        }

        int peopleThatGaveUp = sc.nextInt();
        if (!queue.validateAmountThatGaveUp(peopleThatGaveUp))
            throw new RuntimeException("Invalid amount of people that gave up.");

        sc.nextLine();

        String[] idsThatGaveUp = sc.nextLine().split(" ");

        for (int i = 0; i < peopleThatGaveUp; i++) {
            queue.removePerson(Integer.parseInt(idsThatGaveUp[i]));
        }

        System.out.println(queue);

        sc.close();
    }

    private static class WorldCupQueue {
        private final Integer[] QUEUE;
        private final int PEOPLE;
        private int elements;

        private WorldCupQueue(int PEOPLE) {
            this.PEOPLE = PEOPLE;
            QUEUE = new Integer[PEOPLE];
            elements = 0;
        }

        private boolean validateId(int id) {
            for (Integer element : QUEUE) {
                if (element != null && element == id) {
                    return false;
                }
            }
            return true;
        }

        private boolean validateAmountThatGaveUp(int amount) {
            return amount >= 1 && amount <= 50000 && amount < PEOPLE;
        }

        private void addPerson(int id) {
            if (validateId(id)) {
                QUEUE[elements] = id;
                elements++;
            }
        }

        private void removePerson(int id) {
            int idIndex = 0;
            for (int i = 0; i < PEOPLE; i++) {
                if (QUEUE[i] == id) {
                    idIndex = i;
                    break;
                }
            }

            for (int i = idIndex; i < elements - 1; i++) {
                QUEUE[i] = QUEUE[i + 1];
            }

            QUEUE[elements - 1] = null;
            elements--;
        }

        @Override
        public String toString() {
            StringBuilder queueString = new StringBuilder();

            for (Integer element : QUEUE) {
                if (element == null) break;

                if (element.equals(QUEUE[elements - 1])) {
                    queueString.append(element);
                } else {
                    queueString.append(element).append(" ");
                }
            }

            return queueString.toString();
        }
    }
}
