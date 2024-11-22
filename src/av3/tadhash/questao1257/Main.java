package av3.tadhash.questao1257;

import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            scanner.nextLine();

            CustomHash customHash = new CustomHash();

            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();

                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    int charValue = c - 'A';
                    customHash.addChar(charValue, i, j);
                }
            }

            System.out.println(customHash.getHashValue());
        }
        scanner.close();
    }

    private static class CustomHash {
        private int hashValue;

        public CustomHash() {
            this.hashValue = 0;
        }

        public void addChar(int charValue, int lineIndex, int charIndex) {
            this.hashValue += charValue + lineIndex + charIndex;
        }

        public int getHashValue() {
            return this.hashValue;
        }
    }
}

