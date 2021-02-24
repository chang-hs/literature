import java.sql.*;
import java.util.*;

public class cardManager{

    private static long card_id;
    
    public static long insertCard(card c, Connection con){
	long id = 0;
	try{
	    Statement st = con.createStatement();
	    String s = "INSERT INTO cards "
		+ "(source_id, title, content, date) VALUES ("
		+ c.getSource() + ", '" + c.getTitle() + "', '"
		+ c.getContent() + "', '" + c.getDate() + "')";
	    st.executeUpdate(s);

	    s = "SELECT card_id from cards WHERE source_id = " +
		c.getSource() + " AND title = '" + c.getTitle() +
		"' AND content = '" + c.getContent() + "'";
	    ResultSet rs = st.executeQuery(s);
	    if(rs.next())
		id = (long)rs.getLong("card_id");
	    st.close();
	    //	    con.close();
	}
	catch(Exception e){
	    e.printStackTrace();
	}
	return id;
    }

    public static void updateCard(long card_id, card c, Connection con){
	try{
	    Statement st = con.createStatement();
	    String tail = "WHERE card_id = " + card_id;

	    String s = "UPDATE cards set source_id =" + c.getSource() + tail;
	    st.executeUpdate(s);
	    s = "UPDATE cards set title = '"
		+ c.getTitle() + "' " + tail;
	    st.executeUpdate(s);
	    s = "UPDATE cards set content = '" + c.getContent() + "' " + tail;
	    st.executeUpdate(s);
	    s = "UPDATE cards set date = '" + c.getDate() + "' " + tail;
	    st.close();
	}
	catch(Exception e){
	    e.printStackTrace();
        }
    }

    public static ArrayList searchCard(String s, Connection con){
	ArrayList<card> cards = new ArrayList<card>();
	try{
	    Statement st = con.createStatement();
	    String sql = "Select c.* from cards c, literature l where c.source_id = l.source_id "
		//		+ "and l.project = 1 "
		+ "and (c.title like '%"
		+ s + "%' or c.content like '%" + s + "%') order by source_id";
	    ResultSet rs = st.executeQuery(sql);
	    while(rs.next()){
		card c = new card();
		c.setSource(rs.getLong("source_id"));
		c.setTitle(rs.getString("title"));
		c.setContent(rs.getString("content"));
		c.setDate((rs.getDate("date")).toString());
		c.setId(rs.getLong("card_id"));
		cards.add(c);
	    }
	    st.close();
	}
	catch(Exception e){ e.printStackTrace();}
	return cards;
    }
	    
    public static void deleteCard(long card_id, Connection con){
	try{
	    Statement st = con.createStatement();
	    String s = "DELETE FROM cards WHERE card_id = " + card_id;
	    st.executeUpdate(s);
	    st.close();
	}
	catch(Exception e){
	    e.printStackTrace();
	}
    }

    //Source_idから、その文献のカードを検索し、ArrayListとして返す関数
    //    @param long i: 文献のsource_id
    public ArrayList sourceToCardArray(long i, Connection con){
	ArrayList<card> cards = new ArrayList<card>();
	try{
	    Statement st = con.createStatement();
	    String s = "select * from cards where source_id = " + i +
                "ORDER BY date";
	    ResultSet rs = st.executeQuery(s);
	    while(rs.next()){
		card c = new card();
		c.setSource(rs.getLong("source_id"));
		c.setTitle(rs.getString("title"));
		c.setContent(rs.getString("content"));
		c.setDate((rs.getDate("date")).toString());
		c.setId(rs.getLong("card_id"));
		cards.add(c);
	    }
	    st.close();
	}
	catch(Exception e){ e.printStackTrace();}
	return cards;
    }    
			
	    

    public static void main(String[] args){
	card c = new card();
	c.setSource(3);
	c.setTitle("Another title");
	c.setContent("What a wonderful world!");
	try{
	    Class.forName("org.postgresql.Driver");

	    String url = "jdbc:postgresql://127.0.0.1/test1";
	    String user = "chang", pass = "";
	    Connection con = DriverManager.getConnection(url, user, pass);
	    
	    long i = insertCard(c, con);
	    System.out.println(i);
	}
	catch(Exception e){
	    e.printStackTrace();
	}
    }
}
