import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.concurrent.TimeUnit;

public class Sketch extends PApplet {
    public static PApplet processing;

    Turtle turtleKC;
    Turtle turtleKT;

    public void settings(){
        size(1000, 800);
    }

    public void setup(){
        processing = this;
        this.turtleKC = new Turtle(4, radians(90));
        this.turtleKT = new Turtle(4, radians(60));
    }

    public void draw() {
        background(255);
        turtleKC.render(kochCurve());
        //translate(-50, 0);
        turtleKT.render(kochTriangle());
        noLoop();
    }

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }

    public String kochCurve(){
        Rule rule = new Rule('F', "F+F-F-F+F");
        List<Rule> rules = new ArrayList<Rule>();
        rules.add(rule);
        LSystem kochCurve = new LSystem("F", rules);
        for(int i = 0; i < 4; i++){
            kochCurve.generate();
        }
        return kochCurve.getSentence();
    }

    public String kochTriangle(){
        Rule rule = new Rule('F', "F+F--F+F");
        List<Rule> rules = new ArrayList<Rule>();
        rules.add(rule);
        LSystem kochTriangle = new LSystem("F", rules);
        for(int i = 0; i < 4; i++){
            kochTriangle.generate();
        }
        return kochTriangle.getSentence();
    }
}