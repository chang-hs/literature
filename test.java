import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class test {
    
    public static void main(String[] args){
        String d = "DuBoulay G, O'Connell J";
        ArrayList<String> a = new ArrayList<String>();
        parsAuthor.pars(d, a);
        Iterator<String> iter = a.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
/*        ResultSet rs;
        connector myconnector = new connector();
	Connection con = (new connector()).getCon();    
        try{
	    Statement st = con.createStatement();
	    String s = "SELECT * FROM cards";
            rs = st.executeQuery(s);
            while(rs.next()){
                d = rs.getString("date");
                System.out.println(d);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        */
    }
}
