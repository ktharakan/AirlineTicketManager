import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SpecificCustomer extends MainFrame implements KeyListener{//a lot of these comments are the same across all classes - check display and add classes for full documentation on old parts
	private JFrame specificCustomer = new JFrame("Specific Customer");
	private JTextField[] txtInputs = new JTextField[2];//textfields for inputs
	private JButton btnFind, btnExit;
	CustomerDataBase cd;
	private JFrame mainFrame;
	private JTextArea myArea;//attribute so all methods can access myarea
	
	public SpecificCustomer (CustomerDataBase cd, JFrame mainFrame) {
		btnFind = new JButton("Find");
		btnFind.setBounds(200,115, 70,40);
		btnFind.addActionListener(this);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(110,115, 70,40);
		btnExit.addActionListener(this);
		
		for(int i=0; i<txtInputs.length; i++) {
			txtInputs[i] = new JTextField();
			txtInputs[i].setBounds(140,50 + 35 * i, 100, 25);
			txtInputs[i].addKeyListener(this);//add key listener
			txtInputs[i].setHorizontalAlignment(JTextField.CENTER);
		}
		this.cd = cd;
		this.mainFrame = mainFrame;
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		addComponents(panel);
		
		
		specificCustomer.setContentPane(panel);
		myArea = new JTextArea();
		myArea.setEditable(false);
		JScrollPane sp = new JScrollPane(myArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);//creates scroll bar
		sp.setBounds(300, 50, 300, 100);
		panel.add(sp);//adds scroll bar to panel
		specificCustomer.setVisible(true);
		specificCustomer.setResizable(false);
		specificCustomer.setBounds(100, 100, 750, 200);
		specificCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addComponents(JPanel panel) {
		JLabel[] lblTextFieldTitles = new JLabel[2];
		String[] lblTextFieldTitle = {"First Name:", "Last Name:"};
		
		for(int k=0; k<lblTextFieldTitles.length; k++) {
			lblTextFieldTitles[k] = new JLabel(lblTextFieldTitle[k]);
			lblTextFieldTitles[k].setBounds(10,50 + 35 * k,100,25);
			panel.add(lblTextFieldTitles[k]);
			
		}
		
		for(int j=0; j<txtInputs.length; j++) {
			panel.add(txtInputs[j]);
		}
		
		JLabel lblMainTitle = new JLabel("Please fill out the following categories");
		lblMainTitle.setBounds(10,20,250,20);
		panel.add(lblMainTitle);
		
		panel.add(btnFind);
		panel.add(btnExit);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==btnFind) {
			boolean invalidInput = false;
			for (int i = 0; i < 2; i++) {//checks for invalid inpuits
				
				txtInputs[i].getText();
				
				if(txtInputs[i].getText() == null || txtInputs[i].getText().equals("") ) {
					txtInputs[i].setBackground(Color.red);
					invalidInput = true;
				}
			}
			if (!invalidInput) {
				cd.getCustomerInfo(txtInputs[0].getText(), txtInputs[1].getText(), myArea);//calls getCustmerInfo method
				
				
			}
			else {
				JOptionPane.showMessageDialog(specificCustomer, "Invalid Input");
			}
		}
		else {
			specificCustomer.dispose();
			mainFrame.setVisible(true);
		}
		
			
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<2;i++) {
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
