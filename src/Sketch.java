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
    Turtle turtleTree;
    LSystem lTree;
    Turtle turtleStoch;
    LSystem basicStoch;

    public void settings(){
        size(1500, 800);
    }

    public void setup(){
        processing = this;

        this.turtleKC = new Turtle(6, radians(90));
        Rule ruleKC = new Rule('F', "F+F-F-F+F");
        List<Rule> rulesKC = new ArrayList<Rule>();
        rulesKC.add(ruleKC);
        kochCurve = new LSystem("F", rulesKC, false);

        this.turtleKS = new Turtle(5, radians(60));
        Rule ruleKS = new Rule('F', "F-F++F-F");
        List<Rule> rulesKS = new ArrayList<Rule>();
        rulesKS.add(ruleKS);
        kochSnowflake = new LSystem("F++F++F", rulesKS, false);

        this.turtleST = new Turtle(6, radians(60));
        List<Rule> rulesLC = new ArrayList<>();
        Rule ruleLC = new Rule('F', "G-F-G");
        rulesLC.add(ruleLC);
        ruleLC = new Rule('G', "F+G+F");
        rulesLC.add(ruleLC);
        serpTriangle = new LSystem("F+G+F-G-F-G-F+G+F", rulesLC, false);

        this.turtleTree = new Turtle(6, radians(25));
        List<Rule> rulesTree = new ArrayList<>();
        Rule ruleT = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");
        rulesTree.add(ruleT);
        lTree = new LSystem("F", rulesTree, false);

        this.turtleStoch = new Turtle(8, radians(30));
        List<Rule> rulesBS = new ArrayList<>();
        Rule ruleBS1 = new Rule('F', "F[+F]F[-F]F", 0.33);
        Rule ruleBS2 = new Rule('F', "F[+F]F", 0.33);
        Rule ruleBS3 = new Rule('F', "F[-F]F", 0.34);
        rulesBS.add(ruleBS1);
        rulesBS.add(ruleBS2);
        rulesBS.add(ruleBS3);
        basicStoch = new LSystem("F", rulesBS, true);
    }

    public void draw() {
        background(255);
        translate(200, 600);
        rotate(-90);

        for (int i = 0; i < 4; i++){
            basicStoch.generate();
            turtleStoch.render(basicStoch.getSentence());
            rotate(radians(turtleStoch.getTheta() * 3));
            translate(-(i * 100), (i * 80));
        }
//        for(int i = 0; i < 4; i++) {
//            turtleKC.render(kochCurve());
//            translate(5, 0);
//        }
//
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
//            turtleTree.render(stochasticImpl());
//            translate(-60, 90);
//        }
//        translate(-70, 70);
//        turtleTree.render(stochasticImpl());

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

    public String stochasticImpl(){
        lTree.generate();
        return lTree.getSentence();
    }
}