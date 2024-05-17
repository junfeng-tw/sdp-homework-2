import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.BowlingGame;
import org.junit.jupiter.api.Test;

class BowlingGameTest {
    @Test
    void testAllZeros() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    void testAllOnes() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.getScore());
    }
}
