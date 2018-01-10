package com.study.yang.base.security;

import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/12/18 上午11:02
 * @Description RSA公钥加密、解密工具类
 */
public class RSAEncryptUtil {

    /**
     * 加密
     * @param string 待加密明文
     * @return
     */
    public static String encrypt(String string,PublicKey publicKey) {
        String afterEncrypt = null;
        try {
            // 加解密类
            Cipher cipher = Cipher.getInstance(AlgorithmConstant.ALGORITHM);

            // 公钥加密
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            // 明文
            byte[] plainText = string.getBytes();

            byte[] enBytes = cipher.doFinal(plainText);
            afterEncrypt = HexUtil.bytes2Hex(enBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return afterEncrypt;
    }

    /**
     * 解密
     * @param string 需要解密数据
     * @return
     */
    public static String decrypt(String string,PrivateKey privateKey) {
        String result = null;
        // 加解密类
        try {
            Cipher cipher = Cipher.getInstance(AlgorithmConstant.ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] bytes = HexUtil.hex2Bytes(string);
            byte[] deBytes = cipher.doFinal(bytes);
            result = new String(deBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
