package clock;

public abstract class Clock {

    protected static final int UTC_OFFSET = 0;
    protected int localTime = 0;

    public abstract void setLocalTime(int localTime);

    public static int toLocalTime(int utcZeroTime) {
        return utcZeroTime + UTC_OFFSET;
    }

}
