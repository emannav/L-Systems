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
        for(int i = 0; i < sentence.length(); i++){
            c = sentence.charAt(i);
            if(contains(c)){

                nextgen.append(Generator(c));
            }
            else{
                nextgen.append(c);
            }
        }
        sentence = nextgen.toString();
    }

//    public void setSentence(String newS){
//        this.sentence = newS;
//    }
    public String getSentence(){
        return this.sentence;
    }

    public Boolean contains(char c){
        char comp;

        for (Rule rule : ruleset){
            comp = rule.getA();
            if (c == comp){
                return true;
            }
        }
        return false;
    }

    public String Generator(char c){
        char comp;

        for (Rule rule : ruleset){
            comp = rule.getA();
            if (c == comp){
                return rule.getB();
            }
        }
        return null;
    }
}
