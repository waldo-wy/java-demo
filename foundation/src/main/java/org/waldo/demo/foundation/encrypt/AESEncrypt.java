/**
 * @author waldo.wy
 * @date 2017/7/5
 */
package org.waldo.demo.foundation.encrypt;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 类AESEncrypt描述：
 *
 * @author waldo.wy 2017/7/5 16:26
 */
public class AESEncrypt {

    /*
     * 注意key和加密用到的字符串是不一样的 加密还要指定填充的加密模式和填充模式
     * AES密钥可以是128或者256，加密模式包括ECB,CBC等
     * ECB模式是分组的模式，CBC是分块加密后，
     * 每块与前一块的加密结果异或后再加密 第一块加密的明文是与IV变量进行异或
     **/
    public static final String KEY_ALGORITHM        = "AES";
    public static final String ECB_CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
     public static final String CBC_CIPHER_ALGORITHM = "AES/CBC/PKCS5Padding";
//    public static final String CBC_CIPHER_ALGORITHM = "AES/CBC/NoPadding";
    // public static final String PLAIN_TEXT = "987654321012+" + DateFormatUtils.format(new Date(), "MMddHHmm");
    public static final String PLAIN_TEXT           = "71234B5EF";
    public static final String AES_KEY              = "R){Xp!rsTVQ6;0w*";

    /**
     * IV(Initialization Value)是一个初始值，对于CBC模式来说，它必须是随机选取并且需要保密的
     * 而且它的长度和密码分组相同(比如：对于AES 128为128位，即长度为16的byte类型数组)
     */
    public static final byte[] IVPARAMETERS         = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
            16                                     };

    private static final String SALT = "347a4a6c414a475a6130573445455a6d";


    public static void main(String[] arg) throws Exception {
//        AesUtil aesUtil = new AesUtil(128, 1000);
//        String hxSalt = AesUtil.hex(SALT.getBytes());
//        System.out.println(hxSalt);
//        System.out.println(aesUtil.encrypt("6979cc1a056c15b68844d796a582b9b4", "08d7f4e88264b22930213fbeb9ac3d55", AES_KEY, "acpe$RFV518k"));
//        System.out.println(aesUtil.decrypt("6979cc1a056c15b68844d796a582b9b4", "08d7f4e88264b22930213fbeb9ac3d55", AES_KEY, "y/r+5b4v5ejZImKq+lNhfg=="));

//        "3DsAzsypkKeK5XADsPnehA=="
        System.out.println(desEncrypt("3DsAzsypkKeK5XADsPnehA==", AES_KEY));
        

//        byte[] secretBytes = generateAESSecretKey();
//        System.out.println(Base64.getEncoder().encodeToString(secretBytes));
//        System.out.println(new String(org.apache.commons.codec.binary.Base64.encodeBase64String(secretBytes)));
//        SecretKey key = restoreSecretKey(secretBytes);
//        byte[] encodedText = AesEcbEncode(PLAIN_TEXT.getBytes(), key);
//        System.out.println("AES ECB encoded with Base64: " + Base64.getEncoder().encodeToString(encodedText));
//        System.out.println("AES ECB decoded: " + AesEcbDecode(encodedText, key));
//
//        byte[] ivps = new IvParameterSpec(secretBytes).getIV();
        // encodedText = AesCbcEncode(PLAIN_TEXT.getBytes(), key, ivps);
        // System.out.println("AES CBC encoded with Base64: " + Base64.getEncoder().encodeToString(encodedText));
        // System.out.println("AES CBC decoded: " + AesCbcDecode(encodedText, key, ivps));
//        String encrypted = encrypt("hello world!!!", AES_KEY, AES_KEY);
//        System.out.println(AES_KEY.getBytes().toString());
//        System.out.println("后端加密结果：" + encrypted);
//        System.out.println("前端传入解密后数据：" + desEncrypt("U2FsdGVkX19XpYY90U9YZ4UQ/ZGgLRVUW5J50KS9uYs=", AES_KEY, AES_KEY));
//        System.out.println("后端传入解密后数据：" + desEncrypt(encrypted, AES_KEY, AES_KEY));

    }

    /**
     * 使用ECB模式进行加密。 加密过程三步走：
     * 1. 传入算法，实例化一个加解密器
     * 2. 传入加密模式和密钥，初始化一个加密器
     * 3. 调用doFinal方法加密
     *
     * @param plainText
     * @return
     */
    public static byte[] AesEcbEncode(byte[] plainText, SecretKey key) {

        try {

            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(plainText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用ECB解密，三步走，不说了
     *
     * @param decodedText
     * @param key
     * @return
     */
    public static String AesEcbDecode(byte[] decodedText, SecretKey key) {
        try {
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(decodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    /**
     * CBC加密，三步走，只是在初始化时加了一个初始变量
     *
     * @param plainText
     * @param key
     * @param IVParameter
     * @return
     */
    public static byte[] AesCbcEncode(byte[] plainText, SecretKey key, byte[] IVParameter) {
        try {
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);

            Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);

            // NOPadding
//            int blockSize = cipher.getBlockSize();
//
//            // byte[] dataBytes = data.getBytes();
//            int plainTextLength = plainText.length;
//            if (plainTextLength % blockSize != 0) {
//                plainTextLength = plainTextLength + (blockSize - (plainTextLength % blockSize));
//            }
//
//            byte[] newPlainText = new byte[plainTextLength];
//            System.arraycopy(plainText, 0, newPlainText, 0, plainText.length);

            cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
            return cipher.doFinal(plainText);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /**
     * CBC 解密
     *
     * @param decodedText
     * @param key
     * @param IVParameter
     * @return
     */
    public static String AesCbcDecode(byte[] decodedText, SecretKey key, byte[] IVParameter) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IVParameter);

        try {
            Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
            return new String(cipher.doFinal(decodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
                | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 1.创建一个KeyGenerator 2.调用KeyGenerator.generateKey方法
     * 由于某些原因，这里只能是128，如果设置为256会报异常，原因在下面文字说明
     *
     * @return
     */
    public static byte[] generateAESSecretKey() throws NoSuchAlgorithmException {
        // KeyGenerator keyGenerator;
        // try {
        // keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        // // keyGenerator.init(256);
        // return keyGenerator.generateKey().getEncoded();
        // } catch (NoSuchAlgorithmException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

//        byte[] raw = new byte[0];
//        try {
//            raw = AES_KEY.getBytes("utf-8");
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, KEY_ALGORITHM);
//            return skeySpec.getEncoded();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//
//        return null;

        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//             KeySpec spec = new PBEKeySpec(passphrase.toCharArray(), hex(salt), iterationCount, keySize);
//             SecretKey key = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        return null;
    }

    /**
     * 还原密钥
     *
     * @param secretBytes
     * @return
     */
    public static SecretKey restoreSecretKey(byte[] secretBytes) {
        SecretKey secretKey = new SecretKeySpec(secretBytes, KEY_ALGORITHM);
        return secretKey;
    }

    public static String encrypt(String data, String key, String iv) throws Exception {
        try {

            Cipher cipher = Cipher.getInstance(CBC_CIPHER_ALGORITHM);// "算法/模式/补码方式"

            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(data.getBytes());
//            return new String(encrypted, "utf-8");
            return Base64.getEncoder().encodeToString(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data, String key) throws Exception {
        try {
            byte[] encrypted1 = Base64.getDecoder().decode(data);
//            byte[] encrypted1 = data.getBytes("utf-8");
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
//            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

//            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            cipher.init(Cipher.DECRYPT_MODE, keyspec);

            byte[] original = cipher.doFinal(encrypted1);
            return new String(original, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
