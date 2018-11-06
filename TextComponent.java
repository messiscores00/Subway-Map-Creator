import javax.swing.JComponent;
import java.awt.Graphics;

public class TextComponent extends JComponent{
    int x, y;
    String text;
    public TextComponent(String input, int x, int y){
        this.x=x;
        this.y = y;
        text = input;
    }
     public void paintComponent(Graphics g)
    //overriding paintComponent method with my own drawing instructions
    {
        g.drawString(text, x, y);
    }
}
