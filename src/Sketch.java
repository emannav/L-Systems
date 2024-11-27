import processing.core.PApplet;

public class Sketch extends PApplet {
    public static PApplet processing;

    String todo;
    float length;
    float theta;
    public void settings(){
        size(800, 800);
    }

    public void setup(){
        processing = this;
    }

    public void draw(){

    }

    public static void main(String[] args){

        PApplet.main("Turtle", args);
    }

}