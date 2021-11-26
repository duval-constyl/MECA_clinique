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




public class IPrevision extends JFrame {
	Connexion cn=new Connexion();
	Statement st;
	ResultSet rst;
	JTable tb1;
	JScrollPane scrl1;
	JLabel lbprevison_id,lbprevision_date,lbeffectif,lbunite,lbtype_act,lbquantite,lbperiode_debut,lbperiode_fin,lbtitre;
	JTextField tfprevison_id,tfprevision_date,tfeffectif,tfunite,tftype_act,tfquantite,tfperiode_debut,tfperiode_fin;
	JButton badd,bsup,bupd;
	public IPrevision(){
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

		//label prevision_date
				lbprevision_date=new JLabel("Prevision_date");
				lbprevision_date.setBounds(40,50,140,25);
				lbprevision_date.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbprevision_date);

     	//textfield prevision_date
				tfprevision_date=new JTextField();
				tfprevision_date.setBounds(190,50,100,25);
				pn.add(tfprevision_date);


		//label effectif
		lbeffectif=new JLabel("Effectif");
		lbeffectif.setBounds(40,50,110,25);
		lbeffectif.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbeffectif);

		//textfield effectif 
		tfeffectif=new JTextField();
		tfeffectif.setBounds(190,50,100,25);
		pn.add(tfeffectif);


		//label unite
		lbunite=new JLabel("Unite");
		lbunite.setBounds(40,50,110,25);
		lbunite.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbunite);

		//textfield unite 
		tfunite=new JTextField();
		tfunite.setBounds(190,50,100,25);
		pn.add(tfunite);


		//label type_act
		lbtype_act=new JLabel("Type_activite");
		lbtype_act.setBounds(40,50,110,25);
		lbtype_act.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbtype_act);

		//textfield type_act 
		tftype_act=new JTextField();
		tftype_act.setBounds(190,50,100,25);
		pn.add(tftype_act);

		//label Quantite
		lbquantite=new JLabel("Quantite");
		lbquantite.setBounds(40,50,110,25);
		lbquantite.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(lbquantite);

		//textfield quantite 
		tfquantite=new JTextField();
		tfquantite.setBounds(190,50,100,25);
		pn.add(tfquantite);



		//label PERIODE_debut
				lbperiode_debut=new JLabel("Periode_debut");
				lbperiode_debut.setBounds(40,50,140,25);
				lbperiode_debut.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbperiode_debut);

     	//textfield periode_debut
				tfperiode_debut=new JTextField();
				tfperiode_debut.setBounds(190,50,100,25);
				pn.add(tfperiode_debut);

		//label periode_fin
				lbperiode_fin=new JLabel("Periode_fin");
				lbperiode_fin.setBounds(40,50,140,25);
				lbperiode_fin.setFont(new Font("Arial",Font.BOLD,16));
				pn.add(lbperiode_fin);

		//textfield Periode_fin
				tfperiode_fin=new JTextField();
				tfperiode_fin.setBounds(190,50,100,25);
				pn.add(tfperiode_fin);
		
		//bouton ajouter POUR un Permis
				badd=new JButton("Ajouter");
				badd.setBounds(40,150,100,25);
				badd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						String a=tfprevision_date.getText(),b=tfeffectif.getText(),c=tfunite.getText(),d=tftype_act.getText(),h=tfquantite.getText(),f=tfperiode_debut.getText(),g=tfperiode_fin.getText();
 String sql="insert into Permis(prevision_date, effectif, unite, type_act, quantite, periode_debut, periode_fin) values('"+a+"','"+b+"','"+c+"','"+d+"','"+h+"','"+f+"','"+g+"')";

                   try{
                	   st=cn.laconnexion().createStatement();
                	   st.executeUpdate(sql);
                	   JOptionPane.showMessageDialog(null,"Prevision bien ajouter !");
                	   dispose();
                	   IPrevision pre=new IPrevision();
                	   pre.setVisible(true);
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
									String a=tfeffectif.getText();
			 String sql="delete from prevision where prevision_id='"+a+"'";
			                   try{
			                	   st=cn.laconnexion().createStatement();
			  if( JOptionPane.showConfirmDialog(null,"Voulez-vous supprimer?",null,JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				  st.executeUpdate(sql);
           	   JOptionPane.showMessageDialog(null,"Suppréssion réussi !");
			  }
			                	  
			                	   dispose();
			                	   IPrevision pre=new IPrevision();
			                	   pre.setVisible(true);
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
				                	   IPrevision pre=new IPrevision();
				                	   pre.setVisible(true);
									
								}
							});
							pn.add(bupd);
		////
							DefaultTableModel df=new DefaultTableModel();
							init();
							df.addColumn("Prevision_id");
							df.addColumn("Prevision_date");
							df.addColumn("effectif");
							df.addColumn("unite");
							df.addColumn("type_act");
							df.addColumn("quantite");
							df.addColumn("periode_debut");
							df.addColumn("periode_fin");
							tb1.setModel(df);
							pn.add(scrl1);
							
							String sql="select prevision_id, prevision_date, effectif, unite, type_act, quantite, periode_debut, periode_fin from permis";
							
						 cn=new Connexion();
							try{
								st=cn.laconnexion().createStatement();
								rst=st.executeQuery(sql);
								while(rst.next()){
							df.addRow(new Object[]{
									rst.getString("prevision_id"),
									rst.getInt("prevision_date"),
									rst.getInt("effectif"),
									rst.getInt("unite"),
									rst.getInt("type_act"),
									rst.getInt("quantite"),
									rst.getDate("periode_debut"),
									rst.getDate("periode_fin")
									
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


