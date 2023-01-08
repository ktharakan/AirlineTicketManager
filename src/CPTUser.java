import javax.swing.JFrame;
import javax.swing.JPanel;

public class CPTUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Customer Database");
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		GUICustomerDatabaseCenter gdc = new GUICustomerDatabaseCenter();
		gdc.addComponents(panel);
		
		frame.setContentPane(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
