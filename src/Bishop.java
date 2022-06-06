public final class Bishop extends Piece {

    public Bishop(Color c) {
        super(c);
        //tmpn = 'b';
    }

    public void getLegalMoves(Board board, int x1, int y1) {
        legalMoves.clear();

        for (int i = x1 + 1, j = y1 + 1; i < 8 && j < 8; i++, j++) //// up right
        {
            if (board.getSquare(i, j).getPiece() == null) {
                legalMoves.add(new Move(i, j));
            } else if (board.getSquare(i, j).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, j));
                break;
            } else if (board.getSquare(i, j).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = x1 - 1, j = y1 - 1; i >= 0 && j >= 0; i--, j--) //// down left
        {
            if (board.getSquare(i, j).getPiece() == null) {
                legalMoves.add(new Move(i, j));
            } else if (board.getSquare(i, j).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, j));
                break;
            } else if (board.getSquare(i, j).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = x1 - 1, j = y1 + 1; i >= 0 && j < 8; i--, j++) //// up left
        {
            if (board.getSquare(i, j).getPiece() == null) {
                legalMoves.add(new Move(i, j));
            } else if (board.getSquare(i, j).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, j));
                break;
            } else if (board.getSquare(i, j).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = x1 + 1, j = y1 - 1; i < 8 && j >= 0; i++, j--) //// down right
        {
            if (board.getSquare(i, j).getPiece() == null) {
                legalMoves.add(new Move(i, j));
            } else if (board.getSquare(i, j).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, j));
                break;
            } else if (board.getSquare(i, j).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
    }

}
