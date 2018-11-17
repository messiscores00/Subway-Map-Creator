import javax.swing.JComponent;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
public class Rectangle extends JComponent
{
    Rectangle2D r;
    int x,y,width,height;
    Color color;
    public Rectangle(int xPos, int yPos,int w, int h, Color c)
    {
        x = xPos;
        y = yPos;
        width = w;
        height = h;
        color = c;
    }

    public void paintComponent(Graphics g)
    //overriding paintComponent method with my own drawing instructions
    {
        r = new Rectangle2D.Double(x,y,width,height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fill(r);
    }
    
    public void setColor(Color color){
        this.color = color;
        repaint();
    }
}
