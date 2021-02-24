import java.util.*;
import java.sql.*;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.*;

public class paperManager{

    public static long insertPaper(paper p, Connection con){
	long source_no = 0;
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	try{
	    Statement st = con.createStatement();
	    String authors = "";
	    ArrayList a = p.getAuthors();
	    String d = formatter.format(cal.getTime());
	//Insert paper information into the table literature
	    String s = "INSERT INTO literature "
		+ "(source_typ, title, journal, volume, pages, year, editors, book_title, "
		+ "publisher, city, date, project, obtained, read) "
		+ "VALUES ('"
		+ p.getType() + "', '" + p.getTitle() + "', '"
		+ p.getJournal() + "', '" + p.getVolume() + "', '"
		+ p.getPages() + "', '" + p.getYear()
		+ "', '" + p.getEditors() + "', '" + p.getBookTitle() + "', '"
		+ p.getPublisher() + "', '" + p.getCity() + "', '" + d + "', " + p.getProject() + ", " + p.getObtained() + ", " + p.getRead() + ")" +
                " RETURNING source_id";
            //Obtain the source_id of the just inserted paper
            st.execute(s);
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                source_no = rs.getLong("source_id");
            }
	
	    String s2;

	    for(int i=0; i <  a.size(); i++){
		s2 = "INSERT INTO authors (source_id, author) VALUES ('"
		    + source_no + "', '" + (String)a.get(i) + "')";
		st.executeUpdate(s2);
	    }

	 //Insert keywords to the table "keywords"
	    ArrayList b = p.getKeywords();
	    for(int i=0; i < b.size(); i++){
		s = "INSERT INTO keywords (source_id, keyword) VALUES ('"
		    + source_no + "', '" + (String)b.get(i) + "')";
		st.executeUpdate(s);
            }

        //Insert project:source_id pair into the project_papers table
            ArrayList<Integer> project_list = p.getProjectList();
            for(int i=0; i < project_list.size(); i++){
                s = "INSERT INTO project_papers (project_id, source_id) VALUES ("
                    + project_list.get(i) + ", " + source_no + ")";
                st.executeUpdate(s);
	    }

	st.close();
	
	}catch(Exception e) {e.printStackTrace();System.out.println("This");}
	return source_no;
    }

    public static void updatePaper(long i, paper p, Connection con){
	try{
	    Statement st = con.createStatement();
	    String authors = "";
            String d = "";
	    ArrayList a = p.getAuthors();
	    Calendar cal = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            d = formatter.format(cal.getTime());
	    
	    String tail = " WHERE source_id = " + i;

	    String s = "UPDATE literature SET source_typ = '" + p.getType() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET title = '" + p.getTitle() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET journal = '" + p.getJournal() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET volume = '" + p.getVolume() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET pages = '" + p.getPages() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET year = '" + p.getYear() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET editors = '" + p.getEditors() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET book_title = '" + p.getBookTitle() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET publisher = '" + p.getPublisher() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET city = '" + p.getCity() + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET date  = '" + d + "'" + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET project = " + p.getProject() + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET obtained = " + p.getObtained() + tail;
	    st.executeUpdate(s);
	    s = "UPDATE literature SET read = " + p.getRead() + tail;
	    st.executeUpdate(s);

	    s = "DELETE FROM authors WHERE source_id =" + i;
	    st.executeUpdate(s);

	    s = "DELETE FROM keywords WHERE source_id =" + i;
	    st.executeUpdate(s);

	    String s2;
	    for(int j=0; j <  a.size(); j++){
		s2 = "INSERT INTO authors (source_id, author) VALUES ("
		    + i + ", '" + (String)a.get(j) + "')";
		st.executeUpdate(s2);
	    }

	    ArrayList b = p.getKeywords();
	    for(int j=0; j < b.size(); j++){
		s2 = "INSERT INTO keywords (source_id, keyword) VALUES ("
		    + i + ",'" + (String)b.get(j) + "')";
		st.executeUpdate(s2);
	    }
            ArrayList<Integer> projects = p.getProjectList();
            Iterator<Integer> iter = projects.iterator();
            while(iter.hasNext()){
                s2 = "DELETE FROM project_papers WHERE source_id =" + i;
                st.executeUpdate(s2);
                s2 = "INSERT INTO project_papers (source_id, project_id) VALUES ("
                    + i + ", " + iter.next() + ")";
                st.executeUpdate(s2);
            }

	    st.close();
	}catch(Exception e){e.printStackTrace();}
    }
    
    public static void deletePaper(long i, Connection con){
	try{
	    Statement st = con.createStatement();
	    String s = "DELETE FROM literature WHERE source_id = " + i;
	    st.executeUpdate(s);

	    s = "DELETE FROM authors WHERE source_id = " + i;
	    st.executeUpdate(s);

	    s = "DELETE FROM keywords WHERE source_id =" + i;
	    st.executeUpdate(s);

	    st.close();
	}catch(Exception e){e.printStackTrace();}
    }

    /* 
     *   keywordで検索して、paperのArrayListを返す関数
     *  　　String key:   keyword
     *      Connection con:   databaseのハンドル
     */
    public ArrayList<paper> keyWordSearch(String key, Connection con){
	ArrayList<paper> parray = new ArrayList<paper>();
	try{
	    String refinedKey = key.replaceAll("\\'", "\\\\'");
	    Statement st = con.createStatement();
	    String sql = "select source_id from keywords where " +
		"keyword like '%" + refinedKey + "%'";
	    ResultSet rs = st.executeQuery(sql);
	    while(rs.next()){
	    paper p = idToPaper(rs.getLong("source_id"), con);
	    parray.add(p);
	    }
	    st.close();
	}
	catch(Exception e){e.printStackTrace();}
	return parray;
    }

    public ArrayList<paper> titleSearch(String key, Connection con){
        ArrayList<paper> parray = new ArrayList<paper>();
        try{
            String refinedKey = key.replaceAll("\\'", "\\\\'");
            Statement st = con.createStatement();
            String sql = "SELECT source_id FROM literature " +
                "WHERE title LIKE '%" + refinedKey + "%'";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                paper p = idToPaper(rs.getLong("source_id"), con);
                parray.add(p);
            }
            st.close();
        }
        catch(Exception e){e.printStackTrace();}
        return parray;
    }

    /* Author nameで検索して、paperのArrayListを返す関数 */
    public ArrayList<paper> authorSearch(String key, Connection con){
	ArrayList<paper> parray = new ArrayList<paper>();
	try{
	    Statement st = con.createStatement();
	    String sql = "select source_id from authors where " +
		"author like '%" + key.trim() + "%'";
	    ResultSet rs = st.executeQuery(sql);
	    while(rs.next()){
		paper p = idToPaper(rs.getLong("source_id"), con);
		parray.add(p);
	    }
	    st.close();
	}
	catch(Exception e){e.printStackTrace();}
	return parray;
    }

    /*Project で検索して、paperのArrayListを返す関数 */
    public ArrayList<paper> projectSearch(int project_num, Connection con){
	ArrayList<paper> parray = new ArrayList<paper>();
	try{
	    Statement st = con.createStatement();
	    String sql = "select source_id from project_papers where " +
		"project_id = " + project_num + " ORDER BY source_id";
	    ResultSet rs = st.executeQuery(sql);
	    while(rs.next()){
		paper p = idToPaper(rs.getLong("source_id"), con);
		parray.add(p);
	    }
	    st.close();
	}
	catch(Exception e){e.printStackTrace();}
	return parray;
    }

    /*
     * 与えられたID番号で検索し、結果からpaper objectを作り、それを返す関数
     *     i:      source_id
     *     con:    connection handle
     */
    public paper idToPaper(long i, Connection con){
	paper p = new paper();
	ArrayList<String> authors = new ArrayList<String>();
	ArrayList<String> keywords = new ArrayList<String>();
        ArrayList<Integer> project_ids = new ArrayList<Integer>();
	DateFormat df = DateFormat.getDateInstance();
	Statement st;
	try{
	    st = con.createStatement();
	    String s = "select * from literature where source_id = " +
		Long.toString(i);
	    ResultSet rs = st.executeQuery(s);
	    if(rs.next()){
		p.setId(i);
		p.setType(rs.getString("source_typ").charAt(0));
		p.setTitle(rs.getString("title"));
		p.setJournal(rs.getString("journal"));
		p.setVolume(rs.getString("volume"));
		p.setPages(rs.getString("pages"));
		p.setYear(rs.getString("year"));
		p.setDate((rs.getDate("date")).toString());
		p.setEditors(rs.getString("editors"));
		p.setBookTitle(rs.getString("book_title"));
		p.setPublisher(rs.getString("publisher"));
		p.setCity(rs.getString("city"));
		p.setProject(rs.getInt("project"));
		p.setObtained(rs.getBoolean("obtained"));
		p.setRead(rs.getBoolean("read"));
	    }

	    //authors table からの検索
	    s = "select author from authors where source_id = " + Long.toString(i);
	    rs = st.executeQuery(s);
	    while(rs.next()){
		authors.add(rs.getString("author"));
	    }
	    p.setAuthors(authors);

	    //keywords table からの検索
	    s = "select keyword from keywords where source_id = " +
		Long.toString(i);
	    rs = st.executeQuery(s);
	    while(rs.next()){
		keywords.add(rs.getString("keyword"));
	    }
	    p.setKeywords(keywords);

            //project_papers table search
            s = "SELECT project_id FROM project_papers WHERE source_id = " + Long.toString(i);
            rs = st.executeQuery(s);
            while(rs.next()){
                project_ids.add(rs.getInt("project_id"));
            }
            p.setProjectList(project_ids);

	    st.close();
	}catch(Exception e){e.printStackTrace();}
	return p;
    }
    
    public static void setObtained(long idNum, boolean obtained, Connection con){
	try{
	    Statement st = con.createStatement();
	    String booleanString;
	    if(obtained)
		booleanString = "true";
	    else
		booleanString = "false";
	    String s = "UPDATE literature SET obtained = " + booleanString + " where source_id = " + idNum;
	    st.executeUpdate(s);
	}
	catch(Exception e){e.printStackTrace();}
    }

    public static void setRead(long idNum, boolean read, Connection con){
	try{
	    Statement st = con.createStatement();
	    String booleanString;
	    if(read)
		booleanString = "true";
	    else
		booleanString = "false";
	    String s = "UPDATE literature SET read = " + booleanString + " where source_id = " + idNum;
	    st.executeUpdate(s);
	}
	catch(Exception e){e.printStackTrace();}
    }


    public static void main(String[] args){
	paper p = new paper();
	ArrayList<String> a = new ArrayList<String>();
	a.add("Wayne, J");
	a.add("Maeda, M");
	p.setTitle("Wonderful world of movies");
	p.setAuthors(a);
	p.setJournal("J Neurosurg");
	p.setVolume("51");
	p.setPages("51-56");
	p.setYear("1989");
	ArrayList<String> b = new ArrayList<String>();
	b.add("neurosurgery");
	b.add("technical note");
	p.setKeywords(b);
	try{
	    Connection con = connector.getCon();
	    long i = insertPaper(p, con);
	    System.out.println(i);
	    con.close();
	}catch(Exception e){System.out.println("2nd block");}
    }
}
