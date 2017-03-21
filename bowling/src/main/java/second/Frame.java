package second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by okoch on 17.03.17.
 */
public class Frame {

    private final static int STRIKE_MARKER = 10;
    private final static int FRAME_SIZE_FOR_STRIKE = 1;
    private final static int FRAME_SIZE_FOR_SPARE = 2;
    private final static int SPARE_MARKER = 10;


    private List<Shot> shots = new ArrayList<Shot>();

    private boolean isStrike = false;
    private boolean isSpare = false;
    private int sizeOfShots = 0;
    private boolean isLastFrame = false;

    public Frame(){

    }


    public void addShotWithCheck(Shot shot){

        this.shots.add(shot);
        this.sizeOfShots = this.shots.size();

        isShotAStrike(shot);
        isShotASpare(shot);

    }

    public void addShotCheckless(Shot shot) {

        this.shots.add(shot);
        this.sizeOfShots = this.shots.size();

    }

    private void isShotAStrike(Shot shot) {

        if((shot.getValue() == STRIKE_MARKER) && (sizeOfShots == FRAME_SIZE_FOR_STRIKE)){
            this.isStrike = true;
        } else {
            this.isStrike = this.isStrike;
        }
    }

    private void isShotASpare (Shot shot) {

        if (sizeOfShots == FRAME_SIZE_FOR_SPARE) {

        int value = this.shots.get(0).getValue() + this.shots.get(1).getValue();

            if ((value == SPARE_MARKER)) {

                this.isSpare = true;
            }

        } else {
            this.isSpare = this.isSpare;
        }
    }

    public List<Shot> getShots() {
        return this.shots;
    }

    public int getSizeOfFrame(){
        return this.sizeOfShots;
    }

    public boolean isStrike() {
        return this.isStrike;
    }

    public boolean isSpare() {
        return this.isSpare;
    }

    public boolean isLastFrame() {
        return this.isLastFrame;
    }

    public void setLastFrame(boolean lastFrame) {
        this.isLastFrame = lastFrame;
    }

    public int getValue() {
        int valueOfFrame = 0;
        for(Shot shot: shots) {
            valueOfFrame = valueOfFrame + shot.getValue();
        }
        return valueOfFrame;

    }

    public int getValueOfFirstShot () {
        int valueOfShot = this.shots.get(0).getValue();
        return valueOfShot;
    }

    public int getValueOfSecondShot(){
        int valueOfShot = this.shots.get(1).getValue();
        return valueOfShot;
    }

}
