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

import Clinique_Auto.Connexion;




public class Ieffectif extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connexion cn=new Connexion(serveur, bd, user, pass);
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbeff_id,lbnom,lbprenom,lbdateNaissance,lbtitre;
	JTextField tfeff_id,tfnom,tfprenom, tfdateNaissance;
	JButton badd,bsup;
	public Ieffectif(){
		this.setTitle("----CLINIQUE AUTONUME----");
		this.setSize(553,500);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(102,54,200));
		add(pn);
		lbtitre=new JLabel("Enregistrer un Effectif");
		lbtitre.setBounds(30,10,400,30);
		lbtitre.setFont(new Font("Arial",Font.BOLD,20));
		pn.add(lbtitre);

		//label nom
		lbnom=new JLabel("Nom");
		lbnom.setBounds(40,50,110,25);
		lbnom.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbnom);

		//textfield nom 
		tfnom=new JTextField();
		tfnom.setBounds(190,50,100,25);
		pn.add(tfnom);

		//label prenom
				lbprenom=new JLabel("Prenom");
				lbprenom.setBounds(40,50,140,25);
				lbprenom.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbprenom);

     	//textfield prenom
				tfprenom=new JTextField();
				tfprenom.setBounds(190,50,100,25);
				pn.add(tfprenom);

		//label DateN
				lbdateNaissance=new JLabel("dateNaissance");
				lbdateNaissance.setBounds(40,50,140,25);
				lbdateNaissance.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbdateNaissance);

		//textfield dateNaissance
				tfdateNaissance=new JTextField();
				tfdateNaissance.setBounds(190,50,100,25);
				pn.add(tfdateNaissance);
		
		//bouton ajout chambre
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tfnom.getText(),b=tfprenom.getText(),c=tfdateNaissance.getText();
 String sql="insert into effectif(nom, prenom, dateNaissance) values('"+a+"','"+b+"','"+c+"')";

                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"Effectif bien ajouter !");
                	   dispose();
                	   Ieffectif ef=new Ieffectif();
                	   ef.setVisible(true);
                   }
                   catch(SQLException ex){
                	 JOptionPane.showMessageDialog(null,"Impossible d'ajouter !",null,JOptionPane.ERROR_MESSAGE);  
                   }
						
					}
				});
				pn.add(badd);
				
		//bouton supprimer un effectif
							bsup=new JButton("Supprimer");
							bsup.setBounds(190,150,100,25);
							bsup.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									String a=tfeff_id.getText();
			 String sql="Delete from effectif where ID ='"+a+"'";
			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   Ieffectif ef=new Ieffectif();
			                	   ef.setVisible(true);
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

