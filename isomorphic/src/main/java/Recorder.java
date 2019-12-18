import java.util.HashMap;
import java.util.Map;

public class Recorder {

    private Map<Character, Character> recorder = new HashMap<>();

    public Boolean isCurrentCharLegal(char leftChar, char rightChar) {
        if (recorder.containsKey(leftChar) && recorder.get(leftChar) != rightChar)
            return false;

        if (!recorder.containsKey(leftChar))
            recorder.put(leftChar, rightChar);

        return true;
    }

}
