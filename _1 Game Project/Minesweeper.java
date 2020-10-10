/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

public class Minesweeper {
    public static boolean[][] generate(int m, int n, int k) {
        // java Minesweeper 3 6 2
        // number of rows, number of columns and number of mines

        // int total = m * n;
        boolean[][] ifMine = new boolean[m + 2][n + 2];

        int minex;
        int miney;
        int mineNum = 0;

        // Place the k mines
        for (int i = 0; i < k; i++) {
            minex = (int) (Math.random() * m) + 1;
            miney = (int) (Math.random() * n) + 1;
            if (ifMine[minex][miney]) {
                k += 1;
            }
            else {
                ifMine[minex][miney] = true;
            }
        }
        return ifMine;

    }

    public static int[][] display(boolean[][] ifMine) {
        int m = ifMine.length - 2;
        int n = ifMine[0].length - 2;
        int mineNum = 0;
        int[][] countMine = new int[m + 2][n + 2];
        // Count neighboring mines:
        for (int j = 1; j <= m; j++) {
            for (int u = 1; u <= n; u++) {
                // Loop over 9 cells to count
                for (int p = j - 1; p <= j + 1; p++) {
                    for (int q = u - 1; q <= u + 1; q++) {
                        if (ifMine[p][q]) {
                            mineNum += 1;
                        }
                    }
                }
                countMine[j][u] = mineNum;
                mineNum = 0;
            }

        }
        return countMine;
    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] ifMine;
        int[][] countMine;
        ifMine = generate(m, n, k);
        countMine = display(ifMine);

        // Print the mine map:
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                if (!ifMine[x][y]) {
                    System.out.print("[]" + x + y);
                }
                else {
                    System.out.print("*  ");
                    // System.out.print(countMine[x][y] + "  ");
                }
            }
            System.out.println("");

        }
        // Print the count map:
        for (int x = 1; x <= m; x++) {
            for (int y = 1; y <= n; y++) {
                // if (countMine[x][y]) {
                System.out.print(countMine[x][y] + "  ");
                // }
            }
            System.out.println("");

        }

    }
}
