public class Pawn extends Piece {
    //public boolean firstMove;
    //public boolean promote;


    public Pawn(Color c)
    {
        super(c);
        tmpn='p';
        //firstMove=true;
        //promote=false;
    }

    public void legalMoves(Board board, int x1, int y1)
    {
        ///board limit 0 to 7
        int i=0;
        legalMoves.clear();///////remove All
        if(getPcolor()==Color.WHITE)
            i=1;
        else
            i=-1;

        if(y1+i<8 && y1+i>=0)
        {
            if(board.getSquare(x1, y1+i).getPiece()==null)
            {
                legalMoves.add(new Move(x1,y1+i));

                if((y1==1&&getPcolor()==Color.WHITE)||(y1==6&&getPcolor()==Color.BLACK))
                {
                    if(board.getSquare(x1, y1+i*2).getPiece()==null)//firstMove
                        legalMoves.add(new Move(x1,y1+i*2));
                }
            }
            if(x1+1<8)
            {
                if(board.getSquare(x1+1, y1+i).getPiece()!=null&&board.getSquare(x1+1, y1+i).getPiece().getPcolor()!=getPcolor())
                    legalMoves.add(new Move(x1+1,y1+i));

            }
            if(x1-1>=0)
            {
                if(board.getSquare(x1-1, y1+i).getPiece()!=null&&board.getSquare(x1-1, y1+i).getPiece().getPcolor()!=getPcolor())
                    legalMoves.add(new Move(x1-1,y1+i));

            }
        }
        //promote?
        //en pessant?

    }



}
