public class Turtle {
    float length;
    float theta;
    Turtle(float l, float t){
        length = l;
        theta = t;
    }

    void render(String sentence){
        Sketch.processing.stroke(0, 175);
        for(int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            switch (c){
                case 'F':
                    Sketch.processing.strokeWeight(4);
                    Sketch.processing.line(0, 0, length, 0);
                    Sketch.processing.translate(length, 0);
                    break;
                case 'G':
                    Sketch.processing.translate(length, 0);
                    break;
                case '+':
                    Sketch.processing.rotate(theta);
                    break;
                case '-':
                    Sketch.processing.rotate(-theta);
                    break;
                case '[':
                    Sketch.processing.pushMatrix();
                    break;
                case ']':
                    Sketch.processing.popMatrix();
            }


        }
    }
}
