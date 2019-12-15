package clock;

public class HotelWorldClocksRunner {

    public static void main(String[] args) {
        TimeSubject utcTime = new UtcTime();

        utcTime.attach("BJ", new CityClock(8));
        utcTime.attach("London", new CityClock(0));
        utcTime.attach("Moscow", new CityClock(4));
        utcTime.attach("Sydney", new CityClock(10));
        utcTime.attach("NewYork", new CityClock(-5));

        PhoneClock phoneClock = new PhoneClock(8);

        phoneClock.setLocalTime(9);

        utcTime.printTimeOfAllClocks();
    }

}
