package RSA;

import java.math.BigInteger;
import java.security.SecureRandom;

import static RSA.FME.ModularPow;


public class MillerRabin {

    public static boolean isProbablePrime(BigInteger n) {

        BigInteger ZERO = BigInteger.ZERO;
        BigInteger ONE = BigInteger.ONE;
        BigInteger TWO = new BigInteger("2");
        BigInteger THREE = new BigInteger("3");

        if (n.compareTo(ONE) == 0)
            return false;

        else if (n.compareTo(THREE) < 0)
            return true;

        int s = 0;

        BigInteger d = n.subtract(ONE);
        while (d.mod(TWO).equals(ZERO)) {
            d = d.divide(TWO);
            s++;
        }

        for (int i = 0; i < 100; i++) {

            BigInteger a = RandomValue(TWO, n.subtract(ONE));
            BigInteger x = ModularPow(a, d, n);

            if (x.equals(ONE) || x.equals(n.subtract(ONE)))
                continue;

            int r = 0;

            for (; r < s; r++) {

                x = ModularPow(x, TWO, n);

                if (x.equals(ONE))
                    return false;
                if (x.equals(n.subtract(ONE)))
                    break;
            }
            if (r == s)
                return false;
        }
        return true;
    }


    public static BigInteger RandomValue(BigInteger bottomValue, BigInteger topValue){

        SecureRandom rnd = new SecureRandom();
        BigInteger a;

        do {
            a = new BigInteger(topValue.bitLength(), rnd);
        } while (a.compareTo(bottomValue) < 0 || a.compareTo(topValue) > 0);

        return a;
    }

}
