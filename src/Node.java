public class Node {
    private int jugA, jugB, jugC;

    public Node(int jugA, int jugB, int jugC){
        this.jugA = jugA;
        this.jugB = jugB;
        this.jugC = jugC;
    }

    public int getJugA(){
        return jugA;
    }

    public int getJugB(){
        return jugB;
    }

    public int getJugC(){
        return jugC;
    }

    public String toString(){
        return "( " + this.jugA + ", " + this.jugB + ", " + this.jugC + " )";
    }
}
