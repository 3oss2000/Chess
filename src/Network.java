import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Network {
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
    boolean circle = true;
    Color c = Color.BLACK;
    int i = 0;
    boolean correctMove=false; 

    public void game() throws InterruptedException{

        Board board = new Board();

        // System.out.println("Please input the IP: ");
        // ip = scanner.nextLine();
        // System.out.println("Please input the port: ");
        // port = scanner.nextInt();

        ip="localhost";
        port=8080;


        while(port<1||port>65535){
            System.out.println("The port you entered was invalid, please input another port: ");
            port = scanner.nextInt();
        }


        if(!connected())
            initializeServer();


        board.print();

        while(true){


            if (errors >= 10) 
                unableToCommunicateWithOpponent = true;

            
            if (!yourTurn && !unableToCommunicateWithOpponent) {
                board.print();
                try {
                    System.out.println("reading\n");

                    
                   
                    if (i==1)
                        c=Color.BLACK;
                    else
                        c=Color.WHITE;

                    byte[] datar = new byte[4];
                    dis.readFully(datar);
                    //System.out.println(datar[0] + datar[1] + datar[2] + "\n");
                    board.makeMove(c, (int)datar[0], (int)datar[1], (int)datar[2], (int)datar[3]);
                    // Gui.move((int)datar[0], (int)datar[1],(int)datar[2], (int)datar[3]);
                    board.print();

                    System.out.println("recieved           " + (int)datar[0] + (int)datar[1] + (int)datar[2] + (int)datar[3] + "\n");
                    //gameBoard[(int)datar[0]][(int)datar[1]] = (int)datar[2];
                    // if (circle) spaces[space] = "X";
                    // else spaces[space] = "O";
                    // checkForEnemyWin();
                    // checkForTie();
                    yourTurn = true;
                } catch (IOException e) {
                    e.printStackTrace();
                    errors++;
                }
            }

            if (accepted) {
                board.print();
                if (yourTurn && !unableToCommunicateWithOpponent ) { //&& !won && !enemyWon
                    int x1,y1,x2,y2;
                    
                   
                   

                    if (true) {
                        // if (!circle) spaces[position] = "X";
                        // else spaces[position] = "O";
                        //gameBoard[(int)x][(int)y] = (int)move;
                        if (i==0)
                            c=Color.BLACK;
                        else
                            c=Color.WHITE;


                        //if(Gui.getSecondClicked() )
                        do{
                             do{
                                    x1 = Gui.getPointArr()[0];
                                    y1 = Gui.getPointArr()[1];
                                    x2 = Gui.getPointArr()[2];
                                    y2 = Gui.getPointArr()[3];
                                    TimeUnit.MILLISECONDS.sleep(1);
                            }while(x1 == -1);
                            correctMove = board.makeMove(c, x1, y1, x2, y2);
                            yourTurn = false;
                        }while(!correctMove);
                        correctMove = false;
                        // repaint();
                        // Toolkit.getDefaultToolkit().sync();

                        try {
                            byte[] data = new byte[4];
                            data[0] = (byte)x1;
                            data[1] = (byte)y1;
                            data[2] = (byte)x2;
                            data[3] = (byte)y2;
                            dos.write(data);
                            dos.flush();
                        } catch (IOException e1) {
                            errors++;
                            e1.printStackTrace();
                        }

                        System.out.println("DATA WAS SENT");
                        // checkForWin();
                        // checkForTie();

                    }
                }
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
        circle = false;

        i=1;

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
