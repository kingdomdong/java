public class Isomorphic {

    Recorder recorder = new Recorder();

    public boolean judge(String s, String t) {
        if (!isTwoComparatorLegal(s, t)) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!recorder.isCurrentCharLegal(s.charAt(i), t.charAt(i)))
                return false;
        }

        return true;
    }

    private Boolean isTwoComparatorLegal(String s, String t) {
        return s == null || t == null || s.length() != t.length()
                ? false
                : true;
    }

}
