import java.util.Objects;
import java.util.Scanner;

public class NewYearChaos {

    static void minimumBribes(int[] q) {
        int len = q.length;
        int bribes = 0;
        boolean tooChaotic = false;
        for (int i = 0; i < len; i++) {
            int moves = (q[i] - 1) - i;
            if (moves > 2) {
                tooChaotic = true;
                break;
            }

            if (moves > 0) {
                bribes += moves;
                continue;
            }

            if (moves == 0) {
                for (int j = 1; (j <= 2 && i + j < len); j++) {
                    if (q[i] > q[i + j]) {
                        bribes++;
                    }
                }
                continue;
            }

            // moves negative
            for (int j = moves; j < 0; j++) {
                if (q[i+j] < q[i]) {
                    bribes++;
                }
            }
        }

        if (tooChaotic) {
            System.out.println("Too chaotic");
        } else {
            System.out.println(bribes);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
