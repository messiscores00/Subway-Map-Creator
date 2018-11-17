import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JColorChooser;
import java.awt.Color;
import javax.swing.JComponent;
import java.util.ArrayList;
import java.lang.Float;
import java.awt.Dialog;

public class Starter{
    public static void main(String[] args){
        //creating the JFrame
        JFrame frame = new JFrame("Main Frame");
        frame.setSize(1200, 800);
        frame.setVisible(true);    
        
        //creating the rectangles and the text in the top right corner
        Rectangle rCforLines = new Rectangle(850, 50, 300, 100, Color.LIGHT_GRAY);
        Rectangle rCforStation = new Rectangle(850, 200, 300, 100, Color.GRAY);
        Text tCforLines = new Text(938, 115, "Lines", 50);
        Text tCforStations = new Text(910, 265, "Stations", 50);
        //adds the rectangle and text and sets visible to true 
        frame.add(tCforLines);
        frame.setVisible(true); 
        frame.add(tCforStations);
        frame.setVisible(true); 
        frame.add(rCforLines);
        frame.setVisible(true); 
        frame.add(rCforStation);
        frame.setVisible(true); 
        //asks the user if they would like to put a grid and runs the grid method which can be found at the end of the code
        int grid = JOptionPane.showConfirmDialog(null, "Would you like to add grids to help you?");
        if(grid == 0){
            Starter.addGrid(frame, 20);
        }

        class myClickListener implements MouseListener{
            boolean released = true;
            boolean linePressed = false;
            boolean stationPressed = true;
            boolean realeasedJustChanged = false;
            boolean stationHere = false;
            int xPos;
            int yPos;
            int addStation;
            Color color = Color.WHITE;
            ArrayList<int[]> points = new <int[]>ArrayList();
            public void mouseClicked(MouseEvent e) {
                realeasedJustChanged = false;
                if(linePressed == true && released == true){
                    xPos = e.getX()-10;
                    yPos = e.getY()-40;
                    released = false;
                    realeasedJustChanged = true;
                }
                if(linePressed == true && released == false && realeasedJustChanged == false){
                    Line lC = new Line(xPos, yPos, e.getX()-10, e.getY()-40, Color.BLACK, 3);
                    color = JColorChooser.showDialog(lC, "Choose Your Color:", Color.BLACK);
                    lC.setColor(color);
                    frame.add(lC);
                    frame.setVisible(true); 
                    xPos = e.getX()-14;
                    yPos = e.getY()-43;
                    released = true;
                }

                 if(e.getX()-10 > 845 && e.getX()-10 <1155 && e.getY()-40 >45 && e.getY()-40 < 155){
                    rCforLines.setColor(Color.GRAY);
                    rCforStation.setColor(Color.LIGHT_GRAY);
                    linePressed = true;
                    stationPressed = false;
                    released = true;
                }
                
                if(stationPressed == true){
                    xPos = e.getX()-10;
                    yPos = e.getY()-40;
                    stationHere = false;
                    for(int i = 0; i < points.size(); i++){
                        if(points.get(i)[0] +10 > xPos && points.get(i)[0] - 10 < xPos && points.get(i)[1]+ 10 > yPos && points.get(i)[1] -10 < yPos ){
                            JOptionPane.showMessageDialog(null, "You already have a station here.");
                            stationHere = true;
                        }
                    }
                    if(stationHere == false){
                         Circle cC = new Circle(xPos-4, yPos-4, 15, Color.WHITE);
                         color = JColorChooser.showDialog(cC, "Choose Your Color:", Color.BLACK);
                         cC.setColor(color);
                         frame.add(cC);
                         frame.setVisible(true);
                         String input = JOptionPane.showInputDialog(null, "Please enter the name of your station that you would like:");
                         Text tC = new Text(xPos-11, yPos+36, input, 15);
                         frame.add(tC);
                         frame.setVisible(true);
                         int[] pointForStation = {xPos, yPos};
                         points.add(pointForStation);
                    }
                }
                if(e.getX()-10 > 845 && e.getX()-10 <1155 && e.getY()-40 >195 && e.getY()-40 < 305){
                    rCforLines.setColor(Color.LIGHT_GRAY);
                    rCforStation.setColor(Color.GRAY);
                    linePressed = false;
                    stationPressed = true;
                }
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
        }
        
        frame.addMouseListener(new myClickListener());
    }
    
    public static void addGrid(JFrame frame, int everyXpixles){
        Color color = new Color(0.5f,0.5f,0.5f, .1f);
        int xStart = 0;
        int yStart = 0;
        int howManyGrids;
        if(frame.getHeight() > frame.getWidth()){
            howManyGrids = frame.getHeight() / everyXpixles;
        }else{
            howManyGrids = frame.getWidth() / everyXpixles;
        }
         
        for(int i =0; i< howManyGrids; i++){
            yStart = 0;
            xStart = xStart + everyXpixles;
            Line line = new Line(xStart, yStart, xStart,frame.getHeight(), color, 1);
            frame.add(line);
            frame.setVisible(true);
        }
        for(int i = 0; i< howManyGrids; i++){
            xStart = 0;
            yStart = yStart + everyXpixles;
            Line line = new Line(xStart, yStart, frame.getWidth(),yStart, color, 1);
            frame.add(line);
            frame.setVisible(true);
        }
        
    }
}
