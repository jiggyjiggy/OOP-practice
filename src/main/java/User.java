public class User {
	private String password;
	
	public void initPassword() {
		RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
		String randomPassword = randomPasswordGenerator.generatePassword();
		
		if (8 <= randomPassword.length() && randomPassword.length() <= 12) {
			this.password = randomPassword;
		}
	}
	
	public String getPassword() {
		return password;
	}
}
