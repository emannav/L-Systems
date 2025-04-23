import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AllTests {

    // Non-stochastic variables
    Rule ruleNon;
    List<Rule> rulesNon;
    LSystem lsystemNon;

    // Stochastic variables
    Rule ruleStoch1 = new Rule('F', "FGF", 0.75);

    @BeforeEach
    void setup(){
        ruleNon = new Rule('F', "FGF");
        rulesNon = new ArrayList<>();
        rulesNon.add(ruleNon);
    }

    /**
     * LSystem tests
     */
    @Test
    void testSentenceGetter() {
        lsystemNon = new LSystem("FF", rulesNon, false);
        assertEquals("FF", lsystemNon.getSentence());
    }

    @Test
    void testGenerate() {
        lsystemNon = new LSystem("FF", rulesNon, false);
        lsystemNon.generate();
        assertEquals("FGFFGF", lsystemNon.getSentence());
    }

    @Test
    void testContainsTrue() {
        lsystemNon = new LSystem("FF", rulesNon, false);
        assertEquals(true, lsystemNon.contains('F'));
    }

    @Test
    void testFalseContains() {
        lsystemNon = new LSystem("FF", rulesNon, false);
        assertEquals(false, lsystemNon.contains('G'));
    }

    @Test
    void testReset() {
        lsystemNon = new LSystem("FF", rulesNon, false);
        lsystemNon.generate();
        lsystemNon.reset();
        assertEquals("FF", lsystemNon.getSentence());
    }

    /**
     * Rule tests
     */
    @Test
    void testGetA() {
        assertEquals('F', ruleNon.getA());
    }

    @Test
    void testGetB() {
        assertEquals("FGF", ruleNon.getB());
    }

    @Test
    void testGetC() {
        assertEquals(0.75, ruleStoch1.getC());
    }

}