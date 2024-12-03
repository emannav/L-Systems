import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Sketch extends PApplet {
    public static PApplet processing;

    Turtle turtleKC;
    LSystem kochCurve;
    Turtle turtleKS;
    LSystem kochSnowflake;
    Turtle turtleST;
    LSystem serpTriangle;

    public void settings(){
        size(1500, 800);
    }

    public void setup(){
        processing = this;

        this.turtleKC = new Turtle(6, radians(90));
        Rule ruleKC = new Rule('F', "F+F-F-F+F");
        List<Rule> rulesKC = new ArrayList<Rule>();
        rulesKC.add(ruleKC);
        kochCurve = new LSystem("F", rulesKC);

        this.turtleKS = new Turtle(5, radians(60));
        Rule ruleKS = new Rule('F', "F-F++F-F");
        List<Rule> rulesKS = new ArrayList<Rule>();
        rulesKS.add(ruleKS);
        kochSnowflake = new LSystem("F++F++F", rulesKS);

        this.turtleST = new Turtle(6, radians(60));
        List<Rule> rulesLC = new ArrayList<>();
        Rule ruleLC = new Rule('F', "G-F-G");
        rulesLC.add(ruleLC);
        ruleLC = new Rule('G', "F+G+F");
        rulesLC.add(ruleLC);
        serpTriangle = new LSystem("F+G+F-G-F-G-F+G+F", rulesLC);
    }

    public void draw() {
        background(255);
        translate(0,5);
        for(int i = 0; i < 4; i++) {
            turtleKC.render(kochCurve());
            translate(5, 0);
        }

        translate(-450, 300);

        for(int i = 0; i < 3; i++) {
            turtleKS.render(kochSnowflake());
            translate(80, 0);
        }
        translate(-20, 90);
        turtleKS.render(kochSnowflake());

        translate(-100,800);
        for(int i = 0; i < 4; i++) {
            translate(0, -70);
            turtleST.render(serpTriangle());
        }
        noLoop();
    }

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }

    public String kochCurve(){
        kochCurve.generate();
        return kochCurve.getSentence();
    }

    public String kochSnowflake(){
        kochSnowflake.generate();
        return kochSnowflake.getSentence();
    }

    public String serpTriangle(){
        serpTriangle.generate();
        return serpTriangle.getSentence();
    }
}