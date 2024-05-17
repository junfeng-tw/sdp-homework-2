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

    @Test
    void testPerfectGame() {
        BowlingGame game = new BowlingGame();
        for (int i = 0; i < 12; i++) {
            game.roll(10); // All strikes
            // 1 = 1 + 2 + 3
            // 2 = 2 + 3 + 4
            // 3 = 3 + 4 + 5
            // 4 = 4 + 5 + 6
            // 5 = 5 + 6 + 7
            // 6 = 6 + 7 + 8
            // 7 = 7 + 8 + 9
            // 8 = 8 + 9 + 10
            // 9 = 9 + 10+ 11
            // 10 = 10 + 11 + 12
            // 4 = 4 + 5 + 6
            // 4 = 4 + 5 + 6
            // 4 = 4 + 5 + 6
            // 4 = 4 + 5 + 6
        }
        assertEquals(300, game.getScore());
    }

    @Test
    void testMixedGame() {
        BowlingGame game = new BowlingGame();
        game.roll(10); // Strike
        game.roll(7);
        game.roll(3); // Spare
        game.roll(9);
        game.roll(0); // Open frame
        game.roll(10); // Strike
        game.roll(0);
        game.roll(8); // Open frame
        game.roll(8);
        game.roll(2); // Spare
        game.roll(0);
        game.roll(6); // Open frame
        game.roll(10); // Strike
        game.roll(10); // Strike
        game.roll(10); // Strike
        game.roll(8);
        game.roll(1); // End of game
        assertEquals(167, game.getScore());
    }
}
