import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Font;
public class Text extends JComponent
{
    int x,y;
    String text;
    Font font;
    public Text(int x, int y, String t, int size)
    {
        this.x = x;
        this.y = y;
        text = t;
        font = new Font("Font", Font.PLAIN, size);
    }

    public void paintComponent(Graphics g)
    {
        g.setFont(font);
        g.drawString(text, x, y);
    }
}