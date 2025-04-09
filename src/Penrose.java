import processing.core.PApplet;

public class Penrose extends LSystemN {
    int steps = 0;
    float somestep = 0.1F;
    String ruleW;
    String ruleX;
    String ruleY;
    String ruleZ;

    Penrose() {
        axiom = "[X]++[X]++[X]++[X]++[X]";
        ruleW = "YF++ZF4-XF[-YF4-WF]++";
        ruleX = "+YF--ZF[3-WF--XF]+";
        ruleY = "-WF++XF[+++YF++ZF]-";
        ruleZ = "--YF++++WF[+ZF++++XF]--XF";
        startLength = 460.0F;
        theta = PApplet.radians(36);
        reset();
    }

    void useRule(String r_) {
        rule = r_;
    }

    void useAxiom(String a_) {
        axiom = a_;
    }

    void useLength(float l_) {
        startLength = l_;
    }

    void useTheta(float t_) {
        theta = PApplet.radians(t_);
    }

    public void reset() {
        production = axiom;
        drawLength = startLength;
        generations = 0;
    }

    public int getAge() {
        return generations;
    }

    public void render() {
        Sketch.processing.translate((float) Sketch.processing.width /2, (float) Sketch.processing.height /2);
        int pushes = 0;
        int repeats = 1;
        steps += 12;
        if (steps > production.length()) {
            steps = production.length();
        }

        for (int i = 0; i < steps; i++) {
            char step = production.charAt(i);
            if (step == 'F') {
                Sketch.processing.stroke(255, 60);
                for (int j = 0; j < repeats; j++) {
                    Sketch.processing.line(0, 0, 0, -drawLength);
                    Sketch.processing.noFill();
                    Sketch.processing.translate(0, -drawLength);
                }
                repeats = 1;
            }
            else if (step == '+') {
                for (int j = 0; j < repeats; j++) {
                    Sketch.processing.rotate(theta);
                }
                repeats = 1;
            }
            else if (step == '-') {
                for (int j =0; j < repeats; j++) {
                    Sketch.processing.rotate(-theta);
                }
                repeats = 1;
            }
            else if (step == '[') {
                pushes++;
                Sketch.processing.pushMatrix();
            }
            else if (step == ']') {
                Sketch.processing.popMatrix();
                pushes--;
            }
            else if ( (step >= 48) && (step <= 57) ) {
                repeats = (int)step - 48;
            }
        }

        // Unpush if we need too
        while (pushes > 0) {
            Sketch.processing.popMatrix();
            pushes--;
        }
    }

    public String iterate(String prod_, String rule_) {
        String newProduction = "";
        for (int i = 0; i < prod_.length(); i++) {
            char step = production.charAt(i);
            if (step == 'W') {
                newProduction = newProduction + ruleW;
            }
            else if (step == 'X') {
                newProduction = newProduction + ruleX;
            }
            else if (step == 'Y') {
                newProduction = newProduction + ruleY;
            }
            else if (step == 'Z') {
                newProduction = newProduction + ruleZ;
            }
            else {
                if (step != 'F') {
                    newProduction = newProduction + step;
                }
            }
        }

        drawLength = (float) (drawLength * 0.5);
        generations++;
        return newProduction;
    }

}
