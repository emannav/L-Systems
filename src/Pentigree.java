public class Pentigree extends LSystemN{
    int steps = 0;
    float somestep = 0.1F;
    float xoff = 0.01F;

    Pentigree() {
        axiom = "F-F-F-F-F";
        rule = "F-F++F+F-F-F";
        startLength = 60.0F;
        theta = Sketch.processing.radians(72);
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
        theta = Sketch.processing.radians(t_);
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
        Sketch.processing.translate(Sketch.processing.width/4, Sketch.processing.height/2);
        steps += 3;
        if (steps > production.length()) {
            steps = production.length();
        }

        for (int i = 0; i < steps; i++) {
            char step = production.charAt(i);
            if (step == 'F') {
                Sketch.processing.noFill();
                Sketch.processing.stroke(255);
                Sketch.processing.line(0, 0, 0, -drawLength);
                Sketch.processing.translate(0, -drawLength);
            }
            else if (step == '+') {
                Sketch.processing.rotate(theta);
            }
            else if (step == '-') {
                Sketch.processing.rotate(-theta);
            }
            else if (step == '[') {
                Sketch.processing.pushMatrix();
            }
            else if (step == ']') {
                Sketch.processing.popMatrix();
            }
        }
    }
}
