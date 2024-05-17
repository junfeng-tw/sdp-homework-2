package com.example;

public class BowlingGame {

    private static final int MAX_FRAMES = 10;
    private static final int MAX_ROLLS = 21;
    private static final int PINS_PER_STRIKE = 10;

    private final int[] rolls = new int[MAX_ROLLS];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < MAX_FRAMES; frame++) {
            if (isStrike(rollIndex)) {
                score += PINS_PER_STRIKE + strikeBonus(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += PINS_PER_STRIKE + spareBonus(rollIndex);
                rollIndex += 2;
            } else {
                score += sumOfBallsInFrame(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == PINS_PER_STRIKE;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == PINS_PER_STRIKE;
    }

    private int strikeBonus(int rollIndex) {
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int sumOfBallsInFrame(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
