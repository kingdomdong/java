package clock;

public abstract class Clock {

    protected int UTC_OFFSET; // each new class will override this field
    protected int localTime = 0;

    public Clock(int utcOffset) {
        UTC_OFFSET = utcOffset;
    }

    public abstract void setLocalTime(int localTime);

    public void setLocalTimeFromUtcZeroTime(int utcZeroTime) {
        this.localTime = utcZeroTime + UTC_OFFSET;
    }

    public String getTime() {
        return String.valueOf(this.localTime);
    }

}
