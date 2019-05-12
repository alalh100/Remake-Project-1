package rover;

import java.util.Random;

public class Start {

    private static Random random = new Random();
    private static Rover rover = new Rover(new int [] {10, 40} , '^');
    private static int[] roverPosition = rover.getPosition();

    public static void main(String[] args) {

        if (args.length > 1) {
            long seed = Long.parseLong(args[1]);
            random.setSeed(seed);
        }

        Field.initField(random);

        String eingabe = args[0];
        Field.addItem(roverPosition, rover.getDirection() );
        Field.drawField();

        for (int i = 0; i < eingabe.length(); i++) {
            applyInstructions(eingabe.charAt(i));
            Field.drawField();
        }

    }


    private static void applyInstructions(char eingabe){
        // Die nächste Zeile löscht die alte Position des Rovers, um mehrfache Ausgabe des Rovers zu verhindern.
        Field.deleteItem(roverPosition);

        if      (eingabe == 'f' ) rover.goForward();
        else if (eingabe == 'b' ) rover.goBackward();
        else if (eingabe == 'l' ) rover.turnLeft();
        else if (eingabe == 'r' ) rover.turnRight();


        // Anpassung der Rover-Ausgabe auf dem Feld gemäß der aktuellen Richtung bzw. der aktuellen Position des Rovers
        Field.addItem(roverPosition, rover.getDirection() );
    }

/*
    private static boolean checkDirection(String richtung ){
        // Diese Variable tempPos ist nur für Überprüfung des ArrayIndexOutOfBoundsException .
        int [] tempPos = new int[] { roverPosition[0], roverPosition [1]};

        if      ( richtung.equals("left") ){
            return (tempPos[1]-1 >= 0      && mars[ roverPosition[0] ][ roverPosition[1]-1] !='#');
        }
        else if ( richtung.equals("right")){
            return (tempPos[1]+1 < spalten && mars[ roverPosition[0] ][ roverPosition[1]+1] !='#');
        }
        else if ( richtung.equals("up")   ){
            return (tempPos[0]-1 >= 0      && mars[ roverPosition[0]-1 ][ roverPosition[1]] !='#');
        }
        else if ( richtung.equals("down") ){
            return (tempPos[0]+1 < zeilen  && mars[ roverPosition[0]+1 ][ roverPosition[1]] !='#');
        }
        return false;
    }
*/
}
