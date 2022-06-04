public class Knight extends Piece{
    
    public Knight(Color c)
    {
        super(c);
        tmpn='n';
    }


    public void legalMoves(Board board, int x1, int y1)
    {
        legalMoves.clear();///////remove All
        
        if(x1+2<8)
        {
            if(y1+1<8)
            {
                if(board.getSquare(x1+2,y1+1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+2, y1+1));
                }
                else if(board.getSquare(x1+2, y1+1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+2, y1+1));
                }
            }
            if(y1-1>=0)
            {
                if(board.getSquare(x1+2, y1-1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+2, y1-1));
                }
                else if(board.getSquare(x1+2, y1-1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+2, y1-1));
                }
            }
        }
        if(x1-2>=0)
        {
            if(y1+1<8)
            {
                if(board.getSquare(x1-2, y1+1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-2, y1+1));
                }
                else if(board.getSquare(x1-2, y1+1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-2, y1+1));
                }
            }
            if(y1-1>=0)
            {
                if(board.getSquare(x1-2, y1-1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-2, y1-1));
                }
                else if(board.getSquare(x1-2, y1-1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-2, y1-1));
                }
            }
        }
        if(x1+1<8)
        {
            if(y1+2<8)
            {
                if(board.getSquare(x1+1, y1+2).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+1, y1+2));
                }
                else if(board.getSquare(x1+1, y1+2).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+1, y1+2));
                }
            }
            if(y1-2>=0)
            {
                if(board.getSquare(x1+1, y1-2).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+1, y1-2));
                }
                else if(board.getSquare(x1+1, y1-2).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+1, y1-2));
                }
            }
        }
        if(x1-1>=0)
        {
            if(y1+2<8)
            {
                if(board.getSquare(x1-1,y1+2).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-1, y1+2));
                }
                else if(board.getSquare(x1-1,y1+2).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-1, y1+2));
                }
            }
            if(y1-2>=0)
            {
                if(board.getSquare(x1-1, y1-2).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-1, y1-2));
                }
                else if(board.getSquare(x1-1, y1-2).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-1, y1-2));
                }
            }
        }   
    }
}
