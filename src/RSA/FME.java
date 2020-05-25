package RSA;

import java.math.BigInteger;

public class FME {

    public static BigInteger ModularPow(BigInteger base, BigInteger exponent, BigInteger modulus){

        if(modulus.equals(BigInteger.ONE))
            return BigInteger.ZERO;

        BigInteger result = BigInteger.ONE;
        base = base.mod(modulus);

        while (exponent.compareTo(BigInteger.ZERO) > 0){

            if (exponent.mod(BigInteger.TWO).equals(BigInteger.ONE)){
                result = (result.multiply(base)).mod(modulus);
            }
            exponent = exponent.shiftRight(1);
            base = (base.multiply(base)).mod(modulus);
        }
        return result;
    }
}
