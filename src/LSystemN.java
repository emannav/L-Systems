import static processing.core.PApplet.radians;

public class LSystemN {
    int steps = 0;

    String axiom;
    String rule;
    String production;

    float startLength;
    float drawLength;
    float theta;

    int generations;

    LSystemN(){
        axiom = "F";
        rule = "F+F-F";
        startLength = 190;
        theta = radians(120);
        reset();
    }

    public void reset(){
        production = axiom;
        drawLength = startLength;
        generations = 0;
    }

    public int getAge(){
        return generations;
    }

    public void render(){
        Sketch.processing.translate((float) Sketch.processing.width /2, (float) Sketch.processing.height /2);
        steps += 5;
        if (steps > production.length()){
            steps = production.length();
        }
        for (int i = 0; i < steps; i++){
            char step = production.charAt(i);
            if (step == 'F'){
                Sketch.processing.rect(0, 0, -drawLength, -drawLength);
                Sketch.processing.noFill();
                Sketch.processing.translate(0, -drawLength);
            }
            else if (step == '+'){
                Sketch.processing.rotate(theta);
            }
            else if (step == '-'){
                Sketch.processing.rotate(-theta);
            }
            else if (step == '['){
                Sketch.processing.pushMatrix();
            }
            else if (step == ']'){
                Sketch.processing.popMatrix();
            }
        }
    }
    public void simulate(int gen) {
        while (getAge() < gen){
            production = iterate(production, rule);
        }
    }
    public String iterate(String prod_, String rule_){
        drawLength *= (float) (0.6);
        generations++;
        String newProduction = prod_;
        newProduction = newProduction.replaceAll("F", rule_);
        return newProduction;
    }
}
