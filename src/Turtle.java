/**
 * Turtle object class that determines graphical output
 *
 * @author Eman Naveed
 */
public class Turtle {
    float length;
    float theta;

    /**
     * Constructor for class Turtle
     *
     * @param l Length of one drawn unit
     * @param t Angle of rotation
     */
    Turtle(float l, float t){
        length = l;
        theta = t;
    }

    /**
     * Getter for degree of rotation.
     *
     * @return theta This is to calibrate the position of the graphics on the window
     */
    public float getTheta(){
        return theta;
    }

    /**
     * Creates graphical output using basic turtle commands
     * <p>
     *     Note: All references to Sketch.processing are required as processing cannot be accessed in this class except
     *     through the PApplet.
     * </p>
     *
     * @param sentence This determines the graphical output according to the l-system
     */
    void render(String sentence){
        // stroke( colour, opacity)
        Sketch.processing.stroke(0, 175);

        // traverses through sentence and determines graphical actions corresponding to specific characters
        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            switch (c){
                case 'F', 'G':
                    Sketch.processing.strokeWeight(2);
                    Sketch.processing.line(0, 0, 0, length);
                    Sketch.processing.translate(0, length);
                    break;
                case '+':
                    // rotate right
                    Sketch.processing.rotate(theta);
                    break;
                case '-':
                    // rotate left
                    Sketch.processing.rotate(-theta);
                    break;
                case '[':
                    // saves branching off position
                    Sketch.processing.pushMatrix();
                    break;
                case ']':
                    // returns to branching off position to continue drawing from there
                    Sketch.processing.popMatrix();
            }


        }
    }
}
