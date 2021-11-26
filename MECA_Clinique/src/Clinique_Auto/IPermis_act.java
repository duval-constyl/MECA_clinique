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




public class IPermis_act extends JFrame {
	Connexion cn=new Connexion();
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbpermis,lbtype,lbtitre;
	JTextField tfpermis,tftype;
	JButton badd,bsup;
	public IPermis_act(){
		this.setTitle("----CLINIQUE AUTONUME----");
		this.setSize(553,500);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(102,54,200));
		add(pn);
		lbtitre=new JLabel("Enregistrement des Permis_Activites");
		lbtitre.setBounds(30,10,400,30);
		lbtitre.setFont(new Font("Arial",Font.BOLD,20));
		pn.add(lbtitre);

		//label permis
		lbpermis=new JLabel("Permis");
		lbpermis.setBounds(40,50,110,25);
		lbpermis.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbpermis);

		//textfield permis
		tfpermis=new JTextField();
		tfpermis.setBounds(190,50,100,25);
		pn.add(tfpermis);

		//label type
				lbtype=new JLabel("Type_code");
				lbtype.setBounds(40,90,140,25);
				lbtype.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbtype);
     		//textfield type
				tftype=new JTextField();
				tftype.setBounds(190,90,100,25);
				pn.add(tftype);

	//bouton ajout pour un type_activite
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tfpermis.getText(),b=tftype.getText();
 String sql="insert into permis_act(permis, type) values('"+a+"','"+b+"')";
                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"Permis d'activite bien ajouter !");
                	   dispose();
                	   IPermis_act act=new IPermis_act();
                	   act.setVisible(true);
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
									String a=tfpermis.getText();
			 String sql="Delete from permis activite where permis='"+a+"'";

			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   IPermis_act act=new IPermis_act();
			                	   act.setVisible(true);
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

