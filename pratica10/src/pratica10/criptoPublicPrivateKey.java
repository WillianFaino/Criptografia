/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package pratica10;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
/**
*
* @author larodrigues
*/
public class criptoPublicPrivateKey {

    public static void main(String[] args) {
        try {
        KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
        KeyPair chave = gen.genKeyPair();
        System.out.println("priv: "+chave.getPrivate());
        System.out.println("pub : "+chave.getPublic());

        String textoAberto = "the quick brown fox " + "jumps over the lazy dog";

        //criptografar
        Cipher cif = Cipher.getInstance("RSA");
        cif.init(Cipher.ENCRYPT_MODE, chave.getPrivate());

        byte[] buffer = cif.doFinal(textoAberto.getBytes());

        System.out.println("Texto aberto : "+ textoAberto.length() + textoAberto);
        System.out.println("Texto cifrado: "+ buffer.length + new String(Base64.getEncoder().encode(buffer)));

        cif.init(Cipher.DECRYPT_MODE, chave.getPublic());
        buffer = cif.doFinal(buffer);

        System.out.println("Texto recuperado: "+ new String(buffer));

    } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        }
    }

}