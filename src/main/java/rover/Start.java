package rover;

import java.util.Random;

public class Start {
    private static Random r = new Random();
    private static char[][] mars;
    private static int zeilen  = 20;
    private static int spalten = 80;
    private static char aktuelleRichtung = '^';
    private static int[] roverPosition = new int []{10 ,40 };

    public static void main(String[] args) {

        if (args.length > 1) {
            long seed = Long.parseLong(args[1]);
            r.setSeed(seed);
        }

        initField();
        String eingabe = args[0];
        drawOutput();

        for (int i = 0; i < eingabe.length(); i++) {
            readInstructions(eingabe.charAt(i));
            drawOutput();
        }

    }

    private static void initField() {

        mars = new char[zeilen][spalten];

        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                if (r.nextDouble() < 0.25 && !(roverPosition[0] == i && roverPosition[1] == j)) {
                    mars[i][j]= '#';
                }else{
                    mars[i][j]= ' ';
                }
            }
        }
    }

    private static void drawOutput() {
        // Anpassung der Rover-Ausgabe auf dem Feld gemäß der aktuellen Richtung bzw. der aktuellen Position des Rovers
        mars[roverPosition[0]][roverPosition[1]]= aktuelleRichtung;

        for (int j = 0; j < zeilen; j++) {
            for (int i = 0; i < spalten; i++) {
                System.out.print(mars[j][i]);
            }
            System.out.println();
        }
        for(int i = 0; i < spalten; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    private static void readInstructions(char eingabe){
        // Die nächste Zeile löscht die alte Position des Rovers, um mehrfache Ausgabe des Rovers zu verhindern.
        mars[roverPosition[0]][roverPosition[1]]=' ';

        turnRover(eingabe);         // nur falls nötig
        go(eingabe);
    }

    private static void  go(char richtung){

        if (richtung =='f'){
            if      (aktuelleRichtung == '^' && checkDirection("up"   )) roverPosition[0]--;
            else if (aktuelleRichtung == '<' && checkDirection("left" )) roverPosition[1]--;
            else if (aktuelleRichtung == 'v' && checkDirection("down" )) roverPosition[0]++;
            else if (aktuelleRichtung == '>' && checkDirection("right")) roverPosition[1]++;
        }
        else if ( richtung == 'b'){
            if      (aktuelleRichtung == '^' && checkDirection("down" )) roverPosition[0]++;
            else if (aktuelleRichtung == '<' && checkDirection("right")) roverPosition[1]++;
            else if (aktuelleRichtung == 'v' && checkDirection("up"   )) roverPosition[0]--;
            else if (aktuelleRichtung == '>' && checkDirection("left" )) roverPosition[1]--;
        }
    }

    private static void turnRover( char richtung){

        if(richtung == 'l' ){
            if      ( aktuelleRichtung =='^')  aktuelleRichtung = '<';
            else if ( aktuelleRichtung == '<') aktuelleRichtung = 'v';
            else if ( aktuelleRichtung == 'v') aktuelleRichtung = '>';
            else if ( aktuelleRichtung == '>') aktuelleRichtung = '^';
        }
        else if(richtung == 'r' ){
            if      ( aktuelleRichtung =='^')  aktuelleRichtung = '>';
            else if ( aktuelleRichtung == '<') aktuelleRichtung = '^';
            else if ( aktuelleRichtung == 'v') aktuelleRichtung = '<';
            else if ( aktuelleRichtung == '>') aktuelleRichtung = 'v';
        }
    }

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

}
