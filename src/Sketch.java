import processing.core.PApplet;

public class Sketch extends PApplet {
    public static PApplet processing;

    Snowflake snow;
    Penrose penny;
    Pentigree gree;

    public void settings(){
        size(640, 360);
    }

    public void setup(){
        processing = this;

        stroke(0);

        //snow = new Snowflake();
        //penny = new Penrose();
        gree = new Pentigree();

        //snow.simulate(7);
        //penny.simulate(4);
        gree.simulate(4);

    }

    public void draw() {
        background(255);
        //snow.render();
        //penny.render();
        gree.render();
    }

    public static void main(String[] args){
        PApplet.main("Sketch", args);
    }
}