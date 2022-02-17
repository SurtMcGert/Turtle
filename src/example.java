import turtle.Turtle;

public class example {
    public static void main(String[] args) {
        System.out.println("--------------------TURTLE EXAMPLE--------------------");

        // make a new turtle with a screen of 500 by 500 and start the turtle in the
        // center of the screen
        Turtle t = new Turtle(500, 500, 250, 250);

        // draw a square
        t.draw(100); // draws a line
        System.out.println("turning left");
        t.left(90); // rotates turtle to the left by 90
        t.draw(100); // draws a line
        System.out.println("turning left");
        t.left(90);// rotates turtle to the left by 90 degrees
        t.draw(100);// draws a line
        System.out.println("turning left");
        t.left(90);// rotates turtle to the left by 90 degrees
        t.draw(100);// draws a line

    }
}
