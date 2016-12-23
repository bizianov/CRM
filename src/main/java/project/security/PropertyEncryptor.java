package project.security;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Created by slava23 on 12/23/2016.
 */
public class PropertyEncryptor {

    private static String password = "key";

    public static void main(String[] args) {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        textEncryptor.setPassword(password);
        String myEncryptedText = textEncryptor.encrypt("your_password");
        System.out.println(myEncryptedText);
    }
}
