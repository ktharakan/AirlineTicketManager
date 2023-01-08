import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomerDataBase {
	private ArrayList<CustomerRecord> customerData = new ArrayList<CustomerRecord>();//array list that stores customerRecord objects
	static NumberFormat nf= NumberFormat.getCurrencyInstance(Locale.CANADA);
	
	public CustomerDataBase(String fileName) {
		try {
			//reeads and tokenizes each line
			BufferedReader br = new BufferedReader(new FileReader(fileName + ".txt"));
			String line = br.readLine();
			
			while(line != null){	//checks if there any more lines in the text file
					StringTokenizer st = new StringTokenizer(line, ",");
					customerData.add(new CustomerRecord(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()), Double.parseDouble(st.nextToken())));
					
					line = br.readLine();
			}
			
			br.close();
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,"File not found.");
		}
			
	
	}
	
	public void displayArray(JTextArea myArea) {//displayArray method with myArray passed through it
		myArea.append("First Name\tLast Name\tAddress\t\tCity\tPostal Code\tTelephone #\tAge\tIncome\n\n");//titles for myArea
		for (int i = 0; i<customerData.size(); i++) {//appends all customer attributes
			myArea.append(customerData.get(i).getFirstName() + "\t " + customerData.get(i).getLastName() + "\t " + customerData.get(i).getStreetName()
					+ "\t" + customerData.get(i).getCity() + "\t " + customerData.get(i).getPostalCode() + "\t" + customerData.get(i).getTelephone() + "\t " + customerData.get(i).getAge() + "\t"
					 +nf.format(customerData.get(i).getIncome())  + "\n");
		}
				
		
		
	}
	
	public void getCustomerInfo(String firstName, String lastName, JTextArea myArea) {
		boolean found = false;
		myArea.append("First Name\tLast Name\tAddress\t\tCity\tPostal Code\tTelephone #\tAge\tIncome\n\n");//titles for myArea
		for(int i =0; i<customerData.size(); i++) {//checks if first name and last name are found and then appends it to the myArea
			if (customerData.get(i).getFirstName().equals(firstName) && customerData.get(i).getLastName().equals(lastName)) {
				myArea.append(customerData.get(i).getFirstName() + "\t " + customerData.get(i).getLastName() + "\t " + customerData.get(i).getStreetName()
						+ "\t" + customerData.get(i).getCity() + "\t " + customerData.get(i).getPostalCode() + "\t" + customerData.get(i).getTelephone() + "\t " + customerData.get(i).getAge() + "\t"
						 +nf.format(customerData.get(i).getIncome())  + "\n");
				found = true;
				break;
			}
			
		}
		if (!found) {// if found is false it will display customer not found
			JOptionPane.showMessageDialog(null,"Customer not found","Error",JOptionPane.ERROR_MESSAGE);
		}
		
		
		
	}
	public void addCustomerInfo(String firstName, String lastName, String streetName, String city, String postalCode, String telephone, int age, double income) {
		CustomerRecord addedCustomer = new CustomerRecord (firstName, lastName, streetName, city, postalCode, telephone, age, income);//creates new customer record object
		boolean last = true;
		for (int i = 0; i<customerData.size(); i++) {//for loop to place the customer in right location
			if (lastName.compareTo(customerData.get(i).getLastName()) < 0) {
				 customerData.add(i, addedCustomer);
				 last = false;
				 break;
			}
		}
		
		if(last) {//if customer is supposed to last
			customerData.add(addedCustomer);
		}
		
	}
	
	public void deleteCustomerInfo(String firstName, String lastName) {
		
		boolean found = false;
		for(int i = 0; i <customerData.size(); i++) {
			if(customerData.get(i).getFirstName().equals(firstName) && customerData.get(i).getLastName().equals(lastName)) {//checks if customer is in array
				customerData.remove(i);//removes customer record object
				found = true;
				break;
			}
			
		}
		if (!found) {// if found is false it will display customer not found
			JOptionPane.showMessageDialog(null,"Customer not found","Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void sortingCustomers(int type,  JTextArea myArea) {
		myArea.append("First Name\tLast Name\tAddress\t\tCity\tPostal Code\tTelephone #\tAge\tIncome\n\n");
		
		if (type == 0) {//if integer is 0 then it will sort by age
			int [] age = new int [customerData.size()];
			int temp;
			
			
			for (int i = 0;i<customerData.size();i++) {//creates an array with ages to sort by
				age[i]= customerData.get(i).getAge();
			}
			
			for(int i = 1; i< age.length; i++) {//insertions sort
				temp = age[i];
				int j;
				for ( j = i -1; j >= 0; j--) {
					if(temp > age[j]) {
						age[j+1] = age[j];
					}
					else {
						break;
					}	
				}
				age[j+1] = temp;
				
			}
			
			
			for (int i = 0;i<customerData.size();i++) {
				
				for(int j = 0;j<customerData.size();j++) {
					if (age[i]==customerData.get(j).getAge()) {//appends the correct object in the right place
						myArea.append(customerData.get(j).getFirstName()+"\t"+customerData.get(j).getLastName()+"\t"+customerData.get(j).getStreetName()+"\t"+customerData.get(j).getCity()+"\t"+
								customerData.get(j).getPostalCode()+"\t"+customerData.get(j).getTelephone()+"\t"+customerData.get(j).getAge()+"\t"+nf.format(customerData.get(i).getIncome())  + "\n");
						break;
					}
				}
			}
		}
		else {//does the same sort for income
			double [] income = new double [customerData.size()];
			double temp;
			
			
			for (int i = 0;i<customerData.size();i++) {
				income[i]= customerData.get(i).getIncome();
			}
			
			for(int i = 1; i< income.length; i++) {//insertion sort
				temp = income[i];
				int j;
				for ( j = i -1; j >= 0; j--) {
					if(temp > income[j]) {
						income[j+1] = income[j];
					}
					else {
						break;
					}	
				}
				income[j+1] = temp;
			}
			for (int i = 0;i<customerData.size();i++) {
				//System.out.println(age[i]);
				for(int j = 0;j<customerData.size();j++) {
					if (income[i]==customerData.get(j).getIncome()) {
						myArea.append(customerData.get(j).getFirstName()+"\t"+customerData.get(j).getLastName()+"\t"+customerData.get(j).getStreetName()+"\t"+customerData.get(j).getCity()+"\t"+
								customerData.get(j).getPostalCode()+"\t"+customerData.get(j).getTelephone()+"\t"+customerData.get(j).getAge()+"\t"+nf.format(customerData.get(i).getIncome())  + "\n");
						break;
					}
				}
			}
		}
	}
			

	
	public void updateFile(String fileName) {//updates file
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(fileName + ".txt", false));
			for (int i = 0; i<customerData.size(); i++) {//prints the "new" data on file
				pw.println(customerData.get(i).getFirstName() + "," + customerData.get(i).getLastName() + "," + customerData.get(i).getStreetName()
						+ "," + customerData.get(i).getCity() + "," + customerData.get(i).getPostalCode() + "," + customerData.get(i).getTelephone() + "," + customerData.get(i).getAge() + ","
						 + customerData.get(i).getIncome());
			}
			pw.close();
			
			
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,"File not found.");
		}
	}
	
}
	


