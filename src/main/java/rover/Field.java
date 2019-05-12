package rover;
import java.util.Random;

public class Field {

    private static int height = 20;
    private static int width = 80;

    public static char[][] mars = new char[height][width];

    public static void initField(Random random) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (random.nextDouble() < 0.25) {
                    mars[i][j] = '#';

                } else {
                    mars[i][j] = ' ';
                }
            }
        }
    }

    public static void drawField() {

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                System.out.print(mars[j][i]);
            }
            System.out.println();
        }
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

}
