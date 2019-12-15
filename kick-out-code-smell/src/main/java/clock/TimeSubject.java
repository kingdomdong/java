package clock;

import java.util.HashMap;
import java.util.Map;

public abstract class TimeSubject {

    protected Map<String, Clock> clocks = new HashMap<>();

    public void attach(String name, Clock clock) {
        clocks.put(name, clock);
    }

    public void detach(String name) {
        clocks.remove(name);
    }

    public abstract void notifyAllClocks();

}
