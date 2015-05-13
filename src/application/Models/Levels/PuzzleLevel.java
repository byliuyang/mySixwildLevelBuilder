package application.Models.Levels;

import application.Models.*;

public class PuzzleLevel extends Level {

    Value swapNeighborMoveLeft;

    public PuzzleLevel(boolean unlockState) {
        super(unlockState);
    }

    public PuzzleLevel(
            boolean unlockState,
            Value id,
            Score score,
            Grid grid,
            SpecialMoveLeft specialMoveLeft,
            Probabilities probabilities,
            Value swapNeighborMoveLeft) {
        super(unlockState, id, score, grid, specialMoveLeft, probabilities);
        this.swapNeighborMoveLeft = swapNeighborMoveLeft;
    }

    public boolean hasWon() {
        return swapNeighborMoveLeft.getValue() == 0;
    }

    public Value getSwapNeighborMoveLeft() {
        return swapNeighborMoveLeft;
    }

    public void setSwapNeighborMoveLeft(Value swapNeighborMoveLeft) {
        this.swapNeighborMoveLeft = swapNeighborMoveLeft;
    }

    @Override
    public void updateScore(Value amount) {
        super.updateScore(amount);
        swapNeighborMoveLeft.decrease(1);
    }
}