import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Main executable class uses PApplet library from Processing 4.3, triggers all graphical output.
 *
 * @author Eman Naveed
 */
public class Sketch extends PApplet {
    public static PApplet processing;

    Turtle turtleKS;
    LSystem kochSnowflake;
    Turtle turtleT;
    LSystem lTree;
    Turtle turtleTT;
    LSystem treeTwo;
    Turtle turtleStoch;
    LSystem basicStoch;
    Turtle turtleComp;
    LSystem basicComp;

    /**
     * PApplet inherited method; initializes output window.
     */
    public void settings(){
        size(1450, 800);
    }

    /**
     * PApplet inherited method; initializes all variables to be used.
     */
    public void setup(){
        // PApplet needs to be initialized this way so the library can be accessed in other files.
        processing = this;

        // Koch snowflake Turtle and LSystem initialization
        this.turtleKS = new Turtle(4, radians(60));
        Rule ruleKS = new Rule('F', "F-F++F-F");
        List<Rule> rulesKS = new ArrayList<Rule>();
        rulesKS.add(ruleKS);
        kochSnowflake = new LSystem("F++F++F", rulesKS, false);

        // Non-stochastic tree Turtle and LSystem initialization
        this.turtleT = new Turtle(8, radians(25));
        List<Rule> rulesTree = new ArrayList<>();
        Rule ruleT = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");
        rulesTree.add(ruleT);
        lTree = new LSystem("F", rulesTree, false);

        // Second non-stochastic tree Turtle and LSystem initialization
        this.turtleTT = new Turtle(10, radians(22.5F));
        List<Rule> rulesTT = new ArrayList<>();
        Rule ruleTT1 = new Rule('F', "FF");
        Rule ruleTT2 = new Rule('X', "F-[[X]+X]+F[+FX]-X");
        rulesTT.add(ruleTT1);
        rulesTT.add(ruleTT2);
        treeTwo = new LSystem("X", rulesTT, false);

        // Stochastic tree Turtle and LSystem initialization
        this.turtleStoch = new Turtle(8, radians(30));
        List<Rule> rulesBS = new ArrayList<>();
        Rule ruleBS1 = new Rule('F', "F[+F]F[-F]F", 0.33);
        Rule ruleBS2 = new Rule('F', "F[+F]F", 0.33);
        Rule ruleBS3 = new Rule('F', "F[-F]F", 0.34);
        rulesBS.add(ruleBS1);
        rulesBS.add(ruleBS2);
        rulesBS.add(ruleBS3);
        basicStoch = new LSystem("F", rulesBS, true);

        // Second stochastic tree Turtle and LSystem initialization
        // Uses same rules and initial string as previous to show differences in productions
        this.turtleComp = new Turtle(12, radians(22.5F));
        List<Rule> rulesC = new ArrayList<>();
        Rule ruleC1 = new Rule('F', "F[+F][-F]F", 0.5);
        Rule ruleC2 = new Rule('F', "F[-F]F", 0.3);
        Rule ruleC3 = new Rule('F', "F[+F]F", 0.2);
        rulesC.add(ruleC1);
        rulesC.add(ruleC2);
        rulesC.add(ruleC3);
        basicComp = new LSystem("F", rulesC, true);
    }

    /**
     * PApplet inherited method; dictates what goes on in the produced window.
     */
    public void draw() {
        // White background
        background(255);

        // Set starting position so drawing begins within the window with correct orientation
        // All rotation angles MUST be in radians
        translate(440, 775);
        rotate(radians(180));

        // Second non-stochastic tree
        for (int i = 0; i < 4; i++){
            // pushMatrix() & popMatrix() save where the Turtle begins
            // allows for easier adjustment via translation after the construction is done
            pushMatrix();
            treeTwo.generate();
            turtleTT.render(treeTwo.getSentence());
            popMatrix();
            translate(100, 0);
        }
        treeTwo.reset();

        // Adjust position before next construction to prevent any overlap
        translate(0, 725);

        // Koch snowflake
        for(int i = 0; i < 4; i++) {
            pushMatrix();
            kochSnowflake.generate();
            turtleKS.render(kochSnowflake.getSentence());
            popMatrix();
            translate(-(i * 90), -(i * 120));
            if(i == 0){
                translate(-50, -60);
            }
        }
        kochSnowflake.reset();

        translate(50, 55);

        // Non-stochastic tree
        for(int i = 0; i < 3; i++){
            pushMatrix();
            lTree.generate();
            turtleT.render(lTree.getSentence());
            popMatrix();
            translate(-90, 0);
        }
        lTree.reset();

        translate(-120, 0);

        // Stochastic tree
        // First generate allows the system to start from a more progressed state
        basicStoch.generate();
        for (int i = 0; i < 4; i++){
            pushMatrix();
            basicStoch.generate();
            turtleStoch.render(basicStoch.getSentence());
            popMatrix();
            translate(-100, 0);
        }
        basicStoch.reset();

        translate(300, 350);

        // Comparison stochastic tree
        basicComp.generate();
        for (int i = 0; i < 4; i++){
            pushMatrix();
            basicComp.generate();
            turtleComp.render(basicComp.getSentence());
            popMatrix();
            translate(100, 0);
        }
        basicComp.reset();

        mousePressed();

        noLoop();
    }

    public void mousePressed(){
        redraw();
    }

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }

}