package control.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class defines the algorithm by which the password is encrypted.
 * @author Tamburello Martina
 * 
 */
public class PasswordEncrypter {

	/**
	 * This method encrypts a password
	 *
	 * @param password: password to be encrypted
	 * @return password: encrypted password in SHA-256
	 * */
	public static String crypt(String password) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(
					password.getBytes(StandardCharsets.UTF_8));
			StringBuilder hexString = new StringBuilder();
			for (byte b : encodedhash) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e){
			return password;
		}
	}
}

