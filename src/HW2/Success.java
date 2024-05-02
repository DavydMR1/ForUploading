package HW2;

import java.util.Random;

public class Success {
    protected boolean drunk;
    protected boolean tired;
    protected boolean atwork;
    Random random = new Random();
    public int finalrate;
    public void numbergen() {
        drunk = random.nextBoolean();
        atwork = random.nextBoolean();
        tired = random.nextBoolean();
    }
    public Success (int defaltrate) {
        numbergen();
        if (drunk) {defaltrate -= 3;}
        if (tired) {defaltrate -= 1;}
        if (!atwork) {defaltrate = 0;}
        finalrate = defaltrate;
    }
}
