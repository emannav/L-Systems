import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Sketch extends PApplet {
    public static PApplet processing;

    Turtle turtleKS;
    LSystem kochSnowflake;
    Turtle turtleST;
    LSystem serpTriangle;
    Turtle turtleT;
    LSystem lTree;
    Turtle turtleTT;
    LSystem treeTwo;
    Turtle turtleStoch;
    LSystem basicStoch;
    Turtle turtleComp;
    LSystem basicComp;

    public void settings(){
        size(1500, 800);
    }

    public void setup(){
        processing = this;

        this.turtleKS = new Turtle(6, radians(60));
        Rule ruleKS = new Rule('F', "F-F++F-F");
        List<Rule> rulesKS = new ArrayList<Rule>();
        rulesKS.add(ruleKS);
        kochSnowflake = new LSystem("F++F++F", rulesKS, false);

        this.turtleST = new Turtle(6, radians(60));
        List<Rule> rulesST = new ArrayList<>();
        Rule ruleST = new Rule('F', "G-F-G");
        rulesST.add(ruleST);
        ruleST = new Rule('G', "F+G+F");
        rulesST.add(ruleST);
        serpTriangle = new LSystem("F+G+F-G-F-G-F+G+F", rulesST, false);

        this.turtleT = new Turtle(8, radians(25));
        List<Rule> rulesTree = new ArrayList<>();
        Rule ruleT = new Rule('F', "FF+[+F-F-F]-[-F+F+F]");
        rulesTree.add(ruleT);
        lTree = new LSystem("F", rulesTree, false);

        this.turtleTT = new Turtle(10, radians(22.5F));
        List<Rule> rulesTT = new ArrayList<>();
        Rule ruleTT1 = new Rule('F', "FF");
        Rule ruleTT2 = new Rule('X', "F-[[X]+X]+F[+FX]-X");
        rulesTT.add(ruleTT1);
        rulesTT.add(ruleTT2);
        treeTwo = new LSystem("X", rulesTT, false);

        this.turtleStoch = new Turtle(8, radians(30));
        List<Rule> rulesBS = new ArrayList<>();
        Rule ruleBS1 = new Rule('F', "F[+F]F[-F]F", 0.33);
        Rule ruleBS2 = new Rule('F', "F[+F]F", 0.33);
        Rule ruleBS3 = new Rule('F', "F[-F]F", 0.34);
        rulesBS.add(ruleBS1);
        rulesBS.add(ruleBS2);
        rulesBS.add(ruleBS3);
        basicStoch = new LSystem("F", rulesBS, true);

        this.turtleComp = new Turtle(8, radians(30));
        basicComp = new LSystem("F", rulesBS, true);
    }

    public void draw() {
        background(255);
        translate(440, 775);
        rotate(radians(180));

        for (int i = 0; i < 4; i++){
            pushMatrix();
            treeTwo.generate();
            turtleTT.render(treeTwo.getSentence());
            popMatrix();
            translate(100, 0);
        }

        translate(0, 725);

        for(int i = 0; i < 4; i++) {
            pushMatrix();
            kochSnowflake.generate();
            turtleKS.render(kochSnowflake.getSentence());
            popMatrix();
            translate(-(i * 110), -(i * 145));
            if(i == 0){
                translate(-50, -60);
            }
        }

        translate(140, 210);

        for(int i = 0; i < 3; i++){
            pushMatrix();
            lTree.generate();
            turtleT.render(lTree.getSentence());
            popMatrix();
            translate(-90, 0);
        }

        translate(-90, 0);

        for (int i = 0; i < 4; i++){
            pushMatrix();
            basicStoch.generate();
            turtleStoch.render(basicStoch.getSentence());
            popMatrix();
            translate(-90, 0);
        }

        translate(360, 400);

        for (int i = 0; i < 4; i++){
            pushMatrix();
            basicComp.generate();
            turtleComp.render(basicComp.getSentence());
            popMatrix();
            translate(-90, 0);
        }

        noLoop();
    }

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }

}