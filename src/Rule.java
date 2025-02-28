/**
 * Rule object class stores a letter with its corresponding generation rule.
 *
 * @author Eman Naveed
 */
public class Rule {
    char a;
    String b;

    /**
     * Constructor for class Rule
     *
     * @param a_ Letter
     * @param b_ Rule corresponding to letter
     */
    Rule(char a_, String b_){
        a = a_;
        b = b_;
    }

    /**
     * Getter for letter
     *
     * @return letter
     */
    char getA(){
        return a;
    }

    /**
     * Getter for rule
     *
     * @return rule String
     */
    String getB(){
        return b;
    }
}
