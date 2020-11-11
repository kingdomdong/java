package clock;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class UtcTime extends TimeSubject {

    private int utcZeroTime = 0;

    public void setUtcZeroTime(int utcZeroTime) {
        this.utcZeroTime = utcZeroTime;
        notifyAllClocks();
    }

    @Override
    public void notifyAllClocks() {
        for (Clock clock : super.clocks.values()) {
            clock.setLocalTimeFromUtcZeroTime(utcZeroTime);
        }
    }

    public void printTimeOfAllClocks() {
        for (String clockName : super.clocks.keySet()) {
            log.info(clockName + ": " + super.clocks.get(clockName).getTime());
        }
    }
}
