package encryption;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;


public class PasswordEncryption {
	
	private static final int ITERATIONS = 1042;
	
	
	public static boolean checkPassword(String password, byte[] hashedPassword, byte[] salt){
		if(Arrays.equals(hashedPassword, getHash(password, salt))){
			return true;
		}
		else{
			return false;
		}
	}


	public static byte[] createSalt(){
		byte[] salt = new byte[16];
		SecureRandom sr = new SecureRandom();
		sr.nextBytes(salt);
		return salt;
	}
	

 	public static byte[] getHash(String password, byte[] salt){      	
 		byte[] passwordByte;
 		
        try { 	
        	MessageDigest digest = MessageDigest.getInstance("SHA-256");
        	digest.reset();
        	digest.update(salt);
        	passwordByte = digest.digest(password.getBytes("UTF-8"));
        	
        	for(int i = 0; i < ITERATIONS; i++){
        		digest.reset();
        		passwordByte = digest.digest(passwordByte);
        	}
        } 
        catch (Exception e) {
        	e.printStackTrace();
        	return null;
        }
        return passwordByte;
	}
}
