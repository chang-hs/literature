import java.util.*;
import java.sql.*;

public class paper implements Cloneable {

    //Only the default constructor is provided


    public void setId(long i){
	id = i;
    }
    public void setTitle(String s){
	title = s;
    }
    public void setType(char c){
	type = c;
    }
    public void setAuthors(ArrayList<String> a){
	authors = a;
    }
    public void setJournal(String s){
	journal = s;
    }
    public void setVolume(String s){
	volume = s;
    }
    public void setPages(String s){
	pages = s;
    }
    public void setYear(String s){
	year = s;
    }
    public void setCity(String s){
	city = s;
    }
    public void setPublisher(String s){
	publisher = s;
    }
    public void setEditors(String s){
	editors = s;
    }
    public void setBookTitle(String s){
	bookTitle = s;
    }
    public void setKeywords(ArrayList k){
	keywords = k;
    }
    public void setDate(String d){
	date = d;
    }
    public void setProject(int i){
	project = i;
    }
    public void setProjectList(ArrayList<Integer> proj_ids){
        project_list = proj_ids;
    }
    public void setObtained(boolean b){
	obtained = b;
    }
    public void setRead(boolean b){
	read = b;
    }
	
    public long getId(){
	return id;
    }
    public String getTitle(){
	return title;
    }
    public char getType(){
	return type;
    }
    public ArrayList<String> getAuthors(){
	return authors;
    }
    public String getAuthorString(){
	String s = "";
	Iterator iter = authors.iterator();
	while(iter.hasNext()){
	    s += (String)( iter.next() );
	    if(iter.hasNext()){
		s += ", ";
	    }
	}
	return s;
    }
    public String getJournal(){
	return journal;
    }
    public String getVolume(){
	return volume;
    }
    public String getPages(){
	return pages;
    }
    public String getYear(){
	return year;
    }
    public String getEditors(){
	return editors;
    }
    public String getBookTitle(){
	return bookTitle;
    }
    public String getPublisher(){
	return publisher;
    }
    public String getCity(){
	return city;
    }
    public ArrayList getKeywords(){
	return keywords;
    }
    public String getDate(){
        return date;
    }
    public int getProject(){
	return project;
    }
    public ArrayList<Integer> getProjectList(){
        return project_list;
    }
    public String getProjectString(){
        String res = "";
        for (Integer i : project_list){
            res += i.toString() + ", ";
        }
        return res.replaceAll(", $", "");
    }
    public boolean getObtained(){
	return obtained;
    }
    public boolean getRead(){
	return read;
    }
    public String getKWString(){
	String s = "";
	Iterator iter = keywords.iterator();
	while(iter.hasNext()){
	    s += ((String)iter.next()).trim();
	    if(iter.hasNext())
		s += ", ";
	}
	return s;
    }

    public boolean equals(Object o){
	paper p = (paper)o;
	if(id == p.getId()){
	    return true;
	}
	else{
	    return false;
	}
    }
    public Object clone(){
	paper p = new paper();
	p.setId(id);
	p.setTitle(title);
	p.setAuthors(authors);
	p.setJournal(journal);
	p.setVolume(volume);
	p.setPages(pages);
	p.setYear(year);
	p.setEditors(editors);
	p.setBookTitle(bookTitle);
	p.setPublisher(publisher);
	p.setCity(city);
	p.setKeywords(keywords);
	p.setProject(project);
        p.setProjectList(project_list);
	p.setObtained(obtained);

	return p;
    }

    //Fields
    private long id = 0;
    private char type = 'J';
    private String title = "";
    private ArrayList<String> authors = null;
    private String journal = "";
    private String volume = "";
    private String pages = "";
    private String year = "";
    private ArrayList keywords = null;
    private String editors = "";
    private String bookTitle = "";
    private String publisher = "";
    private String city = "";
    private String date = "";
    private int project = 0;
    private ArrayList<Integer> project_list = new ArrayList<Integer>();
    private boolean obtained = false;
    private boolean read = false;

    public static void main(String[] args){
        Connection con;
        paper p = new paper();
        con = connector.getCon();
        try{
            Statement st = con.createStatement();
            paperManager pm = new paperManager();
            p = pm.idToPaper(Long.parseLong("445"), con);
            String projectString = p.getProjectString();
            System.out.printf(projectString);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

