import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LSystemTest {
    Rule rule;
    List<Rule> rules;
    LSystem lsystem;

    @BeforeEach
    void setup(){
        rule = new Rule('F', "FGF");
        rules= new ArrayList<>();
        rules.add(rule);
    }

    @Test
    void testGetter() {
        lsystem = new LSystem("FF", rules);
        assertEquals("FF", lsystem.getSentence());
    }

    @Test
    void testGenerate() {
        lsystem = new LSystem("FF", rules);
        lsystem.generate();
        assertEquals("FGFFGF", lsystem.getSentence());
    }

    @Test
    void testInvalid() {
        lsystem = new LSystem("FAF", rules);
        assertEquals("FF", lsystem.getSentence());
    }

    @Test
    void testInvalidGenerate(){
        lsystem = new LSystem("FASFG", rules);
        lsystem.generate();
        assertEquals("FGFFGFG", lsystem.getSentence());
    }
}