import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class newPaperFrame extends paperFrame {

    newPaperFrame(){
	super();
	setSize(700, 520);

	nextButton.addActionListener(new nextListener());
	prevButton.addActionListener(new prevListener());
	btSearch.addActionListener(new searchListener());
	btProjectSearch.addActionListener(new ProjectSearchListener());

	btRetrieve.addActionListener(new retrieveListener());

	JButton btAuPrev = new JButton("Prev");
	JButton btAuNext = new JButton("Next");
	btAuPrev.addActionListener(new nextListener());
	btAuNext.addActionListener(new prevListener());

	npPanel.setLayout(new FlowLayout());
	npPanel.add(prevButton);
	npPanel.add(nextButton);
	npPanel.add(tfKey);
	npPanel.add(btSearch);

	btAuthorSearch.addActionListener(new AuthorSearchListener());
	JPanel authorPanel = new JPanel();
	authorPanel.setLayout(new FlowLayout());
	authorPanel.add(tfAuthorKey);
	authorPanel.add(btAuthorSearch);
	authorPanel.add(btProjectSearch);

	JPanel doublePanel = new JPanel();
	doublePanel.setLayout(new GridLayout(2,1));
	doublePanel.add(npPanel);
	doublePanel.add(authorPanel);
	contentPane.add(doublePanel, BorderLayout.NORTH);
    }

    /** paper arrayをセットする関数 */
    public void setPArray(ArrayList<paper> pa){
	parray = (ArrayList)pa.clone();
	pind = parray.listIterator();
	if(pind.hasNext()){
	    paper p = (paper)pind.next();
	    uploadP(p);
	    long id = p.getId();
	    if(id != 0){
		if(myFrame != null)
		    myFrame.setCArray(cm.sourceToCardArray(id, con));
	    }
	}
	prevButton.setEnabled(false);
	if(pind.hasNext()){
	    nextButton.setEnabled(true);
	}
	else{
	    nextButton.setEnabled(false);
	}
    }

    private class retrieveListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    ArrayList<paper> pa = new ArrayList<paper>();
	    paper p = new paper();
	    p = manager.idToPaper(Long.parseLong(tfIdnum.getText()), con);
	    pa.add(p);
	    setPArray(pa);
	    nextButton.setEnabled(false);
	    prevButton.setEnabled(false);
	}
    }


    /*Listener for the next button. */
    private class nextListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(pind.hasNext()){
		paper p = (paper)pind.next();
		uploadP(p);
		long id = p.getId();
		if(id != 0){
		    if(myFrame != null)
			myFrame.setCArray(cm.sourceToCardArray(id, con));
		}
		if(pind.hasNext()){
		    nextButton.setEnabled(true);
		}
		else{
		    nextButton.setEnabled(false);
		    pind.previous();
		}
		prevButton.setEnabled(true);
	    }
	    else{
		nextButton.setEnabled(false);
	    }
	}
    }

    /*Listener for the previous button. */
    private class prevListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(pind.hasPrevious()){
		paper p = (paper)pind.previous();
		uploadP(p);
		long id = p.getId();
		if(id != 0){
		    if(myFrame != null)
			myFrame.setCArray(cm.sourceToCardArray(id, con));
		}
		if(pind.hasPrevious()){
		    prevButton.setEnabled(true);
		}
		else{
		    prevButton.setEnabled(false);
		    pind.next();  //先頭にきたときは、position 0から１に戻す。
		}
		nextButton.setEnabled(true);
		return;
	    }
	    else{
		prevButton.setEnabled(false);
		return;
	    }
	}
    }

    private class searchListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
            ArrayList<paper> parray = new ArrayList<paper>();
            String myKey = tfKey.getText();
            ArrayList<paper> keyWordResults = pm.keyWordSearch(myKey, con);
            ArrayList<paper> titleResults = pm.titleSearch(myKey, con);
            if(!(keyWordResults.isEmpty())){
                parray = keyWordResults;
                if(!(titleResults.isEmpty())){
                    parray.addAll(titleResults);
                }
            }
            else{
                if(!titleResults.isEmpty())
                    parray=titleResults;
            }
            if(!(parray.isEmpty())){
	        setPArray(parray);
            }
	    else{
		reset();
		if(myFrame != null)
		    myFrame.reset();
	    }
	}
    }

    private class AuthorSearchListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    ArrayList<paper> al = pm.authorSearch(tfAuthorKey.getText(), con);
	    if(!al.isEmpty())
		setPArray(al);
	}
    }

    private class ProjectSearchListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    ArrayList<paper> al = pm.projectSearch(Integer.parseInt(tfProject.getText()), con);
	    if(!al.isEmpty())
		setPArray(al);
	}
    }

    public static void main(String[] args){
	newPaperFrame newFrame = new newPaperFrame();
	con = connector.getCon();
	newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	newFrame.setLocation(10, 10);
	newFrame.setVisible(true);
    }
    
    protected static Connection con;
    protected ArrayList   parray;
    protected ListIterator pind;
    private paperManager pm = new paperManager();
    private JPanel npPanel = new JPanel();
    private JButton nextButton = new JButton("Next");
    private JButton prevButton = new JButton("Prev");
    private JTextField tfKey = new JTextField(10);
    private JTextField tfAuthorKey = new JTextField(10);
    private JButton btSearch = new JButton("Search");
    private JButton btAuthorSearch = new JButton("Author Search");
    private JButton btProjectSearch = new JButton("Project Search");
    private cardManager cm = new cardManager();
 }
