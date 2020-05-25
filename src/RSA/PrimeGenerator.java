package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;

import static RSA.MillerRabin.*;

public class PrimeGenerator {

    public static BigInteger getRandomProbablePrime(int bitLength){
        BigInteger result = new BigInteger(bitLength, new SecureRandom());
        while(!isProbablePrime(result)){
            result = new BigInteger(bitLength, new SecureRandom());
        }
        return result;
    }
}
