import java.util.ArrayList;

public abstract class Piece {
    private Color pcolor;
    public ArrayList<Move> legalMoves = new ArrayList<>(); 
    public char tmpn;

    public Piece(Color c)
    {
        this.pcolor=c;
    }
    public Piece()
    {
        
    }
    public Piece(Piece p)
    {
        this.pcolor=p.pcolor;
        this.tmpn=p.tmpn;
    }
   
    public Color getPcolor()
    {
        return pcolor;
    }
    // public static boolean correctMove(piece p,int x1,int y1,int x2,int y2) {/////////abstract///////
        
    //     if(p instanceof pawn)
    //         return pawn.correctMove(p,x1,y1,x2,y2);
    //     else if(p instanceof knight)
    //         return false;/////

    //     return false;
    // }


    public abstract void legalMoves(Board board, int x1, int y1);

}
