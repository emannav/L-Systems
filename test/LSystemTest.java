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
        rules= new ArrayList<Rule>();
        rules.add(rule);
        lsystem = new LSystem("FF", rules);
    }

    @Test
    void testGetter(){
        assertEquals("FF", lsystem.getSentence());
    }

    @Test
    void setGenerate() {
        lsystem.generate();
        assertEquals("FGFFGF", lsystem.getSentence());
    }
}