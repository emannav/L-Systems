import java.util.Arrays;
import java.util.List;

public class LSystem {
    String sentence;
    List<Rule> ruleset;
    int generation;

    LSystem(String axiom, List<Rule> rules){
        this.sentence = axiom;
        this.ruleset = rules ;
    }

    public void generate(){
        StringBuilder nextgen = new StringBuilder();
        char c;
        int index;
        for(int i = 0; i < this.sentence.length(); i++){
            c = this.sentence.charAt(i);
            if(this.ruleset.contains(c)){
                index = this.ruleset.indexOf(c);
                nextgen.append(this.ruleset.get(index).getB());
            }
            else{
                nextgen.append(c);
            }
        }
        this.sentence = nextgen.toString();
    }

}
