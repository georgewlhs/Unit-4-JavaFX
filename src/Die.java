import java.util.Random;

public class Die {
    private int face;
    private Random roller;

    public Die () {
        roller = new Random();
        face = 0;

    }

    public void roll(){
        face = roller.nextInt(6) + 1;
    }

    public int getFace(){
        return face;
    }

    public boolean isOne(){
        return face == 1;
    }


}
