import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title); //frame of window (dimensions) basically just creating a window

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize((new Dimension(width, height)));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //having x button in top corner it wont close if you don't have it
        frame.setResizable(false); //can we resize our window? False
        frame.setLocationRelativeTo(null); // window would be at top left instead of middle if null didnt exist
        frame.add(game);
        frame.setVisible(true); // can we see it
        game.start(); //function that stats game



    }

}
