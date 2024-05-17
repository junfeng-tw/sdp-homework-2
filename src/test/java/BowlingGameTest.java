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

    @Test
    void testSingleSpare() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertEquals(16, game.getScore());
    }

    @Test
    void testSingleStrike() {
        BowlingGame game = new BowlingGame();
        game.roll(10); // Strike
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 16; i++) {
            game.roll(0);
        }
        assertEquals(24, game.getScore());
    }

    @Test
    void testConsecutiveSpares() {
        BowlingGame game = new BowlingGame();
        game.roll(5);
        game.roll(5); // Spare
        game.roll(5);
        game.roll(5); // Spare
        game.roll(3);
        for (int i = 0; i < 15; i++) {
            game.roll(0);
        }
        assertEquals(31, game.getScore());
    }

    @Test
    void testConsecutiveStrikes() {
        BowlingGame game = new BowlingGame();
        game.roll(10); // Strike
        game.roll(10); // Strike
        game.roll(10); // Strike
        game.roll(3);
        game.roll(4);
        for (int i = 0; i < 12; i++) {
            game.roll(0);
        }
        assertEquals(77, game.getScore());
    }

    @Test
    void testTenthFrameStrike() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 18; i++) {
            game.roll(0);
        }
        game.roll(10); // Strike in the tenth frame
        game.roll(1);
        game.roll(1);
        assertEquals(12, game.getScore());
    }
}
