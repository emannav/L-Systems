/**
 * Rule object class stores a letter with its corresponding generation rule.
 *
 * @author Eman Naveed
 */
public class Rule {
    char a;
    String b;
    double c;



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
     * Alternative constructor for stochastic l-systems
     *
     * @param a_ Letter
     * @param b_ Rule corresponding to letter
     * @param c_ Probability of outcome for this production
     */
    Rule(char a_, String b_, Double c_){
        a = a_;
        b = b_;
        c = c_;
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

    /**
     * Getter for probability
     *
     * @return outcome probability value
     */
    double getC(){
        return c;
    }
}
