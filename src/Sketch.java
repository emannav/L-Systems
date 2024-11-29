import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Sketch extends PApplet {
    public static PApplet processing;

    LSystem lsystem;
    Turtle turtle;
    public void settings(){
        size(640, 240);
    }

    public void setup(){
        processing = this;
        Rule rule = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");
        List<Rule> rules = new ArrayList<Rule>();
        rules.add(rule);

        lsystem = new LSystem("F", rules);
        turtle = new Turtle(4, radians(25));

        for(int i = 0; i < 4; i++){
            lsystem.generate();
        }
    }

    public void draw(){
        background(255);
        translate((float) width / 2, height);
        turtle.render(lsystem.sentence);
        noLoop();
    }

    public static void main(String[] args){

        PApplet.main("Sketch", args);
    }

}