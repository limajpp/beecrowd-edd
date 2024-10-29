package av2.tadfila.questao3139;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] currentAndMinFollowers = sc.nextLine().split(" ");
        int currentFollowersNum = Integer.parseInt(currentAndMinFollowers[0]);
        int minFollowersToPartnerUp = Integer.parseInt(currentAndMinFollowers[1]);
        if (currentFollowersNum < 1 || currentFollowersNum >= minFollowersToPartnerUp ||
            minFollowersToPartnerUp > Math.pow(10, 9) || currentFollowersNum >= Math.pow(10, 9))
                throw new RuntimeException("Invalid followers parameter(s).");



        sc.close();
    }

    private static class SubscribersQueue {
        private final int[] QUEUE;
        private final int DAYS;
        private int elements;

        public SubscribersQueue() {
            DAYS = 30;
            QUEUE = new int[DAYS];
            elements = 0;
        }


    }
}
