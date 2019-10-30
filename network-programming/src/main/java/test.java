import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class test {
    
    public static void main(String[] args) {
//        Date now = new Date();
//        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd");
//        System.out.println(sdFormat.format(now));
//        System.out.println(beforeOneHour());
//        System.out.println(decimal());
//        System.out.println(((Integer)(new Random().nextInt(15) + 75)).toString());
//        
//        genericType();
//        collections();
//        integerString();
        
        split();
    }
    
    private static String beforeOneHour(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        return sdf.format(calendar.getTime());
    }
    
    private static String decimal() {
        double numerator = 1;
        double denominator = 8;
        return new BigDecimal(numerator * 100 / denominator).setScale(0, RoundingMode.DOWN).toString();
    }
    
    private static void genericType() {
        List<Throwable> throwList = new ArrayList<Throwable>();
        throwList.add(new ClassNotFoundException());
        System.out.println(throwList.get(0));
    }
    
    private static void collections() {
        List<Object> list = new ArrayList<Object>();
        list.add(1);
        list.add("12");
        
        for (int i = 0; i < list.size(); i++) {
            list.set(i, "3");
            
        }
        for (Iterator<Object> iterator = list.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        
//        list<? extends Number> numList = new ArrayList<>();
        List<Object> strList = new ArrayList<>();
        
    }
    
    private static void integerString() {
        Integer integer = 10;
        String strInt = String.format("%07d", integer);
        System.out.println(strInt);
        
        Integer convertedInt = Integer.valueOf(strInt);
        System.out.println(convertedInt);
        
    }
    
    private static void split() {
        String config = "0-<1>-11-<1>-12-<1>-13-<1>-14-<1>-15-<1>-16-<1>-1;0-<0>-18-<1>-16;12-<0>-18;0-<2>-17-<1>-0;0-<3>-19-<1>-0;13-<0>-18";
        String[] flows = config.split("[;]");
        for(String flow:flows)
        {
            System.out.println(flow);
            String[] items = flow.split("[-]");
            for (String string : items) {
                System.out.println(string);
            }
        }
        
    }
    

}
