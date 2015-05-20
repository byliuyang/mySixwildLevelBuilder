package application.Contracts;

import application.Models.*;
import application.Models.Levels.EliminationLevel;
import application.Models.Levels.LightningLevel;
import application.Models.Levels.PuzzleLevel;
import application.Models.Levels.ReleaseLevel;

/**
 * Created by harryliu on 5/19/15.
 */
public class LevelTypeContract {

    public static final int PUZZLE = 0;
    public static final int LIGHTNING = 1;
    public static final int ELIMINATION = 2;
    public static final int RELEASE = 3;


    public static PuzzleLevel generateDefaultPuzzleLevel(int position) {
        boolean unlockState = false;
        Value id = new Value(position);
        Score score = new Score(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Probabilities probabilities = new Probabilities(
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0)
        );


        Grid grid = new Grid(probabilities);

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Value swapNeighborMoveLeft = new Value(0);

        PuzzleLevel puzzleLevel = new PuzzleLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities,
                swapNeighborMoveLeft
        );

        return puzzleLevel;
    }

    public static LightningLevel generateDefaultLightningLevel(int position) {
        boolean unlockState = false;
        Value id = new Value(position);
        Score score = new Score(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Probabilities probabilities = new Probabilities(
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0)
        );


        Grid grid = new Grid(probabilities);

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Time time = new Time(0);

        LightningLevel lightningLevel = new LightningLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities,
                time
        );

        return lightningLevel;
    }

    public static EliminationLevel generateDefaultEliminationLevel(int position) {
        boolean unlockState = false;
        Value id = new Value(position);
        Score score = new Score(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Probabilities probabilities = new Probabilities(
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0)
        );


        Grid grid = new Grid(probabilities);

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        EliminationLevel eliminationLevel = new EliminationLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities
        );

        return eliminationLevel;
    }

    public static ReleaseLevel generateDefaultReleaseLevel(int position) {
        boolean unlockState = false;
        Value id = new Value(position);
        Score score = new Score(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        Probabilities probabilities = new Probabilities(
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0),
                new Value(0)
        );


        Grid grid = new Grid(probabilities);

        SpecialMoveLeft specialMoveLeft = new SpecialMoveLeft(
                new Value(0),
                new Value(0),
                new Value(0)
        );

        ReleaseLevel releaseLevel = new ReleaseLevel(
                unlockState,
                id,
                score,
                grid,
                specialMoveLeft,
                probabilities
        );

        return releaseLevel;
    }
}
