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




public class IType_act extends JFrame {
	Connexion cn=new Connexion();
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbtype,lbnom,lbdescription,lbactif,lbtitre;
	JTextField tftype,tfnom,tfdescription, tfactif;
	JButton badd,bsup,bupd;
	public IType_act(){
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

		//label type
				lbtype=new JLabel("Type_code");
				lbtype.setBounds(40,50,140,25);
				lbtype.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbtype);

     	//textfield type
				tftype=new JTextField();
				tftype.setBounds(190,50,100,25);
				pn.add(tftype);


		//label nom
		lbnom=new JLabel("Nom");
		lbnom.setBounds(40,50,110,25);
		lbnom.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbnom);

		//textfield nom 
		tfnom=new JTextField();
		tfnom.setBounds(190,50,100,25);
		pn.add(tfnom);


		//label Description
				lbdescription=new JLabel("Description");
				lbdescription.setBounds(40,50,140,25);
				lbdescription.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbdescription);

     	//textfield Description
				tfdescription=new JTextField();
				tfdescription.setBounds(190,50,100,25);
				pn.add(tfdescription);

		//label Actif
				lbactif=new JLabel("Actif");
				lbactif.setBounds(40,50,140,25);
				lbactif.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbactif);

		//textfield Actif
				tfactif=new JTextField();
				tfactif.setBounds(190,50,100,25);
				pn.add(tfactif);
		
		//bouton ajouter pour type_activite
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tftype.getText(),b=tfnom.getText(),c=tfdescription.getText(), d=tfactif.getText();
 String sql="insert into Type_act(nom, prenom, dateNaissance) values('"+a+"','"+b+"','"+c+"','"+d+"')";

                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"Type activite bien ajouter !");
                	   dispose();
                	   IType_act typ=new IType_act();
                	   typ.setVisible(true);
                   }
                   catch(SQLException ex){
                	 JOptionPane.showMessageDialog(null,"Impossible d'ajouter !",null,JOptionPane.ERROR_MESSAGE);  
                   }
						
					}
				});
				pn.add(badd);
				
		//bouton supprimer un type_act
							bsup=new JButton("Supprimer");
							bsup.setBounds(190,150,100,25);
							bsup.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									String a=tftype.getText();
			 String sql="delete from effectif where ID ='"+a+"'";
			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   IType_act typ=new IType_act();
			                	   typ.setVisible(true);
			                   }
			                   catch(SQLException ex){
			                	 JOptionPane.showMessageDialog(null,"Impossible de supprimer !",null,JOptionPane.ERROR_MESSAGE);  
			                   }
									
								}
							});
							pn.add(bsup);
							
			//bouton pour update un type_activite
							
							///aller à l'interface de update d'un type_act
												JButton bupd=new JButton("UPDATE");
												bupd.setBounds(360,10,120,30);
												bupd.addActionListener(new ActionListener(){
													public void actionPerformed(ActionEvent e){
														 dispose();
									                	   IType_act typ=new IType_act();
									                	   typ.setVisible(true);
														
													}
												});
												pn.add(bupd);
							////
												DefaultTableModel df=new DefaultTableModel();
												init();
												df.addColumn("Type");
												df.addColumn("Nom");
												df.addColumn("Description");
												df.addColumn("Actif");
												tb1.setModel(df);
												pn.add(scrl1);
												//String sql="select * from vente where datediff(datev,now())=0";
												String sql="select type,nom,description,actif from type_activite";
												
											 cn=new Connectage();
												try{
													st=cn.laconnexion().createStatement();
													rst=st.executeQuery(sql);
													while(rst.next()){
												df.addRow(new Object[]{
														rst.getString("type"),
														rst.getString("nom"),
														rst.getString("description"),
														rst.getString("actif")
														
												});
													}
												}
												catch(SQLException ex){
													
												}
						}
							
							
	
	private void init(){
		tb1=new JTable();
		scrl1=new JScrollPane();
		scrl1.setViewportView(tb1);
		scrl1.setBounds(20,210,500,230);
	}


}

