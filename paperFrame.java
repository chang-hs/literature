import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.Date;

public class paperFrame extends JFrame{

    public paperFrame(){
	setTitle("paper source information");
	setSize(WIDTH, HEIGHT);

	con = connector.getCon();

	JPanel sourcePanel = new JPanel();

	sourcePanel.setLayout(new GridBagLayout());
	
	JLabel lbId = new JLabel("id: ");
	GridBagConstraints constraints = new GridBagConstraints();
	constraints.gridx = 0;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,5,5);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbId, constraints);
	

	constraints.gridx = 1;
	constraints.gridy = 0;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,5,5);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfIdnum, constraints);

	JLabel lbTitle = new JLabel("Title: ");
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,5,5);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbTitle, constraints);

	constraints.gridx = 1;
	constraints.gridy = 1;
	constraints.gridwidth = 5;
	constraints.gridheight = 3;
	constraints.weightx = 1.0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,5);
	constraints.anchor = GridBagConstraints.NORTH;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	sourcePanel.add(taTitle, constraints);

	JLabel lbAuthor = new JLabel("Authors: ");
	constraints.gridx = 0;
	constraints.gridy = 4;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,5,5);
	constraints.anchor = GridBagConstraints.NORTHWEST;
	sourcePanel.add(lbAuthor, constraints);

	constraints.gridx = 1;
	constraints.gridy = 4;
	constraints.gridwidth = 5;
	constraints.gridheight = 2;
	constraints.weightx = 1;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,5);
	constraints.anchor = GridBagConstraints.NORTHWEST;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	sourcePanel.add(taAuthor, constraints);
	
	JLabel lbJournal = new JLabel("Journal: ");
	constraints.gridx = 0;
	constraints.gridy = 6;
	constraints.gridwidth =1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
     	sourcePanel.add(lbJournal, constraints);

	constraints.gridx = 1;
	constraints.gridy = 6;
	constraints.gridwidth = 2;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,0);
	constraints.anchor = GridBagConstraints.NORTHWEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfJournal, constraints);
	
	JLabel lbVol = new JLabel("volume: ");
	constraints.gridx = 0;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbVol, constraints);
	
	constraints.gridx = 1;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfVol, constraints);
	
	JLabel lbPages = new JLabel("pages: ");
	constraints.gridx = 2;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.EAST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbPages, constraints);

	constraints.gridx = 3;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfPages, constraints);

	JLabel lbYear = new JLabel("year: ");
	constraints.gridx = 4;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbYear, constraints);

	constraints.gridx = 5;
	constraints.gridy = 7;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,50);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfYear, constraints);

	JLabel lbKw = new JLabel("keywords: ");
	constraints.gridx = 0;
	constraints.gridy = 8;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(15,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbKw, constraints);

	constraints.gridx = 1;
	constraints.gridy = 8;
	constraints.gridwidth = 5;
	constraints.gridheight = 2;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(15,0,0,15);
	constraints.anchor = GridBagConstraints.NORTHWEST;
	constraints.fill = GridBagConstraints.HORIZONTAL;
	sourcePanel.add(taKeywords, constraints);

	JLabel lbDate = new JLabel("date: ");
	constraints.gridx = 0;
	constraints.gridy = 10;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbDate, constraints);

	constraints.gridx = 1;
	constraints.gridy = 10;
	constraints.gridwidth = 4;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,0,0,50);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbPaperDate, constraints);

	JLabel lbEditor = new JLabel("Editor: ");
	constraints.gridx = 0;
	constraints.gridy = 11;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbEditor, constraints);

	constraints.gridx = 1;
	constraints.gridy = 11;
	constraints.gridwidth = 3;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfEditor, constraints);


	JLabel lbCity = new JLabel("City: ");
	constraints.gridx = 0;
	constraints.gridy = 12;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbCity, constraints);

	constraints.gridx = 1;
	constraints.gridy = 12;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfCity, constraints);

	JLabel lbPublisher = new JLabel("Publisher: ");
	constraints.gridx = 2;
	constraints.gridy = 12;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbPublisher, constraints);

	constraints.gridx = 3;
	constraints.gridy = 12;
	constraints.gridwidth = 2;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfPublisher, constraints);

	JLabel lbBookTitle = new JLabel("Book Title: ");
	constraints.gridx = 0;
	constraints.gridy = 13;
	constraints.gridwidth = 1;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbBookTitle, constraints);

	constraints.gridx = 1;
	constraints.gridy = 13;
	constraints.gridwidth = 5;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfBookTitle, constraints);

	JLabel lbProject = new JLabel("Project: ");
	constraints.gridx = 0;
	constraints.gridy = 14;
	constraints.gridwidth = 5;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(lbProject, constraints);

	constraints.gridx = 1;
	constraints.gridy = 14;
	constraints.gridwidth = 5;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(tfProject, constraints);

	constraints.gridx = 3;
	constraints.gridy = 14;
	constraints.gridwidth = 5;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(cbObtained, constraints);

	constraints.gridx = 5;
	constraints.gridy = 14;
	constraints.gridwidth = 5;
	constraints.gridheight = 1;
	constraints.weightx = 0;
	constraints.weighty = 0;
	constraints.insets = new Insets(5,5,0,0);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.fill = GridBagConstraints.NONE;
	sourcePanel.add(cbRead, constraints);



	//Set up Line Wrap properties of the text areas
	taAuthor.setLineWrap(true);
	taAuthor.setWrapStyleWord(true);
	taTitle.setLineWrap(true);
	taTitle.setWrapStyleWord(true);
	taKeywords.setLineWrap(true);
	taKeywords.setWrapStyleWord(true);

	

	contentPane = getContentPane();
	contentPane.setLayout(new BorderLayout());

	contentPane.add(sourcePanel, BorderLayout.CENTER);

	JPanel buttonPanel = new JPanel();
	JButton btInsert = new JButton("Insert");
	btInsert.addActionListener(new insertListener());
	JButton btClear = new JButton("Clear");
	btClear.addActionListener(new clearListener());
	JButton btUpdate = new JButton("Update");
	btUpdate.addActionListener(new updateListener());
	JButton btCard = new JButton("Card");
	btCard.addActionListener(new cardListener());
	//	JButton btRetrieve = new JButton("Retrieve");
	//btRetrieve.addActionListener(new retrieveListener());

	cbObtained.addActionListener(new ObtainedListener());
	cbRead.addActionListener(new ReadListener());

	buttonPanel.add(btInsert);
	buttonPanel.add(btClear);
	buttonPanel.add(btUpdate);
	buttonPanel.add(btCard);
	buttonPanel.add(btRetrieve);
	contentPane.add(buttonPanel, BorderLayout.SOUTH);
    }

    /*Insert-listener for the button insert It makes connection with
      the database, and inserts the content shown into the database
      table "literature".  It then searches the literature table and
      get the ID and date, and set them on the respective
      textfields.*/
    private class insertListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    
	    if(!(tfIdnum.getText().equals("")))
		return;
	    
	    setP();

	    try{
		String d = "";
		long i = paperManager.insertPaper(p, con);
		Statement st = con.createStatement();
		String s = "SELECT date from literature WHERE source_id = "
		    + i;
		ResultSet rs = st.executeQuery(s);
		if(rs.next())
		    d = rs.getDate("date").toString();
		if(i != 0)
		    tfIdnum.setText((new Long(i)).toString());
		lbPaperDate.setText(d);
		st.close();
	    }
	    catch(Exception e){
		e.printStackTrace();
	    }

	}
    }

    /* Listner for the clear button.  It clears all the textfields. */
    private class clearListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    reset();
	}
    }

    protected void reset(){
	tfIdnum.setText("");
	taTitle.setText("");
	taAuthor.setText("");
	tfJournal.setText("");
	tfVol.setText("");
	tfPages.setText("");
	tfYear.setText("");
	lbPaperDate.setText("");
	taKeywords.setText("");
	tfEditor.setText("");
	tfCity.setText("");
	tfPublisher.setText("");
	tfBookTitle.setText("");
	tfProject.setText("");
	cbObtained.setSelected(false);
    }

    /*Listener for the update button.  It calls the paperManager
     * function: update Paper, and updates the database using the
     * content shown.  It first sets the private member paper p with
     * setP function, and calls the updatePaper with the source_id in
     * the textfield Idnum, p, and con. */
    private class updateListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    try{
	    long i = Long.parseLong(tfIdnum.getText());
	    setP();
            /* Connection con = connector.getCon(); */
	    paperManager.updatePaper(i, p, con);
	    }catch(Exception e){e.printStackTrace();}

	}
    }

    protected class cardListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(tfIdnum.getText().equals(""))
		return;
	    myFrame = new cardFrame(Long.parseLong(tfIdnum.getText()), con);
	    myFrame.setLocation(500, 200);
	    myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    myFrame.setVisible(true);
	}
    }

    private class ObtainedListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(tfIdnum.getText().equals(""))
		return;
	    if(cbObtained.isSelected())
		paperManager.setObtained(Long.parseLong(tfIdnum.getText()), true, con);
	    else
		paperManager.setObtained(Long.parseLong(tfIdnum.getText()), false, con);
	}
    }

    private class ReadListener implements ActionListener{
	public void actionPerformed(ActionEvent event){
	    if(tfIdnum.getText().equals(""))
		return;
	    if(cbRead.isSelected())
		paperManager.setRead(Long.parseLong(tfIdnum.getText()), true, con);
	    else
		paperManager.setRead(Long.parseLong(tfIdnum.getText()), false, con);
	}
    }
	       
    /*    private class retrieveListener implements ActionListener{
     *	public void actionPerformed(ActionEvent event){
     *    paper p = new paper();
     *    p = manager.idToPaper(Long.parseLong(tfIdnum.getText()), con);
     *    uploadP(p);
     *}
     *}
     */


    /** Builboardの情報を、paper p にセットする。*/
    protected void setP(){
	    p.setTitle(taTitle.getText().replace("'", "''"));
	    ArrayList<String> a = new ArrayList<String>();
	    parsAuthor.pars(taAuthor.getText(), a);
	    p.setAuthors(a);
	    p.setJournal(tfJournal.getText());
	    p.setVolume(tfVol.getText());
	    p.setPages(tfPages.getText());
	    p.setYear(tfYear.getText());
	    ArrayList<String> b = new ArrayList<String>();
	    parsKeyword(taKeywords.getText(), b);
	    p.setKeywords(b);
	    p.setEditors(tfEditor.getText());
	    p.setCity(tfCity.getText());
	    p.setPublisher(tfPublisher.getText());
	    p.setBookTitle(tfBookTitle.getText());
	    if(!tfProject.getText().equals("")){
                ArrayList<Integer> c = new ArrayList<Integer>();
                ArrayList<String> strArray = new ArrayList<String>();
                strArray.addAll(Arrays.asList((tfProject.getText()).split("\\s*,\\s*")));
                Iterator<String> iter = strArray.iterator();
                while( iter.hasNext()){
                    c.add(Integer.parseInt(iter.next()));
                }
                p.setProjectList(c);
            }
	    p.setObtained(cbObtained.isSelected());
	    p.setRead(cbRead.isSelected());
	    /* if it is a book, set the source_typ to 'B', otherwise, set
               it to 'J' */
	    if( !((tfBookTitle.getText()).equals(""))){
		p.setType('B');
	    }
            else{
                p.setType('J');
            }
		
    }

    /** paper p をbuilboard に表示する。*/
    protected void uploadP(paper p){
	tfIdnum.setText(Long.toString(p.getId()));
	taTitle.setText(p.getTitle());
	taAuthor.setText(parsAuthor.arrayToString(p.getAuthors()));
	tfJournal.setText(p.getJournal());
	tfVol.setText(p.getVolume());
	tfPages.setText(p.getPages());
	tfYear.setText(p.getYear());
	taKeywords.setText(p.getKWString());
	tfEditor.setText(p.getEditors());
	tfCity.setText(p.getCity());
	tfPublisher.setText(p.getPublisher());
	tfBookTitle.setText(p.getBookTitle());
	tfProject.setText(p.getProjectString());
	cbObtained.setSelected(p.getObtained());
	cbRead.setSelected(p.getRead());
	if(p.getDate() != null)
	    lbPaperDate.setText((p.getDate()).toString());
    }

    private void parsKeyword(String s, ArrayList<String> a){
	while(s.indexOf(",") > 0){
	    int i = s.indexOf(",");
	    a.add(s.substring(0,i).trim());
	    s = s.substring(i+1);
	}
	a.add(s.trim());
    }

    private void parsProjectString(String s, ArrayList<Integer> a){
        while(s.indexOf(",") > 0){
            int i = s.indexOf(",");
            a.add(Integer.parseInt(s.substring(0,i).trim()));
            s = s.substring(i+1);
        }
        a.add(Integer.parseInt(s.trim()));
    }


    public static void main(String[] args){

	JFrame myframe = new paperFrame();
	myframe.setLocation(200,200);
	myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	myframe.setVisible(true);
    }
    private final int WIDTH = 600;
    private final int HEIGHT = 320;
    protected Connection con;
    protected Container contentPane;

    protected JButton btRetrieve = new JButton("Retrieve");
    protected JTextField tfIdnum = new JTextField(4);
    private JTextArea taTitle = new JTextArea(2, 30);
    private JTextArea taAuthor = new JTextArea(2, 30);
    private JTextField tfJournal = new JTextField(15);
    private JTextField tfVol = new JTextField(7);
    private JTextField tfPages = new JTextField(9);
    private JTextField tfYear = new JTextField(4);
    private JLabel lbPaperDate = new JLabel("");
    private JTextArea taKeywords = new JTextArea(3, 30);
    private JTextField tfEditor = new JTextField(30);
    private JTextField tfCity = new JTextField(10);
    private JTextField tfPublisher = new JTextField(15);
    private JTextField tfBookTitle = new JTextField(40);
    protected JTextField tfProject = new JTextField(5);
    private JCheckBox cbObtained = new JCheckBox("Obtained");
    private JCheckBox cbRead = new JCheckBox("Read");
    protected paper p = new paper();
    protected paperManager manager = new paperManager();
    protected cardFrame myFrame;
}


    
