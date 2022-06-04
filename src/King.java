public class King extends Piece{

    public King(Color c)
    {
        super(c);
        tmpn='k';
    }
    ///////
    private void kingMoves(Board board, int x1, int y1)
    {
        legalMoves.clear();

        if(y1+1<8)           ////up
        {
            if(board.getSquare(x1,y1+1).getPiece()==null)
            {
                legalMoves.add(new Move(x1,y1+1));
            }
            else if(board.getSquare(x1,y1+1).getPiece().getPcolor()!=getPcolor())
            {
                legalMoves.add(new Move(x1,y1+1));
            }
            if(x1+1<8)       ////up right
            {
                if(board.getSquare(x1+1,y1+1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+1,y1+1));
                }
                else if(board.getSquare(x1+1,y1+1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+1,y1+1));
                }
            }
            if(x1-1>=0)       ////up left
            {
                if(board.getSquare(x1-1,y1+1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-1,y1+1));
                }
                else if(board.getSquare(x1-1,y1+1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-1,y1+1));
                }
            }
        }
        if(y1-1>=0)           ////down
        {
            if(board.getSquare(x1,y1-1).getPiece()==null)
            {
                legalMoves.add(new Move(x1,y1-1));
            }
            else if(board.getSquare(x1,y1-1).getPiece().getPcolor()!=getPcolor())
            {
                legalMoves.add(new Move(x1,y1-1));
            }
            if(x1+1<8)       ////down right
            {
                if(board.getSquare(x1+1,y1-1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1+1,y1-1));
                }
                else if(board.getSquare(x1+1,y1-1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1+1,y1-1));
                }
            }
            if(x1-1>=0)       ////down left
            {
                if(board.getSquare(x1-1,y1-1).getPiece()==null)
                {
                    legalMoves.add(new Move(x1-1,y1-1));
                }
                else if(board.getSquare(x1-1,y1-1).getPiece().getPcolor()!=getPcolor())
                {
                    legalMoves.add(new Move(x1-1,y1-1));
                }
            }
        }
        if(x1+1<8)           ////right
        {
            if(board.getSquare(x1+1,y1).getPiece()==null)
            {
                legalMoves.add(new Move(x1+1,y1));
            }
            else if(board.getSquare(x1+1,y1).getPiece().getPcolor()!=getPcolor())
            {
                legalMoves.add(new Move(x1+1,y1));
            }
        }
        if(x1-1>=0)           ////left
        {
            if(board.getSquare(x1-1,y1).getPiece()==null)
            {
                legalMoves.add(new Move(x1-1,y1));
            }
            else if(board.getSquare(x1-1,y1).getPiece().getPcolor()!=getPcolor())
            {
                legalMoves.add(new Move(x1-1,y1));
            }
        }
    }
    
    public void legalMoves(Board board, int x1, int y1)
    {//////////////pawn attack
        kingMoves(board, x1, y1);
        int num = legalMoves.size();

        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board.getSquare(i,j).getPiece()!=null)
                {
                    if(board.getSquare(i,j).getPiece().getPcolor()!=getPcolor()&&!(board.getSquare(i,j).getPiece() instanceof King))
                    {
                        board.getSquare(i,j).getPiece().legalMoves(board, i,j);
                        int num2 = board.getSquare(i,j).getPiece().legalMoves.size();
                        for(int k=0;k<num2;k++)
                        {
                            for(int h=0;h<num;h++)
                            {
                                if(legalMoves.get(h).equals(board.getSquare(i,j).getPiece().legalMoves.get(k)))
                                {
                                    legalMoves.remove(board.getSquare(i,j).getPiece().legalMoves.get(k));
                                    num--;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean check(Board board, int x, int y)
    {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board.getSquare(i,j).getPiece()!=null)
                {
                    if(board.getSquare(i,j).getPiece().getPcolor()!=getPcolor()&&!(board.getSquare(i,j).getPiece() instanceof King))
                    {
                        board.getSquare(i,j).getPiece().legalMoves(board, i,j);
                        int num2 = board.getSquare(i,j).getPiece().legalMoves.size();
                        for(int k=0;k<num2;k++)
                        {
                            if(board.getSquare(i,j).getPiece().legalMoves.get(k).equals(x,y))
                            {
                                return true; 
                            }
                        
                        }
                    }
                }
            }
        }

        return false;
    }

    ///////////////////////////
    public boolean checkMate(Board board, int x, int y)
    {
        if(check(board, x, y) && legalMoves == null){
            
        }
        

        return false;
    }
    //public  simLegalMoves()

}
