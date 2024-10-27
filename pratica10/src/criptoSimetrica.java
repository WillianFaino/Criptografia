import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class criptoSimetrica {
    public static void main(String[] args) {
        try {
            //criptografia simetrica - DES, 3DES e AES
            //gerar a chave
            KeyGenerator gerador = KeyGenerator.getInstance("AES");
            SecretKey chave = gerador.generateKey();
            System.out.println("Chave: "+
            Base64.getEncoder().encodeToString(
            chave.getEncoded()));
        
            String textoAberto = "the quick brown fox " + "jumps over the lazy dog";
        
            //criptografar
            Cipher cif = Cipher.getInstance("AES");
            cif.init(Cipher.ENCRYPT_MODE, chave);
        
            byte[] buffer = cif.doFinal(textoAberto.getBytes());
        
            System.out.println("Texto aberto : "+  textoAberto.length() + textoAberto);
        
            System.out.println("Texto cifrado: "+ buffer.length + new String(Base64.getEncoder().encode(buffer)));
        
            cif.init(Cipher.DECRYPT_MODE, chave);
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