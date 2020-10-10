import java.awt.Font;

public class MineGame {

    public static void showgame(int m, int n, int k, boolean[][] ifMine, int[][] countMine) {
        StdDraw.clear(StdDraw.BOOK_LIGHT_BLUE);
        StdDraw.setXscale(-10, 5 * n);
        StdDraw.setYscale(-10, 5 * m);
        // StdDraw.setScale(-2, +2);
        StdDraw.enableDoubleBuffering();
        int countmine = k;

        // draw the base base
        StdDraw.setPenColor(StdDraw.MAGENTA);
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                StdDraw.filledSquare(i * 5, j * 5, 2.3);
            }

        }

        // Printout how many Mines Left
        StdDraw.setPenColor(StdDraw.BLACK);
        Font font = new Font("Arial", Font.BOLD, 15);
        StdDraw.setFont(font);
        StdDraw.text(-5, -8, "Totally " + countmine + " Mines Left ");

        StdDraw.show();
        StdDraw.pause(20);
        //
        //
        // click to sweeper the mine
        //
        //
        while (true) {
            if (StdDraw.isMousePressed()) {
                // StdDraw.clear();
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                if (x < -2.5 || x > 5 * (n - 1) + 2.5 || y < -2.5 || y > 5 * (m - 1) + 2.5) {
                    continue;
                }


                int cox = (int) Math.round(x / 5) + 1;
                int coy = (int) Math.round(y / 5) + 1;
                double xx = Math.round(x / 5) * 5;
                double yy = Math.round(y / 5) * 5;
                // Change color after clicked the mouse
                //
                // if this is the mine, fill with red and play a sharp sound
                if (ifMine[(m - coy + 1)][cox] == true) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledSquare(xx, yy, 2.3);
                    // StdDraw.pause(10);
                    MakeSound.playsound(k * 5, 0.3);
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    StdDraw.filledRectangle(-5, -8, 8, 2);
                    countmine -= 1;
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.text(-5, -8, "Totally " + countmine + " Mines Left ");
                    StdDraw.show();
                }
                else {
                    // if this is not the mine, play a lower pitch and change color to yellow
                    StdDraw.setPenColor(StdDraw.YELLOW);
                    StdDraw.filledSquare(xx, yy, 2.3);
                    // Print how many mines near bygit
                    StdDraw.setPenColor(StdDraw.BLACK);
                    StdDraw.setFont(font);
                    // StdDraw.text(xx, yy, "(" + (m - coy + 1) + " " + cox + " )");
                    int c = countMine[(m - coy + 1)][cox];
                    StdDraw.text(xx, yy, " " + c + " ");
                    MakeSound.playsound(c * 5, 0.3);

                    StdDraw.show();
                    StdDraw.pause(10);

                }
            }
        }

    }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        int k = Integer.parseInt(args[2]);
        boolean[][] ifMine;
        int[][] countMine;
        ifMine = Minesweeper.generate(m, n, k);
        countMine = Minesweeper.display(ifMine);
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
        showgame(m, n, k, ifMine, countMine);

    }

}
