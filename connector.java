import java.sql.*;

public class connector{
    public static Connection getCon(){
	try{
	    Class.forName("org.postgresql.Driver");

	    //String url = "jdbc:postgresql://150.7.170.255/literature";
            String url = "jdbc:postgresql://127.0.0.1/literature";
	    String user = "chang", pass = "";
	    con = DriverManager.getConnection(url, user, pass);
	}
	catch(Exception e){
	    e.printStackTrace();
	}
	return con;
    }
    public static void main(String[] args){

	connector c = new connector();
	Connection con = c.getCon();
	try{
	    con.close();
	}catch(Exception e){e.printStackTrace();}
    }
    private static Connection con;
}
