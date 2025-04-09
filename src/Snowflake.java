import processing.core.PApplet;

public class Snowflake extends LSystemN{
    String ruleF;
    Snowflake(){
        axiom = "F3-F3-F3-F3-F";
        ruleF = "F3-F3-F45-F++F3-F";
        startLength = 450;
        theta = PApplet.radians(18);
        reset();
    }

    public void useRule(String r_){
        rule = r_;
    }

    public void useAxiom(String a_){
        axiom = a_;
    }

    public void useLength(float l_){
        startLength = l_;
    }

    public void useTheta(float t_){
        theta = PApplet.radians(t_);
    }

    public void render(){
        Sketch.processing.translate(Sketch.processing.width, Sketch.processing.height);
        int repeats = 1;

        steps += 3;
        if (steps > production.length()){
            steps = production.length();
        }

        for (int i = 0; i < steps; i++){
            char step = production.charAt(i);
            if (step == 'F'){
                for (int j = 0; j < repeats; j++){
                    Sketch.processing.line(0, 0, 0, -drawLength);
                    Sketch.processing.translate(0, drawLength);
                }
                repeats = 1;
            }
            else if (step == '+'){
                for (int j = 0; j < repeats; j++){
                    Sketch.processing.rotate(theta);
                }
                repeats = 1;
            }
            else if (step == '-'){
                for (int j = 0; j < repeats; j++){
                    Sketch.processing.rotate(-theta);
                }
                repeats = 1;
            }
            else if (step == '['){
                Sketch.processing.pushMatrix();
            }
            else if (step == ']'){
                Sketch.processing.popMatrix();
            }
            else if ((step >= 48) && (step <= 57)){
                repeats += step - 48;
            }
        }
    }

    public String iterate(String prod_, String rule_){
        StringBuilder newProduction = new StringBuilder();
        for (int i = 0; i < prod_.length(); i++){
            char step = production.charAt(i);
            if (step == 'F'){
                newProduction.append(ruleF);
            }
            else {
                if (step != 'F'){
                    newProduction.append(step);
                }
            }
        }
        drawLength *= 0.4F;
        generations++;
        return newProduction.toString();
    }
}
