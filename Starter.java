import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JOptionPane;
/*Purpose: Handles the main method to run the code
 * 1) make the JFrame
 * 3)create a Mouselistener class
 *  -when the mouse is pressed it adds a text component and a circle componet and starts a line component
 *  -stores the x and y location of the mouse key with a 3 by 2 array Name of station , X, Y
 *  -asks the user the name od the station
 *  -the line follows the the mouses input (so need to repaint often)
 *  -if the mouse if clicked in a certain x and y locations then it changes a certain color
 */
public class Starter{
    public static void main(String[] args){
        JFrame f = new JFrame("Main Frame");
        f.setSize(500, 500);
        LineComponent line = new LineComponent(10,10,100,20);
        f.add(line);
        f.setVisible(true);

        class myKeyListener implements KeyListener
        {
            public void keyPressed(KeyEvent e)
            {
                //when a key is pressed I want the rectangle to move
                if(e.getKeyCode()==KeyEvent.VK_LEFT) line.moveX(-3);
                if(e.getKeyCode()==KeyEvent.VK_RIGHT) line.moveX(3);
                if(e.getKeyCode()==KeyEvent.VK_UP) line.moveY(-3);
                if(e.getKeyCode()==KeyEvent.VK_DOWN) line.moveY(3);
            }
            public void keyReleased(KeyEvent e){}
            public void keyTyped(KeyEvent e){}   
        }

        class myClickListener implements MouseListener{
            public void mouseClicked(MouseEvent e){}
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){
                String input = JOptionPane.showInputDialog(null, "Please nenter");
                TextComponent tC = new TextComponent(input, e.getX(), e.getY());
                f.add(tC);
                f.setVisible(true);
            }
            public void mouseReleased(MouseEvent e){}
        }
        
        f.addKeyListener(new myKeyListener());//add keylistener to frame
        f.addMouseListener(new myClickListener());
    }
}
