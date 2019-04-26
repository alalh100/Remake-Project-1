package rover;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class Start {

	static Random r = new Random();
	private static char[][] mars;
    private static int zeilen  = 20;
    private static int spalten = 80;
    private static char aktuelleRichtung = '^';
    private static int[] roverPosition = new int []{10 ,40 };

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

	public static String get(Map<int[], String> kloetze, int[] p) {
		Set<Entry<int[], String>> entrySet = kloetze.entrySet();
		for (Entry<int[], String> entry : entrySet) {
			if (entry.getKey()[0] == p[0] && entry.getKey()[1] == p[1])
				return entry.getValue();
		}
		return null;
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

	public static void main(String[] args) {

		if (args.length > 1) {
			long seed = Long.parseLong(args[1]);
			r.setSeed(seed);
			// System.out.println("Seed: " + seed);
		}
		init();
		String pg = args[0];
		out();
		for (int i = 0; i < pg.length(); i++) {
			make(pg.charAt(i));
			out();
		}
	}

	public static void make(char c) {
		if (c == 'f') {
			int[] p = findeRover();
			if (get(mars, p).equals("n"))
				p[1]--;
			else if (get(mars, p).equals("s"))
				p[1]++;
			else if (get(mars, p).equals("e"))
				p[0]++;
			else if (get(mars, p).equals("w"))
				p[0]--;
		} else if (c == 'b') {
			int[] p = findeRover();
			if (get(mars, p).equals("s"))
				p[1]--;
			else if (get(mars, p).equals("n"))
				p[1]++;
			else if (get(mars, p).equals("w"))
				p[0]++;
			else if (get(mars, p).equals("e"))
				p[0]--;
		} else if (c == 'l') {
			int[] p = findeRover();
			if (get(mars, p).equals("n"))
				mars.put(p, "w");
			else if (get(mars, p).equals("s"))
				mars.put(p, "e");
			else if (get(mars, p).equals("e"))
				mars.put(p, "n");
			else if (get(mars, p).equals("w"))
				mars.put(p, "s");
		} else if (c == 'r') {
			int[] p = findeRover();
			if (get(mars, p).equals("w"))
				mars.put(p, "n");
			else if (get(mars, p).equals("e"))
				mars.put(p, "s");
			else if (get(mars, p).equals("n"))
				mars.put(p, "e");
			else if (get(mars, p).equals("s"))
				mars.put(p, "w");
		}

	}


}
