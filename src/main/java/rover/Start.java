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
            moveRover(eingabe.charAt(i));
            drawOutput();
        }

    }

    private static void initField() {

        mars = new char[zeilen][spalten];
        int mitteZeilen  = zeilen/2;
        int mitteSpalten = spalten/2;

        for (int i = 0; i < zeilen; i++) {
            for (int j = 0; j < spalten; j++) {
                if (r.nextDouble() < 0.25 && !(mitteZeilen == i && mitteSpalten == j)) {
                    mars[i][j]= '#';
                }else{
                    mars[i][j]= ' ';
                }
            }
        }
        mars[mitteZeilen][mitteSpalten]= '^';
    }

    private static void drawOutput() {

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

    private static void moveRover(char eingabe){

        mars[roverPosition[0]][roverPosition[1]]=' ';

        if (eingabe=='f'){
            if      (aktuelleRichtung == '^' ) roverPosition[0]--;
            else if (aktuelleRichtung == '<' ) roverPosition[1]--;
            else if (aktuelleRichtung == 'v' ) roverPosition[0]++;
            else if (aktuelleRichtung == '>' ) roverPosition[1]++;
        }
        else if ( eingabe == 'b'){
            if      (aktuelleRichtung == '^' ) roverPosition[0]++;
            else if (aktuelleRichtung == '<' ) roverPosition[1]++;
            else if (aktuelleRichtung == 'v' ) roverPosition[0]--;
            else if (aktuelleRichtung == '>' ) roverPosition[1]--;
        }
        else if(eingabe == 'l' ){
            if      ( aktuelleRichtung =='^')  aktuelleRichtung = '<';
            else if ( aktuelleRichtung == '<') aktuelleRichtung = 'v';
            else if ( aktuelleRichtung == 'v') aktuelleRichtung = '>';
            else if ( aktuelleRichtung == '>') aktuelleRichtung = '^';
        }
        else if(eingabe == 'r' ){
            if      ( aktuelleRichtung =='^')  aktuelleRichtung = '>';
            else if ( aktuelleRichtung == '<') aktuelleRichtung = '^';
            else if ( aktuelleRichtung == 'v') aktuelleRichtung = '<';
            else if ( aktuelleRichtung == '>') aktuelleRichtung = 'v';
        }
    }


}
