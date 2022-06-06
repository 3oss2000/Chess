import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public final class Peer {
    ServerSocket serverSocket;
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    String ip;
    int port;
    boolean yourTurn = false;
    boolean accepted = false;
    boolean unableToCommunicateWithOpponent = false;
    int errors = 0;
    Scanner scanner = new Scanner(System.in);
    Color c = Color.BLACK;
    int i = 0;
    boolean correctMove = false;

    public Peer(String ip, int port) {
        this.ip = ip;
        if (this.port < 1 || this.port > 65535) {
            this.port = port;
        }
    }

    public void startCommunication() throws InterruptedException {

        Board board = new Board();

        if (!connected()) {
            initializeServer();
        }

        // board.print();

        while (true) {

            if (errors >= 10)
                unableToCommunicateWithOpponent = true;

            if (!yourTurn && !unableToCommunicateWithOpponent) {
                // board.print();
                try {
                    Gui.setMessage("Opponent's Turn");

                    System.out.println("reading\n");

                    if (i == 1)
                        c = Color.BLACK;
                    else
                        c = Color.WHITE;

                    byte[] datar = new byte[4];
                    dis.readFully(datar);

                    board.makeMove(c, (int) datar[0], (int) datar[1], (int) datar[2], (int) datar[3]);

                    // board.print();
                    System.out.println("recieved : " + (int) datar[0] + " " + (int) datar[1] + " " + (int) datar[2]
                            + " " + (int) datar[3] + "\n");

                    if (board.isChecked()) {
                        JOptionPane.showMessageDialog(null, "CHECK!");
                        System.out.println("CHECK!!!!!!");
                    }
                    if (board.won()) {
                        JOptionPane.showMessageDialog(null, "GAME OVER!");
                        System.out.println("GAME OVER!!!!!!");
                        break;
                    }
                    yourTurn = true;
                    Gui.setMessage("Your Turn");

                } catch (IOException e) {
                    e.printStackTrace();
                    errors++;
                }
            }

            if (accepted) {
                //Gui.setMessage("");
                //board.print();
                if (yourTurn && !unableToCommunicateWithOpponent) {
                    Gui.setMessage("Your Turn");

                    int x1, y1, x2, y2;

                    
                    
                    if (i == 0)
                        c = Color.BLACK;
                    else
                        c = Color.WHITE;

                    do {
                        do {
                            x1 = Gui.getPointArr()[0];
                            y1 = Gui.getPointArr()[1];
                            x2 = Gui.getPointArr()[2];
                            y2 = Gui.getPointArr()[3];
                            TimeUnit.MILLISECONDS.sleep(1);
                        } while (x1 == -1);
                        correctMove = board.makeMove(c, x1, y1, x2, y2);
                        yourTurn = false;
                        Gui.setMessage("Opponent's Turn");
                    } while (!correctMove);
                    correctMove = false;


                    try {
                        byte[] data = new byte[4];
                        data[0] = (byte) x1;
                        data[1] = (byte) y1;
                        data[2] = (byte) x2;
                        data[3] = (byte) y2;
                        dos.write(data);
                        dos.flush();
                    } catch (IOException e1) {
                        errors++;
                        e1.printStackTrace();
                    }

                    System.out.println("DATA WAS SENT");
                    if (board.isChecked()) {
                        JOptionPane.showMessageDialog(null, "CHECK!");
                        System.out.println("CHECKKKKK!!!!!!");
                    }
                    if (board.won()) {
                        JOptionPane.showMessageDialog(null, "GAME OVER!");
                        System.out.println("GAME OVER!!!!!!");
                        break;
                    }
                    
                }
            } 
            else {
                Gui.setMessage("Waiting for other player");
            }

            if (c == Color.WHITE && !accepted) {
                listenForServerRequest();
            }
        }

    }

    private void initializeServer() {
        try {
            serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
        } catch (Exception e) {
            e.printStackTrace();
        }
        yourTurn = true;

        i = 1;

        c = Color.WHITE;
    }

    private boolean connected() {
        try {
            socket = new Socket(ip, port);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
        } catch (IOException e) {
            System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
            return false;
        }
        System.out.println("Successfully connected to the server.");
        return true;
    }

    private void listenForServerRequest() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            accepted = true;
            System.out.println("CLIENT HAS REQUESTED TO JOIN, AND WE HAVE ACCEPTED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
