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




public class IPermis extends JFrame {
	
	Connexion cn=new Connexion();
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbpermis_id,lbpermis_code,lbeffectif,lbvalide_debut,lbvalide_fin,lbtitre;
	JTextField tfpermis_id,tfpermis_code,tfeffectif,tfvalide_debut,tfvalide_fin;
	JButton badd,bsup,bupd;
	public IPermis(){
		this.setTitle("----CLINIQUE AUTONUME----");
		this.setSize(553,500);
		this.setLocationRelativeTo(null);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(new Color(102,54,200));
		add(pn);
		lbtitre=new JLabel("Enregistrer un Permis");
		lbtitre.setBounds(30,10,400,30);
		lbtitre.setFont(new Font("Arial",Font.BOLD,20));
		pn.add(lbtitre);

		//label permis_code
				lbpermis_code=new JLabel("Permis_code");
				lbpermis_code.setBounds(40,50,140,25);
				lbpermis_code.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbpermis_code);

     	//textfield permis_code
				tfpermis_code=new JTextField();
				tfpermis_code.setBounds(190,50,100,25);
				pn.add(tfpermis_code);


		//label effectif
		lbeffectif=new JLabel("Effectif");
		lbeffectif.setBounds(40,50,110,25);
		lbeffectif.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbeffectif);

		//textfield effectif 
		tfeffectif=new JTextField();
		tfeffectif.setBounds(190,50,100,25);
		pn.add(tfeffectif);


		//label valide_debut
				lbvalide_debut=new JLabel("Valide_debut");
				lbvalide_debut.setBounds(40,50,140,25);
				lbvalide_debut.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbvalide_debut);

     	//textfield valide_debut
				tfvalide_debut=new JTextField();
				tfvalide_debut.setBounds(190,50,100,25);
				pn.add(tfvalide_debut);

		//label valide_fin
				lbvalide_fin=new JLabel("Valide_fin");
				lbvalide_fin.setBounds(40,50,140,25);
				lbvalide_fin.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbvalide_fin);

		//textfield valide_fin
				tfvalide_fin=new JTextField();
				tfvalide_fin.setBounds(190,50,100,25);
				pn.add(tfvalide_fin);
		
		//bouton ajouter POUR un Permis
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tfpermis_code.getText(),b=tfeffectif.getText(),c=tfvalide_debut.getText(), d=tfvalide_fin.getText();
 String sql="insert into Permis(permis_code, effectif, valide_debut, valide_fin) values('"+a+"','"+b+"','"+c+"','"+d+"')";

                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"Permis bien ajouter !");
                	   dispose();
                	   IPermis per=new IPermis();
                	   per.setVisible(true);
                   }
                   catch(SQLException ex){
                	 JOptionPane.showMessageDialog(null,"Impossible d'ajouter !",null,JOptionPane.ERROR_MESSAGE);  
                   }
						
					}
				});
				pn.add(badd);
				
		//bouton supprimer pour un permis
							bsup=new JButton("Supprimer");
							bsup.setBounds(190,150,100,25);
							bsup.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									String a=tfpermis_id.getText();
			 String sql="delete from permis where permis_id='"+a+"'";
			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   IPermis per=new IPermis();
			                	   per.setVisible(true);
			                   }
			                   catch(SQLException ex){
			                	 JOptionPane.showMessageDialog(null,"Impossible de supprimer !",null,JOptionPane.ERROR_MESSAGE);  
			                   }
									
								}
							});
							pn.add(bsup);

				///aller à l'interface de update d'un permis
							JButton bupd=new JButton("UPDATE");
							bupd.setBounds(360,10,120,30);
							bupd.addActionListener(new ActionListener(){
								public void actionPerformed(ActionEvent e){
									dispose();
									IPermis per=new IPermis();
				                	   per.setVisible(true);
									
								}
							});
							pn.add(bupd);
		////
							DefaultTableModel df=new DefaultTableModel();
							init();
							df.addColumn("Permis_id");
							df.addColumn("Permis_code");
							df.addColumn("effectif");
							df.addColumn("valide_debut");
							df.addColumn("valide_fin");
							tb1.setModel(df);
							pn.add(scrl1);
							
							String sql="select permis_code, effectif, valide_debut, valide_fin from permis";
							
						 cn=new Connexion();
							try{
								st=cn.laconnexion().createStatement();
								rst=st.executeQuery(sql);
								while(rst.next()){
							df.addRow(new Object[]{
									rst.getString("permis_code"),
									rst.getInt("effectif"),
									rst.getDate("valide_debut"),
									rst.getDate("valide_fin")
									
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


