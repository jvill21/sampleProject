/**
 * 
 * @author Michael Baca, Joshua Villegas, James Bias
 * @version 1.2 (11/17/2016)
 * 
 * Public class representing different kinds of users. This class 
 * represents the common features of all the user which include a 
 * user name and password.
 *
 */
public class User extends RegistrationSystem {

	/** user's name*/
	protected String userName = "";
	
	/** user's password*/
	protected String password = "";
	
	
	/**
	 * sets the name of a user
	 * @param n name of this user
	 */
	public void setName(String n) {
		userName = n;
	}
	
	/**
	 * sets the password of a user
	 * @param p password for this user
	 */
	public void setPassword(String p) {
		password = p;
	}
	
	/** 
	 * returns the name of the user
	 * @return name of this user
	 */
	public String getName() {
		return userName;
	}
	
	/**
	 * returns the password for a user
	 * @return the user's password
	 */
	public String getPassword() {
		return password;
	}
}
