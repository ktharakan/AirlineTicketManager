import java.text.NumberFormat;
import java.util.Locale;

public class CustomerRecord {
	private String firstName, lastName, streetName, city, postalCode, telephone;
	private int age;
	private double income;
	
	public CustomerRecord(String firstName, String lastName, String streetName, String city, String postalCode, String telephone, int age, double income) {//constructer that passes all categories
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetName = streetName;
		this.city = city;
		this.postalCode = postalCode;
		this.telephone = telephone;
		this.age = age;
		this.income = income;
		
		}
	//getter methods for all attributes
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getStreetName() {
		return streetName;
	}
	public String getCity() {
		return city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public int getAge() {
		return age;
	}
	public double getIncome() {
		//NumberFormat nf= NumberFormat.getCurrencyInstance(Locale.CANADA);
		return income;
	}
	
}
