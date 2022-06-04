

public class Board {
    private Square[][] square = new Square[8][8];

    public Board()
    {
        for(int i =0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                square[j][i]=new Square();

            }

        }

        square[0][0].setPiece(new Rook(Color.WHITE));
        square[1][0].setPiece(new Knight(Color.WHITE));
        square[2][0].setPiece(new Bishop(Color.WHITE));
        square[3][0].setPiece(new Queen(Color.WHITE));
        square[4][0].setPiece(new King(Color.WHITE));
        square[5][0].setPiece(new Bishop(Color.WHITE));
        square[6][0].setPiece(new Knight(Color.WHITE));
        square[7][0].setPiece(new Rook(Color.WHITE));
        square[0][1].setPiece(new Pawn(Color.WHITE));
        square[1][1].setPiece(new Pawn(Color.WHITE));
        square[2][1].setPiece(new Pawn(Color.WHITE));
        square[3][1].setPiece(new Pawn(Color.WHITE));
        square[4][1].setPiece(new Pawn(Color.WHITE));
        square[5][1].setPiece(new Pawn(Color.WHITE));
        square[6][1].setPiece(new Pawn(Color.WHITE));
        square[7][1].setPiece(new Pawn(Color.WHITE));

        square[0][7].setPiece(new Rook(Color.BLACK));
        square[1][7].setPiece(new Knight(Color.BLACK));
        square[2][7].setPiece(new Bishop(Color.BLACK));
        square[3][7].setPiece(new Queen(Color.BLACK));
        square[4][7].setPiece(new King(Color.BLACK));
        square[5][7].setPiece(new Bishop(Color.BLACK));
        square[6][7].setPiece(new Knight(Color.BLACK));
        square[7][7].setPiece(new Rook(Color.BLACK));
        square[0][6].setPiece(new Pawn(Color.BLACK));
        square[1][6].setPiece(new Pawn(Color.BLACK));
        square[2][6].setPiece(new Pawn(Color.BLACK));
        square[3][6].setPiece(new Pawn(Color.BLACK));
        square[4][6].setPiece(new Pawn(Color.BLACK));
        square[5][6].setPiece(new Pawn(Color.BLACK));
        square[6][6].setPiece(new Pawn(Color.BLACK));
        square[7][6].setPiece(new Pawn(Color.BLACK));


    }

    public void setSquare(int x, int y, Square square){
        this.square[x][y] = square;    
    }


    public Square getSquare(int x, int y){
        return square[x][y];
    }



    public boolean makeMove(Color c,int x1, int y1, int x2, int y2) {
        if(isLegal(c, x1, y1, x2, y2))
        {
            square[x2][y2].setPiece(square[x1][y1].getPiece());
            square[x1][y1].setPiece(null);
            Gui.move(x1, y1, x2, y2);
            return true;
            
        }
        return false;
    }
    ///////////////////////////////////////////////
    public boolean isLegal(Color c, int x1, int y1, int x2, int y2) {
        if(square[x1][y1].getPiece() != null)
        {
            if(square[x1][y1].getPiece().getPcolor()==c)
            {
                square[x1][y1].getPiece().legalMoves(this, x1, y1);
                for(int i=0;i<square[x1][y1].getPiece().legalMoves.size();i++)
                {
                    if(square[x1][y1].getPiece().legalMoves.get(i).equals(x2, y2))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

      
    public void print()
    {
        for(int i =7;i>=0;i--)
        {
            System.out.print("\n\t\t\t\t\t\t\t\t ---------------------------------\n");
            System.out.print("\t\t\t\t\t\t\t\t"+i+"|");
            for(int j=0;j<8;j++)
            {
                if(square[j][i].getPiece()!=null)
                {
                    System.out.print(" ");
                    if(square[j][i].getPiece().getPcolor()==Color.BLACK)
                        System.out.print("\u001B[33m"+square[j][i].getPiece().tmpn+"\u001B[0m");
                    else
                        System.out.print(square[j][i].getPiece().tmpn);
                    System.out.print(" |");
                }
                else{
                    System.out.print("   |");
                }
                

            }
            
        }
        System.out.print("\n\t\t\t\t\t\t\t\t ---------------------------------\n");
        System.out.print("\t\t\t\t\t\t\t\t   0   1   2   3   4   5   6   7  \n\n");

    }
   

}
