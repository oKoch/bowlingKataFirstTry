import org.junit.Assert;
import org.junit.Test;
import second.FrameFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Created by okoch on 20.03.17.
 */
public class frameFactory {

    @Test
    public void calculateGameTest1() {

        List<Integer> results = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);

        FrameFactory frameFactory = new FrameFactory(results);

        Assert.assertEquals(300, frameFactory.calculateWholeResult());

    }

    @Test
    public void calculateGameTest2() {

        List<Integer> results = Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

        FrameFactory frameFactory = new FrameFactory(results);

        Assert.assertEquals(150, frameFactory.calculateWholeResult());
    }

    @Test
    public void calculateGameTest3() {

        List<Integer> results = Arrays.asList(5, 5, 10, 3, 4, 6, 4, 10, 10, 10, 10, 4, 6, 4, 3);

        FrameFactory frameFactory = new FrameFactory(results);

        Assert.assertEquals(189, frameFactory.calculateWholeResult());

    }

    @Test
    public void calculateGameTest4() {

        List<Integer> results = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 , 1, 1);

        FrameFactory frameFactory = new FrameFactory(results);

        Assert.assertEquals(21, frameFactory.calculateWholeResult());

    }

    @Test
    public void calculateGameTest5() {

        List<Integer> results = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 , 1, 1,5,6,7,8,9,10);
        boolean exceptionMarker = false;
        try {
            FrameFactory frameFactory = new FrameFactory(results);
            exceptionMarker= false;
        } catch( IllegalArgumentException e){
            exceptionMarker= true;
            e.printStackTrace();
        }
        Assert.assertEquals(true, exceptionMarker);

    }

    @Test
    public void calculateGameTest6() {

        List<Integer> results = Arrays.asList(1, 1, 1, 1, 1, 1);
        boolean exceptionMarker = false;
        try {
            FrameFactory frameFactory = new FrameFactory(results);
            exceptionMarker= false;
        } catch( IllegalArgumentException e){
            exceptionMarker= true;
            e.printStackTrace();
        }
        Assert.assertEquals(true, exceptionMarker);

    }

}
