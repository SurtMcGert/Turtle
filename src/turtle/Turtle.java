package turtle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.awt.Color;

public class Turtle extends JPanel {

    private JFrame frame = new JFrame();
    private int width = 0;// the width of the frame
    private int height = 0;// the height of the frame
    private int angle = 360; // the angle that the turtle is faicing defaults facing upwards
    private int x = 0;// the x position of the turtle
    private int y = 0;// the y position of the turtle

    private ArrayList<Integer[]> lineBuffer = null;//buffers the lines to be drawn by the paint method

    /**
     * make a new turtle with a screen of the given width and height and starts the
     * turtle at the given x and y points
     * the turtle will defult facing upwards
     * 
     * @param width  - width of the screen
     * @param height - height of the screen
     * @param x      - the starting x position of the Turtle
     * @param y      - the starting y position of teh Tutle
     */
    public Turtle(int width, int height, int x, int y) throws IllegalArgumentException {

        //save the width and height of the window
        this.width = width;
        this.height = height;

        if ((x > 0) && (x < width) && (y > 0) && (y < height)) {
            this.x = x;
            this.y = y;
        } else {
            throw new IllegalArgumentException("x and y starting points must be within the bounds of the screen size");
        }

        //set up the line buffer
        this.lineBuffer = new ArrayList<Integer[]>();

        // make a new frame and add it to the jpanel
        this.frame = new JFrame();
        this.frame.add(this);

        frame.setSize(width, height);

        // setting start position of the frame
        this.frame.setLocationRelativeTo(null);

        // closing
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        this.frame.setTitle("turtle");

        this.frame.setBackground(Color.white);

        // set frame visibility
        this.frame.setVisible(true);

        repaint();

    }

    // paint meathod
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.setColor(Color.black);
        for(int i = 0; i < this.lineBuffer.size(); i++) {
            g.drawLine(this.lineBuffer.get(i)[0], this.lineBuffer.get(i)[1], this.lineBuffer.get(i)[2], this.lineBuffer.get(i)[3]);
        }
        this.lineBuffer.clear();
    }

    /**
     * function to draw a line of given length in the direction the turtle is currently facing
     * @param length - the length of the line to draw
     */
    public void draw(int length) {
        double plusX = Math.sin(Math.toRadians(this.angle)) * length;
        double plusY = Math.cos(Math.toRadians(this.angle)) * length;

        int x2 = this.x - (int) plusX;
        int y2 = this.y - (int) plusY;
        Integer[] line = new Integer[4];
        if ((turtleInFrame(this.x, this.y) == true) && ((turtleInFrame(x2, y2) == true))) {
            line[0] = this.x;
            line[1] = this.y;
            line[2] = x2;
            line[3] = y2;
            this.lineBuffer.add(line);
            

        }

        this.x = x2;
        this.y = y2;
        repaint();

    }

    /**
     * function to rotate the turtle to the right by the given number of degrees
     * @param nAngle - the degrees to rotate by
     */
    public void right(int nAngle) {
        this.angle = this.angle - nAngle;
    }

    /**
     * function to rotate the turtle to the left by the given number of degrees
     * @param nAngle - the degrees to rotate by
     */
    public void left(int nAngle) {
        this.angle = this.angle + nAngle;
    }

    /**
     * checks to see if the turtle at the given x and y position is in frame
     * 
     * @param x - the x to check
     * @param y - the y to check
     * @return boolean - wether the given points are in fram
     */
    private boolean turtleInFrame(int x, int y) {
        boolean inFrame = true;
        if ((x < 0) || (x > width) || (y < 0) || (y > height)) {
            inFrame = false;
        }
        return inFrame;
    }
}
