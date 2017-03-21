import org.junit.Assert;
import org.junit.Test;
import second.Frame;
import second.Shot;

import java.util.IllegalFormatException;

/**
 * Created by okoch on 17.03.17.
 */
public class FrameTester {


    @Test
    public void spareTrueTest() throws IllegalArgumentException{

        Shot shot1 = new Shot(5);
        Shot shot2 = new Shot (5);
        Frame frame = new Frame();

        frame.addShotWithCheck(shot1);
        frame.addShotWithCheck(shot2);


        Assert.assertEquals(true, frame.isSpare() );

    }

    @Test
    public void strikeTrueTest() throws IllegalArgumentException {
        Shot shot1 = new Shot(10);
        Frame frame = new Frame();

        frame.addShotWithCheck(shot1);

        Assert.assertEquals(true, frame.isStrike());

    }

    @Test
    public void spareFalseTest() throws IllegalArgumentException {

        Shot shot1 = new Shot(4);
        Shot shot2 = new Shot (2);
        Frame frame = new Frame();

        frame.addShotWithCheck(shot1);
        frame.addShotWithCheck(shot2);


        Assert.assertEquals(false, frame.isSpare() );

    }

    @Test
    public void strikeFalseTest() throws IllegalArgumentException {
        Shot shot1 = new Shot(9);
        Frame frame = new Frame();

        frame.addShotWithCheck(shot1);

        Assert.assertEquals(false, frame.isStrike());

    }

    @Test
    public void frameSize() throws IllegalArgumentException {
        Shot shot1 = new Shot(5);
        Shot shot2 = new Shot (5);
        Frame frame = new Frame();

        frame.addShotWithCheck(shot1);
        frame.addShotWithCheck(shot2);

        Assert.assertEquals(2, frame.getSizeOfFrame());
        Assert.assertEquals(true, frame.isSpare());
        Assert.assertEquals(false, frame.isStrike());

    }



}
