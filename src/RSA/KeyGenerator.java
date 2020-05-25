package RSA;

import java.math.BigInteger;

public class KeyGenerator {

    public static BigInteger[] ExtendedEuclid(BigInteger e, BigInteger fiN)
    {
        BigInteger ZERO = BigInteger.ZERO;
        BigInteger ONE = BigInteger.ONE;

        BigInteger x = ZERO;
        BigInteger y = ONE;
        BigInteger lastx = ONE;
        BigInteger lasty =ZERO;
        BigInteger temp;
        while (!fiN.equals(ZERO))
        {

            BigInteger[] quotientAndRemainder = e.divideAndRemainder(fiN);
            BigInteger quotient = quotientAndRemainder[0];

            e = fiN;
            fiN = quotientAndRemainder[1];

            temp = x;
            x = lastx.subtract(quotient.multiply(x));
            lastx = temp;

            temp = y;
            y = lasty.subtract(quotient.multiply(y));
            lasty = temp;
        }

        BigInteger[] tmp = { lastx, lasty };
        return tmp;
    }

    public static BigInteger eCalculator(BigInteger fiN){

        BigInteger ONE = BigInteger.ONE;
        BigInteger THREE = new BigInteger("3");
        BigInteger e = THREE;
        boolean nemrelativ = true;
        BigInteger[] temp;
        while (nemrelativ)
        {
            temp = ExtendedEuclid(e, fiN);
            BigInteger lnko = e.multiply(temp[0]).add(fiN.multiply(temp[1]));
            if(lnko.equals(ONE))
            {
                nemrelativ = false;
            }
            else
            {
                e = e.add(ONE);
            }
        }
        return e;
    }


    public static BigInteger dCalculator(BigInteger e, BigInteger fiN) {

        BigInteger ONE = BigInteger.ONE;
        BigInteger[] tmp = ExtendedEuclid(e, fiN);
        BigInteger d = tmp[0];

        if(d.compareTo(ONE)>0 && d.compareTo(fiN)<0){
            return d;
        }
        else{
            return d.add(fiN);
        }
    }
}


