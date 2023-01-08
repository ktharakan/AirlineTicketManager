import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteCustomer extends MainFrame implements KeyListener{//a lot of these comments are the same across all classes - check display and add classes for full documentation on old parts
	private JFrame deleteFrame = new JFrame("Delete Customer");
	private JTextField[] txtInputs = new JTextField[2];//textfields for inputs
	private JButton btnDelete;
	CustomerDataBase cd;
	private JFrame mainFrame;
	
	public DeleteCustomer (CustomerDataBase cd, JFrame mainFrame) {
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(190,115, 70,40);
		btnDelete.addActionListener(this);
		
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
		deleteFrame.setContentPane(panel);
		deleteFrame.setVisible(true);
		deleteFrame.setResizable(false);
		deleteFrame.setBounds(100, 100, 300, 200);
		deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		panel.add(btnDelete);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		boolean invalidInput = false;
		for (int i = 0; i < 2; i++) {//checks for invalid inputs
			
			txtInputs[i].getText();//checks for invalid inputs
			
			if(txtInputs[i].getText() == null || txtInputs[i].getText().equals("") ) {
				txtInputs[i].setBackground(Color.red);
				invalidInput = true;
			}
		}
		if (!invalidInput) {
			cd.deleteCustomerInfo(txtInputs[0].getText(), txtInputs[1].getText());//calls the delete customer info method
			deleteFrame.dispose();
			mainFrame.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(deleteFrame, "Invalid Input");//if user does not fill out all sections it will display invalid input
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
