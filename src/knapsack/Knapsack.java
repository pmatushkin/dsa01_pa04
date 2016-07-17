import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here

        // the number of available items
        int n = w.length;

        // the matrix of all the possible value solutions
        int value[][] = new int[W + 1][n + 1];

        // initialize the value matrix
        for (int i = 0; i <= W; i++) {
            value[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
            value[0][i] = 0;
        }

        // loop through the available items
        for (int i = 1; i <= n; i++) {
            // read the current item
            int wi = w[i - 1];

            // loop through the possible weights
            for (int j = 1; j <= W; j++) {
                // assign the initial value(w, i)
                value[j][i] = value[j][i - 1];

                // check if the current item can be used
                // that is, the current state of knapsack can fit the current item
                if (wi <= j) {
                    int val = value[j - wi][i - 1] + wi;

                    // decide whether to use the current item
                    if (value[j][i] < val) {
                        value[j][i] = val;
                    }
                }
            }
        }

        return value[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

