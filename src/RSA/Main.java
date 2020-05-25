package RSA;

import java.math.BigInteger;
import java.util.Scanner;

import static RSA.Decryptor.decrypt;
import static RSA.Encryptor.encrypt;
import static RSA.KeyGenerator.dCalculator;
import static RSA.KeyGenerator.eCalculator;
import static RSA.PrimeGenerator.*;


public class Main {

    public static void main(String[] args) {

        BigInteger ONE = BigInteger.ONE;

        BigInteger p = getRandomProbablePrime(1024);
        BigInteger q = getRandomProbablePrime(1024);


        BigInteger n = p.multiply(q);

        BigInteger fiN = p.subtract(ONE).multiply(q.subtract(ONE));

        BigInteger e = eCalculator(fiN);



        BigInteger[] PublicKey ={n, e};
        BigInteger PrivateKey = dCalculator(e, fiN);


        Scanner myObj = new Scanner(System.in);
        System.out.println("Adja meg az üzenetet:");
        String message = myObj.nextLine();

        byte[] allBytes = message.getBytes();
        BigInteger m = new BigInteger(allBytes);

        while (m.compareTo(PublicKey[0]) > 0) {

            System.out.println("Túl hosszú üzenet, adjon meg újat:");
            message = myObj.nextLine();
            allBytes = message.getBytes();
            m = new BigInteger(allBytes);
        }

        BigInteger encryptedMessage = encrypt(m, PublicKey);
        System.out.println("Titkosított üzenet:");
        System.out.println(encryptedMessage);
        decrypt(encryptedMessage, PrivateKey, PublicKey[0]);
    }


}
