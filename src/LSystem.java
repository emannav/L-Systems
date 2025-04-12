import java.util.List;

/**
 * LSystem object replicates strings as determined by the corresponding ruleset.
 *
 * @author Eman Naveed
 *
 */
public class LSystem {
    String sentence;
    List<Rule> ruleset;

    /**
     * Constructor for class LSystem
     *
     * @param axiom Input string to be replicated
     * @param rules Rule set dictating how replication will occur
     */
    LSystem(String axiom, List<Rule> rules){
        this.sentence = axiom;
        this.ruleset = rules ;
    }

    /**
     * Fetches String corresponding to letters in the ruleset to generate a new replicated String
     * <p>
     *     Note: Instead of returning the string to the Turtle object, generate changes the value of the local sentence
     *     variable. The Turtle then accesses this String using the getter. This confines all String related functions
     *     to this class instead of needing more parameters passed to other objects.
     * </p>
     */
    public void generate(){
        StringBuilder nextgen = new StringBuilder();
        char c;
        for(int i = 0; i < sentence.length(); i++){
            // variable c temporarily stores letters
            c = sentence.charAt(i);
            // checks if letter has generation rule corresponding to it
            if(contains(c)) {
                // if True, append generation to StringBuilder
                nextgen.append(Generator(c));
            }
            else{
                // if False, append letter unchanged
                nextgen.append(c);
            }
        }
        sentence = nextgen.toString();
    }


    /**
     * Getter for sentence variable passed to a Turtle object
     *
     * @return sentence This will be translated to graphical output
     */
    public String getSentence(){
        return this.sentence;
    }

    /**
     * Checks if a letter has a generation rule corresponding to it
     *
     * @param c Letter to check for rule
     * @return The letter does/does not have rules corresponding to it
     */
    public Boolean contains(char c){
        char comp;
        // traverses through rule set
        for (Rule rule : ruleset){
            // checks if character is the same as rule
            comp = rule.getA();
            if (c == comp){
                return true;
            }
        }
        return false;
    }

    /**
     * Fetches generation String corresponding to specific character
     *
     * @param c Letter to get the rule for
     * @return Rule corresponding to input letter
     */
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
