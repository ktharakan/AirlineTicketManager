import java.awt.event.ActionEvent;

import javax.swing.*;

public class SortSelection extends MainFrame{
	private JButton[] btnSortTypes = new JButton[2];
	private JButton btnExit;
	private CustomerDataBase cd;
	private JFrame mainFrame;
	private JFrame sortingFrame = new JFrame ("Sorting");
	private JTextArea myArea;//sets myArea as attribute so all methods have access
	
	public SortSelection (CustomerDataBase cd, JFrame mainFrame) {//a lot of these comments are the same across all classes - check display and add classes for full documentation on old parts
		this.cd=cd;
		this.mainFrame = mainFrame;
		
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		sortingFrame.setContentPane(panel);
		
		JLabel lblTitle = new JLabel("How Would You Like to Sort the Customer List?");
		lblTitle.setBounds(10,10,300,50);
		panel.add(lblTitle);
		
		String[] text = {"Age", "Income"};
		for (int i=0; i<2; i++) {
			btnSortTypes[i] = new JButton(text[i]);
			btnSortTypes[i].setBounds(20 + 150*i,75, 100,70);
			btnSortTypes[i].addActionListener(this);
			panel.add(btnSortTypes[i]);
		}
		
		btnExit = new JButton("Exit Sorting");
		btnExit.setBounds(460,355,100,50);
		btnExit.addActionListener(this);
		panel.add(btnExit);
		
		
		
		myArea = new JTextArea();
		myArea.setEditable(false);
		JScrollPane sp = new JScrollPane(myArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		sp.setBounds(20,150,450,200);
		panel.add(sp);
		
		
		sortingFrame.setVisible(true);
		sortingFrame.setResizable(false);
		sortingFrame.setBounds(10, 100, 600, 450);
		sortingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		myArea.setText("");
		
		if (ae.getSource() == btnSortTypes[0]) {
			cd.sortingCustomers(0, myArea);//calls sorting method to sort by age
		}
		else if (ae.getSource()== btnSortTypes[1]){//calls sorting method to sort by income
			cd.sortingCustomers(1, myArea);
		}
		else {
			sortingFrame.dispose();
			mainFrame.setVisible(true);
		}
		
		
		
	}
	

	

}
