package Clinique_Auto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class ISOrg extends JFrame {
	Connexion cn=new Connexion();
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbunite,lbsuper_unite,lbtitre;
	JTextField tfunite,tfsuper_unite;
	JButton badd,bsup;
	
	public ISOrg(){
		this.setTitle("----CLINIQUE AUTONUME----");
		this.setSize(553,500);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(102,54,200));
		add(pn);
		lbtitre=new JLabel("Enregistrement des Structure Organisationnelle");
		lbtitre.setBounds(30,10,400,30);
		lbtitre.setFont(new Font("Arial",Font.BOLD,20));
		pn.add(lbtitre);

		//label unite
		lbunite=new JLabel("Nom de unite ");
		lbunite.setBounds(40,50,110,25);
		lbunite.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbunite);

		//textfield unite
		tfunite=new JTextField();
		tfunite.setBounds(190,50,100,25);
		pn.add(tfunite);

		//label super_unite
				lbsuper_unite=new JLabel("super_unite");
				lbsuper_unite.setBounds(40,90,140,25);
				lbsuper_unite.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbsuper_unite);
     		//textfield super_unite
				tfsuper_unite=new JTextField();
				tfsuper_unite.setBounds(190,90,100,25);
				pn.add(tfsuper_unite);

	//bouton ajout pour unite
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tfunite.getText(),b=tfsuper_unite.getText();
 String sql="insert into unite(unite, super_unite) values('"+a+"','"+b+"')";
                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"SOrg bien ajouter !");
                	   dispose();
                	   ISOrg sorg=new ISOrg();
                	   sorg.setVisible(true);
                   }
                   catch(SQLException ex){
                	 JOptionPane.showMessageDialog(null,"Impossible d'ajouter !",null,JOptionPane.ERROR_MESSAGE);  
                   }
						
					}
				});
				pn.add(badd);
				
	//bouton supprimer chambre
							bsup=new JButton("Supprimer");
							bsup.setBounds(190,150,100,25);
							bsup.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									String a=tfunite.getText();
			 String sql="Delete from unite where unite='"+a+"'";

			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   ISOrg sorg=new ISOrg();
			                	   sorg.setVisible(true);
			                   }
			                   catch(SQLException ex){
			                	 JOptionPane.showMessageDialog(null,"Impossible de supprimer !",null,JOptionPane.ERROR_MESSAGE);  
			                   }
									
								}
							});
							pn.add(bsup);
							
							
							
	}
	private void init(){
		tb1=new JTable();
		scrl1=new JScrollPane();
		scrl1.setViewportView(tb1);
		scrl1.setBounds(20,210,500,230);
	}

	

}


