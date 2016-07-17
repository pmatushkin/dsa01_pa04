import java.util.*;

class EditDistance {
    public static int EditDistance(String s, String t) {
        //write your code here

        // the lengths of input strings
        int s_l = s.length();
        int t_l = t.length();

        // the matrix of all the possible distances
        int d[][] = new int[s_l + 1][t_l + 1];

        // initialize the distance matrix
        for (int i = 0; i <= s_l; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i <= t_l; i++) {
            d[0][i] = i;
        }

        // populate the distance matrix
        for (int i = 1; i <= s_l; i++) {
            for (int j = 1; j <= t_l; j++) {
                int insertion = d[i][j - 1] + 1;
                int deletion = d[i - 1][j] + 1;
                int min = Math.min(insertion, deletion);

                if (s.charAt(i - 1) == t.charAt(j -1)) {
                    int match = d[i - 1][j - 1];

                    d[i][j] = Math.min(min, match);
                } else {
                    int mismatch = d[i - 1][j - 1] + 1;

                    d[i][j] = Math.min(min, mismatch);
                }
            }
        }

        return d[s_l][t_l];
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }
}
