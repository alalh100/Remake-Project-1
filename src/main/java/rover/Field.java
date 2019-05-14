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

    public static void deleteItem(int[] position){

        mars[position[0]][position[1]]= ' ';
    }

    public static void addItem(int[] position, char item){

        mars[position[0]][position[1]]= item;

    }

    // Die nächsten vier Methoden sicherstellen, dass ArrayIndexOutOfBoundsException vermieden wird und
    // dass keine Hindernisse auf der gesuchten Seite stehen.

    public static boolean checkLeft (int[] position){

        return position [1]-1 >= 0    && mars[position[0]][position[1]-1] !='#';
    }
    public static boolean checkRight(int[] position){

        return position [1]+1 < width && mars[position[0]][position[1]+1] !='#';
    }
    public static boolean checkUp(int[] position){

        return position[0]-1 >=0      && mars[position[0]-1][position[1]] !='#';
    }
    public static boolean checkDown(int[] position){

        return position[0]+1 < height && mars[position[0]+1][position[1]] !='#';
    }

}
