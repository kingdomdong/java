package clock;

public class PhoneClock extends Clock {

    private UtcTime utcTime;

    @Override
    public void setLocalTime(int localTime) {
        super.localTime = localTime;
        utcTime.setUtcZeroTime(localTime - UTC_OFFSET);
    }

}
