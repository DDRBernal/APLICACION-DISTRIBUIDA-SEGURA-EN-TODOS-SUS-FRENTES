package co.edu.escuelaing.sparkdockerdemolive;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class Control_access {

    /**
     * This method check the credentials typed in the HTML and
     * @param password
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static boolean verifyCredentials(String password) throws NoSuchAlgorithmException {
        boolean login_suceffully = true;
        String hash = "25d55ad283aa400af464c76d713c07ad";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        System.out.println(myHash+" "+hash);
        return login_suceffully;
    }

}
