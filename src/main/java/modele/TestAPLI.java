package modele;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAPLI {
    @Test
    void distance() throws IOException {
        assertEquals(2266, Scenario.lectureDistance(new File("src/main/java/ressources/scenario_0.txt")));
        assertEquals(4558, Scenario.lectureDistance(new File("src/main/java/ressources/scenario_1_1.txt")));
        assertEquals(14287, Scenario.lectureDistance(new File("src/main/java/ressources/scenario_2_1.txt")));
    }
}
