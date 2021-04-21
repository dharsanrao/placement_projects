import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Scanner;
public class SignatureVerification {
   public static void main(String args[]) throws Exception{
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
	      
      keyPairGen.initialize(2048);
	      
      KeyPair pair = keyPairGen.generateKeyPair();
      
      PrivateKey privKey = pair.getPrivate();

      Signature sign = Signature.getInstance("SHA256withDSA");

      sign.initSign(privKey);
      byte[] bytes = "Hello how are you".getBytes();
      
      sign.update(bytes);
      
      byte[] signature = sign.sign();      
      
      sign.initVerify(pair.getPublic());
      sign.update(bytes);
      
      boolean bool = sign.verify(signature);
 
      if(bool) {
         System.out.println("Signature verified");   
      } else {
         System.out.println("Signature failed");
      }
   }
}