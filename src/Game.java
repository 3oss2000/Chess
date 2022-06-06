import javax.swing.JFrame;

public final class Game {

    public void startGame() throws InterruptedException{

        Gui gu = new Gui();
        gu.initializeGui();
        JFrame f = new JFrame("Chess");
        f.add(gu.getGui());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // makes the app off when gui is closed
        f.pack(); // size
        f.setMinimumSize(f.getSize()); // limit the packed size
        f.setVisible(true);


        Peer n = new Peer("localhost", 8080);
        n.startCommunication();

    }
}
