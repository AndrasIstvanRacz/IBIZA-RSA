package RSA;

import java.math.BigInteger;

import static RSA.FME.ModularPow;

public class Decryptor {

    public static void decrypt(BigInteger encryptedMessage, BigInteger d, BigInteger n){
        encryptedMessage = ModularPow(encryptedMessage, d, n);
        byte[] temp = encryptedMessage.toByteArray();
        System.out.println("Az üzenet visszafejtve:");
        System.out.println(new String(temp));
    }
}
