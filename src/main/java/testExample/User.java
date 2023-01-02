package testExample;

public class User {
	private String password;
	
	public void initPassword(MyPasswordGenerator passwordGenerator) {
		String randomPassword = passwordGenerator.generatePassword();
		
		if (8 <= randomPassword.length() && randomPassword.length() <= 12) {
			this.password = randomPassword;
		}
	}
	
	public String getPassword() {
		return password;
	}
}
