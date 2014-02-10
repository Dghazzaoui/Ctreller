package se.web_project.user.User;

public class User {

	private int userId;
	private String password;
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String phoneNumber;
	private String eMail;
	private String city;
	private String postcode;

	public User(int id ) {
		this.userId = id;
		this.setFirstName("");
		this.setLastName("");
		this.setEMail("");
		this.setPassword("");
		this.setStreetAddress("");
		this.setPhoneNumber("");
		this.setCity("");
		this.setPostcode("");
	}
	
	public User() {
		this.userId= 0;
		this.setFirstName("");
		this.setLastName("");
		this.setEMail("");
		this.setPassword("");
		this.setStreetAddress("");
		this.setPhoneNumber("");
		this.setCity("");
		this.setPostcode("");
	}
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		User userTemp = null;

		if (obj instanceof User) {
			userTemp = (User) obj;
		}

		return (this.userId == userTemp.userId || (this.eMail
				.equals(userTemp.eMail) && this.password
				.equals(userTemp.password)));
	}

	@Override
	public int hashCode() {
		int result = 1;
		result += 37 * this.userId;
		result += 37 * this.password.hashCode();
		return result;
	}

	@Override
	public String toString() {

		return String.format("eMail:%s, firstName:%s, lastName:%s", eMail,
				firstName, lastName); // kolla utskrift.
	}

	 //Check with Ulf
	public static boolean containsValue(User user) {

		return false;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
}
