package second;

/**
 * Created by okoch on 17.03.17.
 */
public class Shot {


    private int value;


    public Shot (int value){

        if(value > 10 || value < 0 ){
            throw new IllegalArgumentException("Im Bowling gibt es 10 Kegel, es können nicht weniger als Null oder" +
                    " mehr als 10 mit einem Wurf umgeworfen werden!");
        }

        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


}
