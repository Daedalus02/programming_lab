import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Color;

public class GameFrame extends JFrame {
    GamePanel gp;

    GameFrame(String name){
        gp=new GamePanel(name);
        this.add(gp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.pack();
        this.setLayout(null);
        //this.setFocusable(false);
    }
    
}
