package rover;

public class Rover {

    private int[] position;
    private char richtung;


    public Rover( int[] position, char richtung){

        this.position = position;
        this.richtung = richtung;
    }

    public void turnLeft(){

        if      ( richtung =='^')  richtung = '<';
        else if ( richtung == '<') richtung = 'v';
        else if ( richtung == 'v') richtung = '>';
        else if ( richtung == '>') richtung = '^';

    }

    public void turnRight(){

        if      ( richtung == '^') richtung = '>';
        else if ( richtung == '<') richtung = '^';
        else if ( richtung == 'v') richtung = '<';
        else if ( richtung == '>') richtung = 'v';

    }

    public void goForward(){

        if      (richtung == '^' ) position[0]--;
        else if (richtung == '<' ) position[1]--;
        else if (richtung == 'v' ) position[0]++;
        else if (richtung == '>' ) position[1]++;
    }

    public void goBackward(){

        if      (richtung == '^' ) position[0]++;
        else if (richtung == '<' ) position[1]++;
        else if (richtung == 'v' ) position[0]--;
        else if (richtung == '>' ) position[1]--;
    }

    public int[] getPosition(){
        return position;
    }

    public char getDirection(){
        return richtung;
    }
}
