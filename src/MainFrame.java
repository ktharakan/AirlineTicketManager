import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public  abstract class MainFrame implements ActionListener {
	protected JButton btnAdd, btnDelete, btnSort, btnGet, btnDisplay;//protected variables to allow full access
	//private JLabel lblTitle, lblCredits; put in add panel method
	
	public MainFrame() {//constructor to make buttons
		btnAdd = makeButton(130,270, "Add");
		btnDelete = makeButton(250, 270, "Delete");
		btnSort = makeButton (190,320,"Sort");
		btnGet = makeButton(130,370,"Specific");
		btnDisplay = makeButton(250,370, "Display");
		
	}
	public JButton makeButton(int x, int y, String text) {//make button method
		JButton btn = new JButton(text);
		btn.setBounds(x, y, 90, 50);
		btn.addActionListener(this);//add action listener
		return btn;//returns JButton
	}
	public JLabel makeLabel(int x, int y, int xSize, int ySize,String text) {//make JLabel method
		JLabel lbl = new JLabel(text);
		lbl.setBounds(x,y, xSize, ySize);
		lbl.setOpaque(false);
		
		lbl.setForeground(Color.BLACK);
		
		return lbl;
	}
	public void addComponents(JPanel panel) {//add componnets
		JLabel lblTitle = makeLabel(2,2, 600,25, "Tharakan's Travel Agency");
		Font FontTitle = new Font ("Arial",Font.BOLD,30);//new font
		lblTitle.setFont(FontTitle);
		
		JLabel lblCredits = makeLabel(2,450,200,25, "Made by: Kevin Tharakan");//lbl credits
		Font FontCredits = new Font ("Arial",Font.BOLD,30);
		lblTitle.setFont(FontCredits);
		
		JLabel lblImage = new JLabel();//making and adding the img to the panel
		ImageIcon img = new ImageIcon("CPTPlane.gif");
		
		lblImage.setIcon(img);
		lblImage.setBounds(5, 60, 500, 200);
		panel.add(lblImage);
		
		//add to panel
		panel.add(btnAdd);
		panel.add(btnDelete);
		panel.add(btnSort);
		panel.add(btnGet);
		panel.add(btnDisplay);
		panel.add(lblTitle);
		panel.add(lblCredits);
		
	}
	
	
	
	

}
