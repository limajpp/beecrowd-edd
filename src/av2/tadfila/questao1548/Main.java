package av2.tadfila.questao1548;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int numberOfTestCases = sc.nextInt();
        sc.nextLine();

        SchoolPriorityQueue priorityQueue;
        while (numberOfTestCases > 0) {
            priorityQueue = new SchoolPriorityQueue(sc.nextInt());
            sc.nextLine();

            String[] grades = sc.nextLine().split(" ");
            for (String grade : grades) {
                priorityQueue.addGrade(Integer.parseInt(grade));
            }

            System.out.println(priorityQueue.notSortedStudents());

            numberOfTestCases--;
        }

        sc.close();
    }

    private static class SchoolPriorityQueue {
        private final int[] NOT_SORTED_GRADES;
        private final int[] SORTED_GRADES;
        private final int STUDENTS;
        private int elements;

        private SchoolPriorityQueue(int STUDENTS) {
            this.STUDENTS = STUDENTS;
            NOT_SORTED_GRADES = new int[STUDENTS];
            SORTED_GRADES = new int[STUDENTS];
            elements = 0;
        }

        private void addGrade(int grade) {
            NOT_SORTED_GRADES[elements] = grade;
            elements++;
        }

        private void sort() {
            for (int i = 0; i < STUDENTS; i++) {
                SORTED_GRADES[i] = NOT_SORTED_GRADES[i];
            }

            for (int i = 0; i < STUDENTS - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < STUDENTS; j++) {
                    if (SORTED_GRADES[j] > SORTED_GRADES[maxIndex]) {
                        maxIndex = j;
                    }
                }
                int temp = SORTED_GRADES[i];
                SORTED_GRADES[i] = SORTED_GRADES[maxIndex];
                SORTED_GRADES[maxIndex] = temp;
            }
        }

        private int notSortedStudents() {
            sort();
            int counter = 0;

            for (int i = 0; i < STUDENTS; i++) {
                if (NOT_SORTED_GRADES[i] == SORTED_GRADES[i]) {
                    counter++;
                }
            }

            return counter;
        }
    }
}
