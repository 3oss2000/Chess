import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {

        
        Gui gu = new Gui();
        gu.initializeGui();
        JFrame f = new JFrame("ChessChamp");
        f.add(gu.getGui());
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //makes the app off when gui is closed
        //f.setLocationByPlatform(true); //TODO check if needed
        f.pack(); //size
        f.setMinimumSize(f.getSize()); //limit the packed size
        f.setVisible(true);

        Network n = new Network();

        n.game();

    }
}
