import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUICustomerDatabaseCenter extends MainFrame implements WindowListener  {
	//attributes so whole class can have access
	private JFrame mainFrame;
	private CustomerDataBase cd;
	public static void main(String[] args) {
		   
		new GUICustomerDatabaseCenter();
	
	}
	public GUICustomerDatabaseCenter() {
		
		    mainFrame = new JFrame("Customer Database");//create main frame
			
			JPanel panel = new JPanel();//create panel
			panel.setLayout(null);
			
			addComponents(panel);//add components
			
			cd = new CustomerDataBase("CustomerData");//create object
			
			
			mainFrame.setContentPane(panel);
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
			mainFrame.setBounds(100, 100, 500, 550);
			mainFrame.addWindowListener(this);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	}
	
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
		//calls each button.. when each button is called main frame is set invisible and it calls the button's class
		if(ae.getSource() == btnAdd) {
			mainFrame.setVisible(false);
			new AddCustomerFrame(cd, mainFrame);
		}
		else if (ae.getSource() == btnDisplay) {
			mainFrame.setVisible(false);
			new DisplayFrame(cd,mainFrame);
			
			
		}
		else if (ae.getSource() == btnSort) {
			mainFrame.setVisible(false);
			new SortSelection(cd, mainFrame);
		}
		else if (ae.getSource() == btnDelete) {
			mainFrame.setVisible(false);
			new DeleteCustomer(cd, mainFrame);
		}
		else {
			mainFrame.setVisible(false);
			new SpecificCustomer(cd, mainFrame);
			
		}
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		//checks if user really wants to exit
		int confirm = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to exit?", "Travel Agency", JOptionPane.YES_NO_OPTION);
		if(confirm == 0) {
			System.exit(0);
		}
		
		//calls update file method
		cd.updateFile("CustomerData");
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
