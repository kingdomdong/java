package clock;

public class CityClock extends Clock {

    public CityClock(int utcOffset) {
        super();
    }

    @Override
    public void setLocalTime(int localTime) {
        super.localTime = localTime;
    }

}
