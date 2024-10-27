package pratica10;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Properties;

public class signatureGenWPPKeys {
    public static void main(String args[]) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
            SecureRandom secRan = new SecureRandom();
            keyGen.initialize(512, secRan);
            KeyPair keyP = keyGen.generateKeyPair();
            PublicKey pubKey = keyP.getPublic();
            PrivateKey priKey = keyP.getPrivate();
            System.out.println("publica: "+pubKey);
            System.out.println("privada: "+priKey);


            //Obtem algoritmo para geração da assinatura
            Signature geradorAss = Signature.getInstance("DSA");


            //Inicializar geração
            geradorAss.initSign(priKey);
            String mensagem = "The quick brown fox jumps over the lazy dog";


            //Gerar assinatura
            geradorAss.update(mensagem.getBytes());
            byte[] assinatura = geradorAss.sign();


            //Grava a mensagem num arquivo properties
            Properties p = new Properties();
            p.put("mensagem", mensagem);
            p.put("assinatura", byteArrayToHexString(assinatura));
            p.store(new FileOutputStream("dado.properties"), null);

            
            //Serializa a chave pública
            ObjectOutputStream oout = new ObjectOutputStream(
            new FileOutputStream("pubkey.ser"));
            oout.writeObject(pubKey);
            oout.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char intToHexChar(int a){
        switch(a){
            case 0: return '0';
            case 1: return '1';
            case 2: return '2';
            case 3: return '3';
            case 4: return '4';
            case 5: return '5';
            case 6: return '6';
            case 7: return '7';
            case 8: return '8';
            case 9: return '9';
            case 10: return 'A';
            case 11: return 'B';
            case 12: return 'C';
            case 13: return 'D';
            case 14: return 'E';
            case 15: return 'F';
        }
        return (char)0;
    }

    public static String byteArrayToHexString(byte[] assinatura){
        String s = "";
        for (Byte byte1 : assinatura) {
            int byteInt = Byte.toUnsignedInt(byte1);


            char a = intToHexChar((byteInt/16));
            char b = intToHexChar((byteInt%16));
            s = s + a + b;
        }
        
        return s;
    }
}