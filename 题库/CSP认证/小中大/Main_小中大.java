import java.util.Scanner;

// 100

public class Main_小中大 {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        if (n == 0) {
            return;
        }

        int[] nArr = new int[n];

        for (int i = 0; i < n; i++) {
            nArr[i] = scanner.nextInt();
        }

        double mid = (n % 2 == 0 ? ((nArr[(n >> 1) - 1] + nArr[n >> 1]) / 2.0) + 0.05
                : nArr[n >> 1]);

        String midStr = null;

        if (mid == (int) mid) {
            midStr = String.valueOf(mid).substring(0, String.valueOf(mid).indexOf("."));
        } else {
            midStr = String.valueOf(mid).substring(0, String.valueOf(mid).indexOf(".") + 2);
        }

        if (nArr[n - 1] - nArr[0] >= 0) {
            System.out.println(nArr[n - 1] + " " + midStr + " " + nArr[0]);
        } else {
            System.out.println(nArr[0] + " " + midStr + " " + nArr[n - 1]);
        }

    }
}
