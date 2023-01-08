import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class AddCustomerFrame extends MainFrame implements KeyListener{//extends from the main frame and implements keylistener
	private JFrame addFrame = new JFrame("Add Customer");//frame for this calss
	private JTextField[] txtInputs = new JTextField[8];//textfields for inputs
	private JButton btnGo;//go button
	//adding attriubutes so whole class will have access
	CustomerDataBase cd;
	
	private JFrame mainFrame;
	
	public AddCustomerFrame(CustomerDataBase cd, JFrame mainFrame) {//pass these two objects so that the class can use the object created in the main class and set the mainFrame to visible
				
		for(int i=0; i<txtInputs.length; i++) {//creates text fields
			txtInputs[i] = new JTextField();
			txtInputs[i].setBounds(140,50 + 35 * i, 100, 25);
			txtInputs[i].addKeyListener(this);//add key listener
			txtInputs[i].setHorizontalAlignment(JTextField.CENTER);
		}
		this.cd = cd;
		this.mainFrame = mainFrame;
		
		//creates button
		btnGo = new JButton("Go");
		btnGo.setBounds(190,330, 50,40);
		btnGo.addActionListener(this);
		
		//creates and sets up panels and frame
		JPanel panel = new JPanel();
		panel.setLayout(null);
		addComponents(panel);
		addFrame.setContentPane(panel);
		addFrame.setVisible(true);
		addFrame.setResizable(false);
		addFrame.setBounds(100, 100, 300, 420);
		addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addComponents(JPanel panel) {
		//add components to panel
		for(int j=0; j<txtInputs.length; j++) {
			panel.add(txtInputs[j]);
		}
		
		//creates textfield titles
		JLabel[] lblTextFieldTitles = new JLabel[8];
		String[] lblTextFieldTitle = {"First Name:", "Last Name:", "Address:", "City:", "Postal Code:", "Telephone #:","Age", "Income:"};
		
		for(int k=0; k<lblTextFieldTitles.length; k++) {
			lblTextFieldTitles[k] = new JLabel(lblTextFieldTitle[k]);
			lblTextFieldTitles[k].setBounds(10,50 + 35 * k,100,25);
			panel.add(lblTextFieldTitles[k]);
			
		}
		
		JLabel lblMainTitle = new JLabel("Please fill out the following categories");
		lblMainTitle.setBounds(10,20,250,20);
		
		panel.add(lblMainTitle);
		
		panel.add(btnGo);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		boolean invalidInput = false;//checks if user has inputed in all text fields
				for (int i = 0; i < 6; i++) {
					
					txtInputs[i].getText();
					
					if(txtInputs[i].getText() == null || txtInputs[i].getText().equals("") ) {
						txtInputs[i].setBackground(Color.red);
						invalidInput = true;
					}
				}//end of for loop
				for (int k = 6; k < 8; k++) {
					try {
						Integer.parseInt(txtInputs[k].getText());
					}
					catch(NumberFormatException er) {
						txtInputs[k].setBackground(Color.red);
						invalidInput = true;
					}
					
				}//end of for loop
				if (!invalidInput) {//calls on addcustomerinfo
					cd.addCustomerInfo(txtInputs[0].getText(), txtInputs[1].getText(), txtInputs[2].getText(), txtInputs[3].getText(), txtInputs[4].getText(), txtInputs[5].getText(), Integer.parseInt(txtInputs[6].getText()), Integer.parseInt(txtInputs[7].getText()));
					addFrame.dispose();;//gets rid of this class
					mainFrame.setVisible(true);//sets main frame as visible again
				}
				else {
					JOptionPane.showMessageDialog(addFrame, "Invalid Input");
				}
			
			
				
				
				
				
		
			
	}
		
		
		
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<8;i++) {
			if(e.getSource()==txtInputs[i]) {
				txtInputs[i].setBackground(null);//make sure red background is removed
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
