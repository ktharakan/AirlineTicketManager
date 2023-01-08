import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestFacility {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Test Facility");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		JTextArea myArea = new JTextArea();
		myArea.setEditable(false);
		
		
		
			
			JScrollPane sp = new JScrollPane(myArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			
			CustomerDataBase cd = new CustomerDataBase("CustomerData");
			
		    cd.displayArray(myArea);
			
		    myArea.append("\n");
		    cd.getCustomerInfo("Smith", "Adam", myArea);
		    
		    cd.sortingCustomers(0, myArea);
			
			
			sp.setBounds(100,100,300,200);
			panel.add(sp);
			
			//cd.displayArray(myArea);
			//cd.addCustomerInfo("Kevin", "Acns", "247 White's Hill Ave","Markham", "L6B 1K1", "6476571113", 17, 1000000);
     		//cd.displayArray(myArea);
			
			
			//cd.sortingCustomers(0);
			//cd.updateFile("CustomerData");
			
			
			
			frame.setContentPane(panel);
			frame.setVisible(true);
			frame.setResizable(false);
			frame.setBounds(100,100,500,500);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		
		}

}
