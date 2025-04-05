import processing.core.PApplet;
import processing.core.PGraphics;
import com.krab.lazy.*;

import java.util.ArrayList;
import java.util.List;

public class Sketch extends PApplet {
    public static PApplet processing;

    LazyGui gui;
    PGraphics pg;

    Turtle turtleKC;
    LSystem kochCurve;
    Turtle turtleKS;
    LSystem kochSnowflake;
    Turtle turtleST;
    LSystem serpTriangle;
    Turtle turtleSL;
    LSystem stochasticImpl;

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }

    public void settings(){
        size(800, 800, P2D);
    }

    public void setup(){
        //processing = this;
        gui = new LazyGui(this);
        pg = createGraphics(width, height, P2D);
        colorMode(HSB, 1, 1, 1, 1);

//        this.turtleKC = new Turtle(6, radians(90));
//        Rule ruleKC = new Rule('F', "F+F-F-F+F");
//        List<Rule> rulesKC = new ArrayList<Rule>();
//        rulesKC.add(ruleKC);
//        kochCurve = new LSystem("F", rulesKC);
//
//        this.turtleKS = new Turtle(5, radians(60));
//        Rule ruleKS = new Rule('F', "F-F++F-F");
//        List<Rule> rulesKS = new ArrayList<Rule>();
//        rulesKS.add(ruleKS);
//        kochSnowflake = new LSystem("F++F++F", rulesKS);
//
//        this.turtleST = new Turtle(6, radians(60));
//        List<Rule> rulesLC = new ArrayList<>();
//        Rule ruleLC = new Rule('F', "G-F-G");
//        rulesLC.add(ruleLC);
//        ruleLC = new Rule('G', "F+G+F");
//        rulesLC.add(ruleLC);
//        serpTriangle = new LSystem("F+G+F-G-F-G-F+G+F", rulesLC);
//
//        this.turtleSL = new Turtle(6, radians(25));
//        List<Rule> rulesSL = new ArrayList<>();
//        Rule ruleSL = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");
//        rulesSL.add(ruleSL);
//        stochasticImpl = new LSystem("F", rulesSL);
    }

    public void draw() {

        pg.beginDraw();

        drawForegroundShape();

        pg.endDraw();
        image(pg, 0, 0);
        gui.draw();
    }

//    public void mousePressed(){
//        redraw();
//    }

    public void drawForegroundShape(){

        if(gui.toggle("gradient", true)){
            pg.image(gui.gradient("background"), 0, 0);
            return;
        }
        pg.fill(gui.colorPicker("solid").hex);
        pg.noStroke();
        pg.rectMode(CORNER);
        pg.rect(0, 0, width, height);

//        translate(0,5);
//        for(int i = 0; i < 4; i++) {
//            turtleKC.render(kochCurve());
//            translate(5, 0);
//        }

//        translate(-500, 300);
//
//        for(int i = 0; i < 3; i++) {
//            turtleKS.render(kochSnowflake());
//            translate(80, 0);
//        }
//        translate(-20, 90);
//        turtleKS.render(kochSnowflake());
//
//        translate(-50,650);
//        for(int i = 0; i < 4; i++) {
//            translate(0, -70);
//            turtleST.render(serpTriangle());
//        }
//
//        rotate(-90);
//        translate(150, -200);
//        for(int i = 0; i < 3; i++){
//            turtleSL.render(stochasticImpl());
//            translate(-60, 90);
//        }
//        translate(-70, 70);
//        turtleSL.render(stochasticImpl());

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

    public String stochasticImpl(){
        stochasticImpl.generate();
        return stochasticImpl.getSentence();
    }
}