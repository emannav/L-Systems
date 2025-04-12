import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * LSystem object replicates strings as determined by the corresponding ruleset.
 *
 * @author Eman Naveed
 *
 */
public class LSystem {
    String sentence;
    List<Rule> ruleset;
    Boolean stochastic;
    String first;

    /**
     * Constructor for class LSystem.
     *
     * @param axiom Input string to be replicated.
     * @param rules Rule set dictating how replication will occur.
     * @param stochastic Determines which generator function will be used.
     */
    LSystem(String axiom, List<Rule> rules, Boolean stochastic){
        this.sentence = axiom;
        this.ruleset = rules ;
        this.stochastic = stochastic;
        first = axiom;
    }

    /**
     * Builds latest production using the existing ruleset
     *
     * <p>
     *     Note: Instead of returning the string to the Turtle object, generate changes the value of the local sentence
     *     variable. The Turtle then accesses this String using the getter. This confines all String related functions
     *     to this class instead of needing more parameters passed to other objects.
     * </p>
     */
    public void generate(){
        StringBuilder nextgen = new StringBuilder();
        char c;
        if (!stochastic){
            for(int i = 0; i < sentence.length(); i++){

                // variable c temporarily stores letters
                c = sentence.charAt(i);

                // checks if letter has generation rule corresponding to it
                if(contains(c)) {
                    // if True, append generation to StringBuilder
                    nextgen.append(generator(c));
                }
                else{
                    // if False, append letter unchanged
                    nextgen.append(c);
                }
            }
        }
        else {
            for(int i = 0; i < sentence.length(); i++){

                // variable c temporarily stores letters
                c = sentence.charAt(i);

                // checks if letter has generation rule corresponding to it
                if(contains(c)) {
                    // if True, append generation to StringBuilder
                    nextgen.append(stochGenerator(c));
                }
                else{
                    // if False, append letter unchanged
                    nextgen.append(c);
                }
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
            comp = rule.getA();

            // checks if character has rule corresponding to it
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
    public String generator(char c){
        // temporary comparison character
        char comp;

        // iterates through the stored ruleset
        for (Rule rule : ruleset){
            comp = rule.getA();

            // returns rule corresponding to character
            if (c == comp){
                return rule.getB();
            }
        }
        return null;
    }

    /**
     * Fetches generation String according to probability of outcome
     *
     * @param c Letter to get the rule for
     * @return Rule corresponding to input letter
     */
    public String stochGenerator(char c){
        // temporary comparison character
        char comp;
        Random random = new Random();

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> probabilities = new ArrayList<>();

        Double cumulativeProbability = 0.0;
        // random number used to determine outcome
        double randomVal = random.nextDouble();

        for (Rule rule : ruleset){
            comp = rule.getA();
            // compiles all strings and their probabilities into specific ArrayLists
            if (c == comp){
                strings.add(rule.getB());
                probabilities.add(rule.getC());
            }
        }

        // cutoff values defined based on cumulative probabilities
        // ensures that each string has a predetermined chance of being selected
        for (int i = 0; i < strings.size(); i++) {
            cumulativeProbability += probabilities.get(i);

            // outcome selected
            if (randomVal <= cumulativeProbability) {
                return strings.get(i);
            }
        }
        // in case of rounding issues
        return strings.getLast();
    }

    public void reset(){
        this.sentence = first;
    }

}