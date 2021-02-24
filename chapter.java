import java.util.*;

public class chapter{
    
    public void setTitle(String s){
	title = s;
    }
    public void setId(long i){
	id = i;
    }
    public void setAuthor(ArrayList a){
	authors = a;
    }
    public void setEditor(ArrayList a){
	editors = a;
    }
    public void setChapNo(String s){
	chapter_no = s;
    }
    public void setEdition(String s){
	edition = s;
    }
    public void setPublisher(String s){
	publisher = s;
    }
    public void setPages(String s){
	pages = s;
    }
    public void setYear(String y){
	year = y;
    }
    public void setCity(String s){
	city = s;
    }
    public void setSeriesTitle(String s){
	series_title = s;
    }
    public String getTitle(){
	return title;
    }
    public long getId(){
	return id;
    }
    public ArrayList getAuthors(){
	return authors;
    }
    public ArrayList getEditors(){
	return editors;
    }
    public String getEdition(){
	return edition;
    }
    public String getPublisher(){
	return publisher;
    }
    public String getPages(){
	return pages;
    }
    public String getYear(){
	return year;
    }
    public String getCity(){
	return city;
    }
    public String getSeriesTitle(){
	return series_title;
    }

    //Fields
    private String title = "";
    private long id = 0;
    private ArrayList authors = null;
    private ArrayList editors = null;
    private String chapter_no = "";
    private String edition = "";
    private String publisher = "";
    private String pages = "";
    private String year = "";
    private String city = "";
    private String series_title = "";
}
