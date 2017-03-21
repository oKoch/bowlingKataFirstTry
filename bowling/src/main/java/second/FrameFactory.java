package second;

import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by okoch on 17.03.17.
 */
public class FrameFactory {

    //Anzahl der Runden die es in einem Bowling Spiel geben darf
    private final static int NUMBER_OFF_FRAMES_PER_GAME = 9 ; // wegen for Schleife nicht 10 (0...9)

    private final static int STRIKE_MARKER = 10;

    private final static int SPARE_MARKER = 10;

    //zählt die Runden
    private int frameCounter = 0;

    //hält Liste die zurück gegeben werden kann von der Factory.
    private List<Frame> resultRounds = new ArrayList<Frame>();

    private int wholeResult = 0;

    public FrameFactory (List<Integer> results) throws IllegalArgumentException {

            contructBowlingFrames(results);
    }

    private void contructBowlingFrames(List<Integer> results){
        if( results.size() < 11){
            throw new IllegalArgumentException("Die Ergebnis Liste ist zu klein");
        }

        if(results.size() > 21){
            throw new IllegalArgumentException("Die Ergebnis Liste ist zu groß");
        }


        Frame frame = new Frame();
        frameCounter = this.frameCounter;

        for (int result : results){

            try{
                Shot shot = new Shot(result);

                if (frameCounter == NUMBER_OFF_FRAMES_PER_GAME) {
                    frame.setLastFrame(true);
                    if(frame.isStrike()) {
                        frame.addShotCheckless(shot);
                    }else if( frame.isSpare()){
                        frame.addShotCheckless(shot);
                    }else {
                        frame.addShotWithCheck(shot);
                    }
                    continue;

                } else {

                    frame.addShotWithCheck(shot);

                    if (frame.isStrike() && frameCounter < NUMBER_OFF_FRAMES_PER_GAME) {
                        resultRounds.add(frame);
                        frame = new Frame();
                        frameCounter = this.frameCounter + 1;
                        continue;
                    }

                    if (frame.getSizeOfFrame() == 2 && frameCounter < NUMBER_OFF_FRAMES_PER_GAME) {
                        resultRounds.add(frame);
                        frame = new Frame();
                        frameCounter = this.frameCounter + 1;

                        continue;
                    }
                }

            } catch (IllegalArgumentException e){
                e.printStackTrace();
                break;
            }

        }
        this.resultRounds.add(frame);

    }

    private void addValueToResult(int value) {
        this.wholeResult = this.wholeResult + value;
    }

    public int calculateWholeResult () {

        Frame lastFrame = this.resultRounds.get(9);
        addValueToResult(lastFrame.getValue());

        for (int i = 0; i < this.resultRounds.size() - 1; i++ ){
            Frame actualFrame = this.resultRounds.get(i);
            Frame nextFrame = this.resultRounds.get(i + 1);
            if(i < 8 ) {
               Frame thirdFrame = this.resultRounds.get(i + 2);
                if(actualFrame.isStrike() && nextFrame.isStrike()){

                    addValueToResult( actualFrame.getValue()+ nextFrame.getValue() +
                            thirdFrame.getValueOfFirstShot()) ;
                    continue;

                }
            }

            if(actualFrame.isStrike()){
                addValueToResult(actualFrame.getValue() + nextFrame.getValueOfFirstShot() + nextFrame.getValueOfSecondShot());
                continue;
            }

            if(actualFrame.isSpare()) {
                addValueToResult(actualFrame.getValue() + nextFrame.getValueOfFirstShot());
            }else {
                addValueToResult(actualFrame.getValue());
            }
        }

        return this.wholeResult;
    }

}
