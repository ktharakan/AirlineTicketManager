import java.awt.event.ActionEvent;

import javax.swing.*;

public class DisplayFrame extends MainFrame {
	private JFrame displayFrame = new JFrame("Display");//creates display frame
	private JButton btnOk;
	private CustomerDataBase cd;//adding attriubutes so whole class will have access
	private JFrame mainFrame;
	public DisplayFrame(CustomerDataBase cd, JFrame mainFrame) {//pass these two objects so that the class can use the object created in the main class and set the mainFrame to visible
		this.cd=cd;
		this.mainFrame = mainFrame;
		btnOk = new JButton("Ok");//creats ok button
		btnOk.setBounds(10,270, 50,40);
		btnOk.addActionListener(this);
		
		//creates and sets up panel and frame
		JPanel panel = new JPanel();
		panel.setLayout(null);
		addComponents(panel);
		displayFrame.setContentPane(panel);
		displayFrame.setVisible(true);
		displayFrame.setResizable(false);
		displayFrame.setBounds(10, 100, 600, 420);
		displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void addComponents(JPanel panel) {
		// adds components
		//creats jtextArea and scroll bar
		JTextArea myArea = new JTextArea();
		myArea.setEditable(false);
		JScrollPane sp = new JScrollPane(myArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    cd.displayArray(myArea);//calls display method
	    
	    sp.setBounds(10,50,500,200);
		panel.add(sp);
		
		JLabel lblTitle = new JLabel("Display Customer Information");//creates lable title
		lblTitle.setBounds(10,10,300,50);
		panel.add(lblTitle);
		panel.add(btnOk);		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		displayFrame.dispose();//gets rid of this class
		mainFrame.setVisible(true);//sets mainFrame as visible again
		
	}
}
