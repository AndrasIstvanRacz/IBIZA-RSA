package RSA;

import java.math.BigInteger;

import static RSA.FME.ModularPow;

public class Encryptor {

    public static BigInteger encrypt(BigInteger m, BigInteger[] PublicKey){
        m = ModularPow(m, PublicKey[1],PublicKey[0]);
        return m;
    }
}
