import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class cardFrame extends JFrame{

    public cardFrame(Connection c){

	con = c;

	setTitle("Card Information");
	setSize(WIDTH, HEIGHT);

	JPanel cardPanel = new JPanel();
	cardPanel.setLayout(new GridBagLayout());

	JLabel lbSource = new JLabel("Source ID: ");
	GridBagConstraints cs = new GridBagConstraints();
	cs.gridx = 0;
	cs.gridy = 0;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbSource, cs);

	cs.gridx = 1;
	cs.gridy = 0;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(tfSource_no, cs);

	JLabel lbAuthor = new JLabel("Author: ");
	cs.gridx = 0;
	cs.gridy = 1;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbAuthor, cs);

	cs.gridx = 1;
	cs.gridy = 1;
	cs.gridwidth = 2;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbPaperAuthor, cs);

	JLabel lbTitle = new JLabel("Source Title: ");
	cs.gridx = 0;
	cs.gridy = 2;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbTitle, cs);

	cs.gridx = 1;
	cs.gridy = 2;
	cs.gridwidth = 3;
	cs.gridheight = 1;
	cs.weightx = 1;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbPaperTitle, cs);

	JLabel lbCardId = new JLabel("Card id: ");
	cs.gridx = 0;
	cs.gridy = 3;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbCardId, cs);

	cs.gridx = 1;
	cs.gridy = 3;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbIdnum, cs);

	JLabel lbCardTitle = new JLabel("Title: ");
	cs.gridx = 0;
	cs.gridy = 4;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbCardTitle, cs);
	
	cs.gridx = 1;
	cs.gridy = 4;
	cs.gridwidth = 3;
	cs.gridheight = 3;
	cs.weightx = 1;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.NORTHWEST;
	cs.fill = GridBagConstraints.BOTH;
	taTitle.setLineWrap(true);
	taTitle.setWrapStyleWord(true);
	cardPanel.add(taTitle, cs);

	JLabel lbContent = new JLabel("Content: ");
	cs.gridx = 0;
	cs.gridy = 7;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbContent, cs);

	cs.gridx = 1;
	cs.gridy = 7;
	cs.gridwidth = 3;
	cs.gridheight = 7;
	cs.weightx = 1;
	cs.weighty = 1;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.NORTHWEST;
	cs.fill = GridBagConstraints.BOTH;
	taContent.setLineWrap(true);
	taContent.setWrapStyleWord(true);
	cardPanel.add(taContent, cs);

	JLabel lbDate = new JLabel("date: ");
	cs.gridx = 0;
	cs.gridy = 14;
	cs.gridwidth = 1;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,15,0);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbDate, cs);

	cs.gridx = 1;
	cs.gridy = 14;
	cs.gridwidth = 3;
	cs.gridheight = 1;
	cs.weightx = 0;
	cs.weighty = 0;
	cs.insets = new Insets(5,5,0,5);
	cs.anchor = GridBagConstraints.WEST;
	cs.fill = GridBagConstraints.NONE;
	cardPanel.add(lbCardDate, cs);


	Container contentPane = getContentPane();
	contentPane.add(cardPanel, BorderLayout.CENTER);

	JPanel buttonPanel = new JPanel();
	JButton btInsert = new JButton("Insert");
	btInsert.addActionListener(new insertListener());
	JButton btReset = new JButton("Reset");
	btReset.addActionListener(new resetListener());
        JButton btUpdate = new JButton("Update");
        btUpdate.addActionListener(new updateListener());
	buttonPanel.add(btInsert);
	buttonPanel.add(btReset);
        buttonPanel.add(btUpdate);
	
	buttonPanel.add(tfSearchTxt);
	JButton btSearch = new JButton("Search");
	btSearch.addActionListener(new searchListener());
	buttonPanel.add(btSearch);
	    
	contentPane.add(buttonPanel, BorderLayout.SOUTH);

	JPanel npPanel = new JPanel();
	btPrev.addActionListener(new prevListener());
	btNext.addActionListener(new nextListener());
	npPanel.add(btPrev);
	npPanel.add(btNext);
	contentPane.add(npPanel, BorderLayout.NORTH);
    }

    public cardFrame(card k, Connection conn){
	this(conn);
	showCard(k);
    }

    public cardFrame(long i, Connection conn){
	this(conn);
	cArray = cm.sourceToCardArray(i, conn);
	if(!cArray.isEmpty()){
	    iter = cArray.listIterator();
	    if(iter.hasNext()){
		showCard((card)iter.next());
		btPrev.setEnabled(false);
	    }
	    if(!iter.hasNext()){
		btNext.setEnabled(false);
	    }
	}
    }

    public cardFrame(ArrayList ca, Connection conn){
	this(conn);
	setCArray(ca);
    }

    public void setCArray(ArrayList ca){
	if(ca.isEmpty()){
	    reset();
	    return;
	}
	cArray = (ArrayList)ca.clone();
	iter = cArray.listIterator();
	if(iter.hasNext()){
	    showCard((card)iter.next());
	}
	if(iter.hasNext()){
	    btNext.setEnabled(true);
	}
	else{
	    btNext.setEnabled(false);
	}
	btPrev.setEnabled(false);
	   
    }
	

    private class insertListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(tfSource_no.getText().equals(""))
		return;
	    if(!(lbIdnum.getText().equals("")))
		return;
	    setC();
	    try{
		Statement st = con.createStatement();
		long i = cardManager.insertCard(myCard, con);
		if(i != 0)
		    lbIdnum.setText((new Long(i)).toString());
		String d = "";
		String s = "SELECT date from cards WHERE card_id = " + i;
		ResultSet rs = st.executeQuery(s);
		if(rs.next())
		    d = rs.getDate("date").toString();
		lbCardDate.setText(d);
		rs.close();
		st.close();
	    }
	    catch(Exception e){
		e.printStackTrace();
	    }
	}
    }

    private class updateListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(tfSource_no.getText().equals(""))
                return;
            if(lbIdnum.getText().equals(""))
                return;
            setC();
            try{
                cardManager.updateCard(Integer.parseInt(lbIdnum.getText()), myCard, con);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    private class resetListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    reset();
	}
    }

    public void reset(){
	tfSource_no.setText("");
	lbPaperAuthor.setText("");
	lbPaperTitle.setText("");
	lbIdnum.setText("");
	taTitle.setText("");
	taContent.setText("");
	lbCardDate.setText("");
	btPrev.setEnabled(false);
	btNext.setEnabled(false);
    }

    private class searchListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    String searchtext = tfSearchTxt.getText();
	    if(searchtext.equals(""))
		return;
	    ArrayList ca = cm.searchCard(searchtext, con);
	    setCArray(ca);
	}
    }
		

    /*Listener for the previous button. */
    private class prevListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(iter.hasPrevious()){
		showCard((card)iter.previous());
	    }
	    if(!iter.hasPrevious()){
		btPrev.setEnabled(false);
		iter.next();
	    }
	    if(iter.hasNext())
		btNext.setEnabled(true);
	}
    }

    /*Listener for the next button. */
    private class nextListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(iter.hasNext()){
		showCard((card)iter.next());
	    }
	    if(!iter.hasNext()){
		btNext.setEnabled(false);
		iter.previous();
	    }
	    if(iter.hasPrevious()){
		btPrev.setEnabled(true);
	    }
	}
    }

	    
    //Set the information on the swing components on myCard	
    private void setC(){
	long i;
	try{
	    i = Long.parseLong(tfSource_no.getText());
	}
	catch(NumberFormatException e){
	    i = 0;
	}
	myCard.setSource(i);
	myCard.setTitle(taTitle.getText().replace("'", "''"));
	myCard.setContent(taContent.getText().replace("'", "''"));
    }

    //Show the card on the frame
    private void showCard(card c){
	long i = c.getSource();
	Long l = new Long(i);
	tfSource_no.setText(l.toString());
	Connection con = connector.getCon();
	try{
	    Statement st = con.createStatement();
	    String s = "SELECT * FROM literature WHERE source_id =" + i;
	    ResultSet rs = st.executeQuery(s);
	    if(rs.next()){
		String ptitle = rs.getString("title");
		if(ptitle.length() > 50)
		    ptitle = ptitle.substring(0,50);
		lbPaperTitle.setText(ptitle);
	    }
	    s = "SELECT author FROM authors WHERE source_id =" + i;
	    rs = st.executeQuery(s);
	    ArrayList<String> a = new ArrayList<String>();
	    while(rs.next()){
		a.add(rs.getString("author"));
	    }
	    String author = toAuthorString(a);
	    if(author.length() > 50)
		author = author.substring(0,50);
	    lbPaperAuthor.setText(author);
	    st.close();
	    //  con.close();
	}catch(Exception e){e.printStackTrace();}
	    
	taTitle.setText(c.getTitle());
	taContent.setText(c.getContent());
	lbIdnum.setText((new Long(c.getId())).toString());
	lbCardDate.setText(c.getDate());

    }

    //Generate a string of author names separated by commas from the arraylist
    private String toAuthorString(ArrayList a){
	String s = "";
	if(a.size() == 0)
	    return(s);
	else{
	    s += a.get(0);
	    int i = 1;
	    while(i < a.size()){
		s +=", " + a.get(i);
		i++;
	    }
	}
	return s;
    }
	

    public static void main(String[] args){
	Connection cn = connector.getCon();
	cardFrame myframe = new cardFrame(11, cn);
	myframe.setLocation(250,250);
	myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myframe.setVisible(true);
    }

    private Connection con;
    private JTextField tfSource_no = new JTextField(4);
    private JLabel lbPaperAuthor = new JLabel();
    private JLabel lbPaperTitle = new JLabel();
    private JLabel lbIdnum = new JLabel();
    private JTextArea taTitle = new JTextArea(3,30);
    private JTextArea taContent = new JTextArea(8,30);
    private JLabel lbCardDate = new JLabel();
    private JTextField tfSearchTxt = new JTextField(15);

    private JButton btPrev = new JButton("Prev");
    private JButton btNext = new JButton("Next");

    private cardManager cm = new cardManager();

    private card myCard = new card();
    private ArrayList cArray;
    private ListIterator iter;
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private final int WIDTH = 500;
    private final int HEIGHT = 500;
}
