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

        if      (eingabe == 'f' && checkDirection('f')) rover.goForward();
        else if (eingabe == 'b' && checkDirection('b')) rover.goBackward();
        else if (eingabe == 'l' ) rover.turnLeft();
        else if (eingabe == 'r' ) rover.turnRight();

        // Anpassung der Rover-Ausgabe auf dem Feld gemäß der aktuellen Richtung bzw. der aktuellen Position des Rovers
        Field.addItem(roverPosition, rover.getDirection() );
    }


    private static boolean checkDirection(char movingDirection ){

        int[] position = roverPosition;
        char  richtung = rover.getDirection();

        if      (movingDirection == 'f' ){
            if      (richtung == '^') return Field.checkUp(position);
            else if (richtung == '>') return Field.checkRight(position);
            else if (richtung == 'v') return Field.checkDown(position);
            else if (richtung == '<') return Field.checkLeft(position);
        }
        else if (movingDirection == 'b' ){
            if      (richtung == '^') return Field.checkDown(position);
            else if (richtung == '>') return Field.checkLeft(position);
            else if (richtung == 'v') return Field.checkUp(position);
            else if (richtung == '<') return Field.checkRight(position);
        }

        return false;
    }

}
