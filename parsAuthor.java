import java.util.*;

public class parsAuthor{

    public static void pars(String s, ArrayList<String> a){
	if( s.equals(null))
		return;
	String tempstring = s.replaceAll("'", "''");
	String author, nexts;
	int i = 0, j=0;
	while(tempstring.indexOf(",") > 0){
	    i = tempstring.indexOf(",");
	    nexts = tempstring.substring(i+1);
	    j = nexts.indexOf(",");
	    if(j > 0){
		if(nexts.substring(0,j).trim().equals("Jr.") ||
		   nexts.substring(0,j).trim().equals("Sr.") ||
		   nexts.substring(0,j).trim().equals("III")){
		    i += j+1;
		}
	    }
	    else if(nexts.trim().equals("Jr.") ||
		    nexts.trim().equals("Sr.") ||
		    nexts.trim().equals("III"))
		break;
	    a.add(tempstring.substring(0,i).trim());
	    tempstring = tempstring.substring(i+1);
	}
	if(i == 0)
	    a.add(tempstring.trim());
	else
	    a.add(tempstring.substring(1).trim());
    }

    public static String arrayToString(ArrayList<String> a){
	//AuthorのArray List から、author stringを生成する。
	String s = "";
	Iterator<String> iter = a.iterator();
	while(iter.hasNext()){
            String nextString = iter.next();
            nextString = nextString.replaceAll("''", "'");
	    s += nextString;
	    if(iter.hasNext())
		s += ", ";
	}
	return s;
    }

    public static void main(String[] args){
	String authors = "Hoh BL";
    	ArrayList<String> a = new ArrayList<String>();
	pars(authors, a);
	System.out.println(a);
    }
}
