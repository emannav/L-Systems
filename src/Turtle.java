public class Turtle {
    String todo;
    float length;
    float theta;
    void Turtle(String s, float l, float t){
        todo = s;
        length = l;
        theta = t;
    }

    void render(){
        Sketch.processing.stroke(0, 175);
        for(int i = 0; i < todo.length(); i++){
            char c = todo.charAt(i);
            switch (c){
                case 'F':
                    Sketch.processing.strokeWeight(2);
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
