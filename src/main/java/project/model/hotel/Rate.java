package project.model.hotel;

/**
 * Created by slava23 on 11/28/2016.
 */
public enum Rate {

    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    ONE(1);

    private int rate;

    Rate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
