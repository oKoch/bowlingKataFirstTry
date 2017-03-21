import org.junit.Assert;
import org.junit.Test;
import second.Frame;
import second.Shot;

import java.util.IllegalFormatException;

/**
 * Created by okoch on 20.03.17.
 */
public class ShotTester {


    @Test
    public void shotInizialisationBiggerTen() {

        boolean exceptionIsthrown = false;
        try {
            Shot shot1 = new Shot(11);

        } catch (IllegalArgumentException e) {

            exceptionIsthrown = true;

        }


        Assert.assertEquals(true, exceptionIsthrown);

    }

    @Test
    public void shotInizialisationSmallerZero() {

        boolean exceptionIsthrown = false;
        try {
            Shot shot1 = new Shot(-1);

        } catch (IllegalArgumentException e) {

            exceptionIsthrown = true;

        }


        Assert.assertEquals(true, exceptionIsthrown);

    }

    @Test
    public void shotInizialisationWithValidValue() {

        boolean exceptionIsthrown = false;
        try {
            Shot shot1 = new Shot(5);

        } catch (IllegalArgumentException e) {

            exceptionIsthrown = true;

        }


        Assert.assertEquals(false, exceptionIsthrown);

    }



}
