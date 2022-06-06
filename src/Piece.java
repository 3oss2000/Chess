import java.util.ArrayList;

public abstract class Piece {
    private Color pcolor;
    public ArrayList<Move> legalMoves = new ArrayList<>();
    //public char tmpn;

    public Piece(Color c) {
        this.pcolor = c;
    }

    public Piece(Piece p) {
        this.pcolor = p.pcolor;
        //this.tmpn = p.tmpn;
    }

    public Color getPcolor() {
        return pcolor;
    }

    public abstract void getLegalMoves(Board board, int x1, int y1);

}
