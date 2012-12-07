import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class LifeCanvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LifeCanvas extends JPanel
    implements MouseListener, MouseMotionListener
    
{
    private GameOfLife app;
    private TextArea textArea;
    private LifeGrid grid;
    private int cellUnderMouse;
    private int cellSize;
    
   
    
    /**
     * Constructor for objects of class LifeCanvas
     */
    public LifeCanvas(GameOfLife applet)
    {
       app = applet;
            
       grid = new LifeGrid(50,50);
       cellSize = 10;
       // Create essential data structure storage.
       setLayout(new BorderLayout());
       textArea = new TextArea("Mouse Move",1,20,TextArea.SCROLLBARS_NONE);
       add(textArea, BorderLayout.SOUTH);
    
       addMouseListener(this);
       addMouseMotionListener(this);
       
    }
    

/* MouseListener Methods */
  public void mouseClicked(MouseEvent e)
  {
      // left or right clicks?
      if (e.getModifiers() == MouseEvent.BUTTON1_MASK)
      {
          
          //textArea.replaceRange("saving cell",0,20);
          //saveCellUnderMouse(e.getX(), e.getY());      
          //textArea.replaceRange("I'm in spot Left Click" ,0,20); 
      }
      else if (e.getModifiers() == MouseEvent.BUTTON3_MASK)
      {
          //textArea.replaceRange("saving cell",0,20);
          //saveCellUnderMouse(e.getX(), e.getY());
          //textArea.replaceRange("I'm in spot Rt Click" ,0,20);
          
      }
      repaint();
   }
   
   public void mouseEntered(MouseEvent e)
   {
       textArea.replaceRange("I'm in!!",0,20);   
   }
   
   public void mouseExited(MouseEvent e) 
   {
       textArea.replaceRange("I'm out!!",0,20);
   }
   public void mousePressed(MouseEvent e) 
   {
        //textArea.replaceRange("saving cell MousePressed",0,40);
        saveCellUnderMouse(e.getX(), e.getY());
   }
   public void mouseReleased(MouseEvent e) 
   {
       //textArea.replaceRange("drawing cell",0,20);
       draw(e.getX(), e.getY());
   }
      
  
  
  // Methods for MouseMotionListener
  public void mouseMoved(MouseEvent e) 
  {
       //textArea.replaceRange("x="+e.getX() + " y="+e.getY(),0,20);
  }
  public void mouseDragged(MouseEvent e) 
  {
      //textArea.replaceRange("dragging and drawing",0,20);
       draw(e.getX(), e.getY());
  }


    /**
     * Remember state of cell for drawing.
     * 
     * @param x x-coordinate of mouse
     * @param y y-coordinate of mouse
     */
    public void saveCellUnderMouse(int x, int y) {
        try {
            cellUnderMouse = grid.getCell(x / cellSize, y / cellSize);
            textArea.replaceRange("saving cell:" + cellUnderMouse,0,40);
        
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // ignore
            
        }
        finally
        {
            //textArea.replaceRange("saving cell FAILED",0,40);
        }
    }
    
    /**
     * Draw in this cell.
     * 
     * @param x x-coordinate
     * @param y y-coordinate
     */
    public void draw(int x, int y) {
        try {
            grid.setCell(x / cellSize, y / cellSize, 1-cellUnderMouse );
            //textArea.replaceRange("Set Cell to:" + (1-cellUnderMouse),0,20);
            repaint();
        } 
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            // ignore          
        }
        finally {
           // textArea.replaceRange("OUT OF BOUNDS",0,20);
        }
    }
    
  public void next()
  {
      grid.evolve();
      repaint();
  }

  public void paintComponent(Graphics g)
  { // repaint background
    super.paintComponent(g);
     
    // draw grid
        int width = grid.getNumCols();
        int height = grid.getNumRows();
        g.setColor(Color.red);
        for (int x = 1; x < width; x++) {
            g.drawLine(x * cellSize - 1, 0, x * cellSize - 1, cellSize * height - 1);
        }
        for (int y = 1; y < height; y++) {
            g.drawLine( 0, y * cellSize - 1, cellSize * width - 1, y * cellSize - 1);
        }
    // draw populated cells
        g.setColor(Color.red);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (grid.getCell(x, y)>0) {
                    g.fillRect(x * cellSize, y * cellSize, cellSize - 1, cellSize - 1);
                }
            }
        }
  }
}
