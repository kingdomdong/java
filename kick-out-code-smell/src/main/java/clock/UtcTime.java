package clock;

import lombok.Data;

@Data
public class UtcTime extends TimeSubject {

    private int utcZeroTime = 0;

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
        notify();
    }

    @Override
    public void notifyAllClocks() {
        for (Clock clock : clocks.values())
            clock.setLocalTime(Clock.toLocalTime(utcZeroTime));
    }

}
