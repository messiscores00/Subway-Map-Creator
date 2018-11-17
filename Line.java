import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.Line2D;
import java.awt.BasicStroke;
import java.awt.Image;
import java.awt.Toolkit;
public class Line extends JComponent{
    Line2D line;
    Color color;
    Graphics2D g2;
    int xStart, yStart, xEnd, yEnd;
    float stroke;
    
    public Line(int xStart, int yStart,int xEnd, int yEnd, Color color, float stroke){
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
        this.color = color;
        this.stroke = stroke;
    }

    public void setColor(Color color){
        this.color = color;
    }
    
    public void paintComponent(Graphics g)
    //overriding paintComponent method with my own drawing instructions
    {
        line = new Line2D.Double(xStart,yStart,xEnd,yEnd);
        g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(stroke));
        g2.draw(line);
        
    }
    
    public void reDraw(int xStartPos, int yStartPos, int xEndPos, int yEndPos){
        line.setLine(xStartPos, yStartPos,xEndPos, yEndPos);
        repaint();
    }
}
