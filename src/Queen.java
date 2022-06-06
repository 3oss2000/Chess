public final class Queen extends Piece {

    public Queen(Color c) {
        super(c);
        //tmpn = 'q';
    }

    public void getLegalMoves(Board board, int x1, int y1) {
        legalMoves.clear();

        for (int i = y1 + 1; i < 8; i++) //// up
        {
            if (board.getSquare(x1, i).getPiece() == null) {
                legalMoves.add(new Move(x1, i));
            } else if (board.getSquare(x1, i).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(x1, i));
                break;
            } else if (board.getSquare(x1, i).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = y1 - 1; i >= 0; i--) //// down
        {
            if (board.getSquare(x1, i).getPiece() == null) {
                legalMoves.add(new Move(x1, i));
            } else if (board.getSquare(x1, i).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(x1, i));
                break;
            } else if (board.getSquare(x1, i).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = x1 + 1; i < 8; i++) //// right
        {
            if (board.getSquare(i, y1).getPiece() == null) {
                legalMoves.add(new Move(i, y1));
            } else if (board.getSquare(i, y1).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, y1));
                break;
            } else if (board.getSquare(i, y1).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
        for (int i = x1 - 1; i >= 0; i--) //// left
        {
            if (board.getSquare(i, y1).getPiece() == null) {
                legalMoves.add(new Move(i, y1));
            } else if (board.getSquare(i, y1).getPiece().getPcolor() != getPcolor()) {
                legalMoves.add(new Move(i, y1));
                break;
            } else if (board.getSquare(i, y1).getPiece().getPcolor() == getPcolor()) {
                break;
            }
        }
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
