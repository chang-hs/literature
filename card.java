import java.util.*;
import java.text.SimpleDateFormat;

public class card{

    card(long source){
	source_no = source;
        Calendar cal = Calendar.getInstance();
        date = formatter.format(cal.getTime());
    }
    card(){
        Calendar cal = Calendar.getInstance();
        date = formatter.format(cal.getTime());
    }

    public void setId(long i){
	card_id = i;
    }
    public void setTitle(String s){
	title = s;
    }
    public void setContent(String s){
	content = s;
    }
    public void setSource(long n){
	source_no = n;
    }
    public void setDate(String d){
	date = d;
    }
    public long getId(){
	return card_id;
    }
    public String getTitle(){
	return title;
    }
    public String getContent(){
	return content;
    }
    public long getSource(){
	return source_no;
    }
    public String getDate(){
	return date;
    }

    //Fields
    private long source_no = 0;
    private long card_id = 0;
    private String title = "";
    private String content = "";
    private String date = "";
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    /*private Date date =  new GregorianCalendar().getTime();*/
}
