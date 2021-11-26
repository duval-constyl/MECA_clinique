package Clinique_Auto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interface extends JFrame {


	JButton beff,bpermis,bper_act,btype_act,bunite,bsorg,bprev;
	JLabel lbtitre;
	JFrame frame;
	public Interface(){
		
		
		this.setTitle("----CLINIQUE AUTONUME----");
		this.setSize(1500,750);
		this.setLocationRelativeTo(null);
		JPanel pnl = new JPanel();
		lbtitre=new JLabel("GESTION DES DONNEES DE LA CLINIQUE");
		lbtitre.setBounds(550,100,450,30);
		
		lbtitre.setFont(new Font("Arial",Font.BOLD,18));
		pnl.add(lbtitre);
		pnl.setLayout(null);
		add(pnl);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(90, 250, 150, 256);
		frame.getContentPane().add(label);
		
		
		//Bouton ramenant à la fenêtre relative à l'effectif
		
		beff=new JButton("Effectif");
		beff.setBounds(40,250,100,25);
		pnl.add(beff);
		
		//Bouton ramenant à la fenêtre permis
		
		bpermis=new JButton("Permis");
		bpermis.setBounds(190,250,100,25);
		pnl.add(bpermis);
		
		//Bouton ramenant à la fenêtre permis_activite
		
		bper_act=new JButton("Permis d'activité");
		bper_act.setBounds(350, 250, 100, 25);
		pnl.add(bper_act);
		
		//Bouton ramenant à la fenêtre Type_activite
		
		btype_act=new JButton("Type d'activité");
		btype_act.setBounds(550, 250, 100, 25);
		pnl.add(btype_act);
		
		//Bouton ramenant à la fenêtre unite
		
		bunite=new JButton("Unité");
		bunite.setBounds(750, 250, 100, 25);
		pnl.add(bunite);
		
		//Bouton ramenant à la fenêtre sorg
		
		bsorg= new JButton("Structure organisationelle");
		bsorg.setBounds(900, 250, 100, 25);
		pnl.add(bsorg);
		
		//Bouton ramenant à la fenêtre prévision
		
		bprev=new JButton("Prévision");
		bprev.setBounds(1050, 250, 100, 25);
		pnl.add(bprev);
		
	}
	
	
public static void main(String[] args) {
		
		Interface test=new Interface();
		test.setVisible(true);		

	}




}

