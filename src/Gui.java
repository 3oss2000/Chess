import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*; //ActionListener , ActionEvent
import java.awt.Color;

public final class Gui {
    private final JPanel gui = new JPanel(new BorderLayout(3, 3)); // creating gui and addong gaps
    private static JButton[][] tiles = new JButton[8][8]; // array made of buttons
    private static JPanel chessBoard; // playground
    private static final String letters = "ABCDEFGH";

    private static final int iconSize = 50;
    private static boolean firstClicked = false;
    private static boolean secondClicked = false;
    private static JLabel message = new JLabel("");
    private static int[] points = { -1, -1, -1, -1 };

    final static Icon whitePawnIco = new ImageIcon(new ImageIcon("Pics\\White\\Pawn.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon whiteKingIco = new ImageIcon(new ImageIcon("Pics\\White\\King.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon whiteKnightIco = new ImageIcon(new ImageIcon("Pics\\White\\Knight.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon whiteQueenIco = new ImageIcon(new ImageIcon("Pics\\White\\Queen.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon whiteRookIco = new ImageIcon(new ImageIcon("Pics\\White\\Rook.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon whiteBishopIco = new ImageIcon(new ImageIcon("Pics\\White\\Bishop.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));

    final static Icon blackPawnIco = new ImageIcon(new ImageIcon("Pics\\Black\\Pawn.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon blackKingIco = new ImageIcon(new ImageIcon("Pics\\Black\\King.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon blackKnightIco = new ImageIcon(new ImageIcon("Pics\\Black\\Knight.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon blackQueenIco = new ImageIcon(new ImageIcon("Pics\\Black\\Queen.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon blackRookIco = new ImageIcon(new ImageIcon("Pics\\Black\\Rook.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));
    final static Icon blackBishopIco = new ImageIcon(new ImageIcon("Pics\\Black\\Bishop.png").getImage()
            .getScaledInstance(iconSize, iconSize, Image.SCALE_DEFAULT));

    final static ImageIcon transIcon = new ImageIcon(
            new BufferedImage(iconSize, iconSize, BufferedImage.TYPE_INT_ARGB)); // fill with transparent icon

    public final void initializeGui() {
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));// creating the board and adding inset
        JToolBar tools = new JToolBar();// calling JtoolBar class to add toolbar
        tools.setFloatable(false); // disable floating
        gui.add(tools, BorderLayout.PAGE_START);// set toolbar top
        tools.add(message);

        gui.add(new JLabel(""), BorderLayout.LINE_START);// start new line

        chessBoard = new JPanel(new GridLayout(0, 9));
        chessBoard.setBorder(new LineBorder(Color.BLACK));
        gui.add(chessBoard);

        createGameBoard();
        newGame();

        chessBoard.add(new JLabel(""));

        for (int i = 0; i < 8; i++) {
            chessBoard.add(new JLabel(letters.substring(i, i + 1), SwingConstants.CENTER)); // adding leters centered ,
                                                                                            // substring used for
                                                                                            // spliting strings
        }
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (j == 0) {
                    chessBoard.add(new JLabel("" + (i + 1), SwingConstants.CENTER)); // adding numbers centered
                }
                chessBoard.add(tiles[j][i]); // adding tiles
            }
        }
    }

    private void createGameBoard() {
        Insets buttonMargin = new Insets(0, 0, 0, 0); // margin insets for button

        // create buttons in the array and point to them
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                JButton b = new JButton();
                b.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        calcPointArr(b);
                    }

                });
                b.setMargin(buttonMargin);

                b.setIcon(transIcon);
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.BLACK);
                }
                tiles[i][j] = b;
            }
        }

    }

    private void calcPointArr(JButton b) {
        if (!firstClicked) {
            points[0] = (b.getX() / iconSize) - 1;
            points[1] = 8 - (b.getY() / iconSize);

            secondClicked = false;
            firstClicked = true;
        } else {
            points[2] = (b.getX() / iconSize) - 1;
            points[3] = 8 - (b.getY() / iconSize);

            secondClicked = true;
            firstClicked = false;
        }
    }

    public static int[] getPointArr() {
        if (secondClicked)
            return points;
        int[] temp = { -1, -1, -1, -1 };
        return temp;
    }

    private void clear() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].setIcon(transIcon);
            }
        }
    }

    public final void newGame() {
        clear();
        tiles[0][7].setIcon(blackRookIco);
        tiles[1][7].setIcon(blackKnightIco);
        tiles[2][7].setIcon(blackBishopIco);
        tiles[3][7].setIcon(blackQueenIco);
        tiles[4][7].setIcon(blackKingIco);
        tiles[5][7].setIcon(blackBishopIco);
        tiles[6][7].setIcon(blackKnightIco);
        tiles[7][7].setIcon(blackRookIco);
        for (int i = 0; i < 8; i++) {
            tiles[i][6].setIcon(blackPawnIco);
        }
        tiles[0][0].setIcon(whiteRookIco);
        tiles[1][0].setIcon(whiteKnightIco);
        tiles[2][0].setIcon(whiteBishopIco);
        tiles[3][0].setIcon(whiteQueenIco);
        tiles[4][0].setIcon(whiteKingIco);
        tiles[5][0].setIcon(whiteBishopIco);
        tiles[6][0].setIcon(whiteKnightIco);
        tiles[7][0].setIcon(whiteRookIco);

        for (int i = 0; i < 8; i++) {
            tiles[i][1].setIcon(whitePawnIco);
        }

    }

    public final JComponent getGui() {
        return gui;
    }

    public static void move(int oldX, int oldY, int newX, int newY) {
        if ((newX != oldX || newY != oldY) && newX != -1) {

            tiles[newX][newY].setIcon(tiles[oldX][oldY].getIcon());
            tiles[oldX][oldY].setIcon(transIcon);
            secondClicked = false;
        }
    }

    public static boolean getSecondClicked() {
        return secondClicked;

    }

    public static void setMessage(String msg) {
        message.setText(msg);
    }

}