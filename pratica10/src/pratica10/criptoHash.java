package pratica10;

import java.security.MessageDigest;
import java.util.Base64;

public class criptoHash {
    public static void main(String args[]) {
        try{
            //MD5, SHA-1 SHA-256
            MessageDigest md = MessageDigest.getInstance("MD5");

            String chave = "The quick brown fox jumps over the lazy dog";
            System.out.println("Msg 0: "+chave);
            byte[] buffer = md.digest(chave.getBytes());
            System.out.println("Hash for msg 0: "+Base64.getEncoder().encodeToString(buffer));

            String chave2 = "The quick brown fox jumps over the lazy cog";
            System.out.println("\n\n\n\n\nMsg 1: "+chave2);
            buffer = md.digest(chave2.getBytes());
            System.out.println("Hash for msg 1: "+Base64.getEncoder().encodeToString(buffer));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}