import javax.swing.JFrame;
import java.awt.event.*;

public class Starter{
    public static void main(String[] args){
        JFrame f = new JFrame("Main Frame");
        f.setSize(500, 500);
        Line line = new Line(10,10,100,20);
        f.add(line);
        f.setVisible(true);

        class myKeyListener implements KeyListener
        {
            public void keyPressed(KeyEvent e)
            {
                //when a key is pressed I want the rectangle to move
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    Line line2 = new Line(10, 10, 100, 2);
                    f.add(line2);
                    f.setVisible(true);
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) line.moveX(3);
                if(e.getKeyCode()==KeyEvent.VK_UP) line.moveY(-3);
                if(e.getKeyCode()==KeyEvent.VK_DOWN) line.moveY(3);
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}   
        }

        f.addKeyListener(new myKeyListener());//add keylistener to frame

    }
}
