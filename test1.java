import java.util.Calendar;
import java.text.SimpleDateFormat;

class test1 {
    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(formatter.format(cal.getTime()));
    }
}
