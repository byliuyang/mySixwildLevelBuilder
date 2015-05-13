package application.Models;

import java.io.Serializable;

/**
 * Created by harryliu on 5/5/15.
 */
public class Probabilities implements Serializable {

    Value tileOne;
    Value tileTwo;
    Value tileThree;
    Value tileFour;
    Value tileFive;
    Value tileSix;

    Value multiplierOne;
    Value multiplierTwo;
    Value multiplierThree;


    public Probabilities(
            Value tileOne,
            Value tileTwo,
            Value tileThree,
            Value tileFour,
            Value tileFive,
            Value tileSix,
            Value multiplierOne,
            Value multiplierTwo,
            Value multiplierThree) {
        this.tileOne = tileOne;
        this.tileTwo = tileTwo;
        this.tileThree = tileThree;
        this.tileFour = tileFour;
        this.tileFive = tileFive;
        this.tileSix = tileSix;
        this.multiplierOne = multiplierOne;
        this.multiplierTwo = multiplierTwo;
        this.multiplierThree = multiplierThree;
    }

    public Value getTileOne() {
        return tileOne;
    }

    public void setTileOne(Value tileOne) {
        this.tileOne = tileOne;
    }

    public Value getTileTwo() {
        return tileTwo;
    }

    public void setTileTwo(Value tileTwo) {
        this.tileTwo = tileTwo;
    }

    public Value getTileThree() {
        return tileThree;
    }

    public void setTileThree(Value tileThree) {
        this.tileThree = tileThree;
    }

    public Value getTileFour() {
        return tileFour;
    }

    public void setTileFour(Value tileFour) {
        this.tileFour = tileFour;
    }

    public Value getTileFive() {
        return tileFive;
    }

    public void setTileFive(Value tileFive) {
        this.tileFive = tileFive;
    }

    public Value getMultiplierOne() {
        return multiplierOne;
    }

    public void setMultiplierOne(Value multiplierOne) {
        this.multiplierOne = multiplierOne;
    }

    public Value getMultiplierTwo() {
        return multiplierTwo;
    }

    public void setMultiplierTwo(Value multiplierTwo) {
        this.multiplierTwo = multiplierTwo;
    }

    public Value getMultiplierThree() {
        return multiplierThree;
    }

    public void setMultiplierThree(Value multiplierThree) {
        this.multiplierThree = multiplierThree;
    }

    public Value getTileSix() {
        return tileSix;
    }

    public void setTileSix(Value tileSix) {
        this.tileSix = tileSix;
    }
}
