package premierefenetre;

import premierefenetre.Normal.FormEvent;
import premierefenetre.interfaces.FormListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class JForm extends JPanel {
	private static final int GLE = GridBagConstraints.LINE_END;
	private static final int GLA = GridBagConstraints.LINE_START;
	private static final int GLFA = GridBagConstraints.FIRST_LINE_START;
	private static final int GCENT = GridBagConstraints.CENTER;
	
	private final JLabel name, occupation, lage, ljob, citizen, taxID, lgender;
	private JTextField tname, toccupation, textID;
	private final JButton ok;
	private JList jlist;
	private FormListener formlisten; //ecouteur des evenements dans cette classe
	private final JScrollPane jsp;
	private JComboBox jcb;
	private JCheckBox jcb0;
	private final JRadioButton jrm,jrf;
	private ButtonGroup genderGroup;
	/* Ce tableau avec jc  et un Inset[] est utile pour ajouter automatiquement des composants au tableau où on le souhaite 
		gc.gridx,gridy,gridwidth,gridheigth,ipadx,ipady,anchor,fill ; ici seulement gridx, gridy et anchor */
	private final static int[][] GBC = {{0,0,GLE},{1,0,GLA},{0,1,GLE},{1,1,GLA},{0,2,GLE},
										{1,2,GLA},{0,3,GLE},{1,3,GLA},{0,4,GLE},{1,4,GLA},
										{0,5,GLE},{1,5,GLA},{0,6,GLE},{1,6,GCENT},{2,6,GCENT},{1,7,GLFA}};
	private final static String[] AGE = {"Under 18","18 to 64","65 or over"};
	private final JComponent[] jc; 
	private final static String[] JOB = {"Unemployed", "Employed", "Self-employed"};
	
	
	public JForm() 
	{
		Dimension dim = this.getPreferredSize();
		dim.width=250;
		this.setPreferredSize(dim);
		setLayout(new GridBagLayout());
		
		name = new JLabel("Name : ");
		occupation = new JLabel("Occupation : ");
		citizen = new JLabel("US Citizen : ");
		taxID = new JLabel("TAXID : ");
		lage = new JLabel("Age : ");
		ljob = new JLabel("Employment : ");
		lgender = new JLabel("Gender : ");
		
		tname = new JTextField(10);
		toccupation = new JTextField(10);
		textID = new JTextField(10);
		
		ok = new JButton("OK");
		jlist = new JList(AGE);
		jcb = new JComboBox(JOB);
		jcb0 = new JCheckBox();
		jrm = new JRadioButton("Male");
		jrf = new JRadioButton("Female");
		genderGroup = new ButtonGroup(); genderGroup.add(jrm); genderGroup.add(jrf);
		jrm.setSelected(true);
		jsp = new JScrollPane(jlist);
		
		jlist.setPreferredSize(new Dimension(100,60));
		jlist.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		jlist.setSelectedIndex(1);
		jcb.setEditable(false);
		taxID.setEnabled(false);
		textID.setEnabled(false);
		jrm.setActionCommand("male");
		jrf.setActionCommand("female");
		ok.setMnemonic('o');
	
		jc = new JComponent[]{name,tname,occupation,toccupation,
		lage,jlist,ljob,jcb,citizen,jcb0,taxID,textID,lgender,jrm,jrf,ok};
	
		Border inner = BorderFactory.createTitledBorder("Add person");
		Border outer = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(inner, outer));
		
		ok.addActionListener(new ActionListener(){ //ajout d'un ecouteur d'evenement sur le bouton ok
			public void actionPerformed(ActionEvent ae) 
			{
				String gtname = tname.getText(); //recuperation du texte des JTextField
				String gtoccupation = toccupation.getText();
				String gtjlist = (String)jlist.getSelectedValue();
				String gtjcb = (String)jcb.getSelectedItem();
  				String gttID = (String)textID.getText();
				String gender = genderGroup.getSelection().getActionCommand();
				Boolean isUsCit = jcb0.isSelected();
				
				tname.setText(null);
				toccupation.setText(null);
				jlist.setSelectedIndex(1);
				jcb.setSelectedItem(null);
				textID.setText(null);
				jcb0.setSelected(false);
				
				FormEvent ev = new FormEvent(ae,gtname,gtoccupation,gtjlist, gtjcb,isUsCit,gttID,gender); //Transfert des données à la JFrame
				
				if(formlisten != null)
					formlisten.FormEventOccured(ev); //Execute l'action dans MyFen
			}});
		jcb0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				boolean isTicked = jcb0.isSelected();
				taxID.setEnabled(isTicked);
				textID.setEnabled(isTicked);
				if(!isTicked && !(textID.getText().equals("")))
					textID.setText("");
			}});
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		for(int i=0;i<GBC.length;i++)
		{
			if(i==GBC.length-1)
				gc.weighty=1;
			if(i==0)
			{
				gc.insets=new Insets(0,0,0,5);
				gc.weighty=0.1;
			}
			gc.gridx=GBC[i][0];
			gc.gridy=GBC[i][1];
			gc.anchor=GBC[i][2];
			gc.insets=new Insets(0,0,0,0);
			this.add( jc[i], gc );	
		}
	}
	public void setFormListener(FormListener fl)
	{
		this.formlisten=fl;
	}
}    


