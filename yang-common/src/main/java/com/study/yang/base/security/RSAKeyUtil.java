package com.study.yang.base.security;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/12/18 上午11:04
 * @Description RSA key工具类
 */
public class RSAKeyUtil {

    /**
     * 根据模和指数获取公key
     * @param hexModulus
     * @param hexPublicExponent
     * @return
     */
    public static RSAPublicKey getRSAPublicKey(String hexModulus, String hexPublicExponent) {
        if (isBlank(hexModulus) || isBlank(hexPublicExponent)) {
            System.out.println("hexModulus and hexPublicExponent cannot be empty. return null(RSAPublicKey).");
            return null;
        }
        try {
            byte[] modulus = HexUtil.hex2Bytes(hexModulus);
            byte[] publicExponent = HexUtil.hex2Bytes(hexPublicExponent);
            if (modulus != null && publicExponent != null) {
                return generateRSAPublicKey(modulus, publicExponent);
            }
        } catch (Exception ex) {
            System.out.println("hexModulus or hexPublicExponent value is invalid. return null(RSAPublicKey).");
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 根据模和指数获取公key
     * @param hexModulus
     * @param hexPublicExponent
     * @return
     */
    public static RSAPrivateKey getRSAPrivateKey(String hexModulus, String hexPublicExponent) {
        if (isBlank(hexModulus) || isBlank(hexPublicExponent)) {
            System.out.println("hexModulus and hexPublicExponent cannot be empty. return null(RSAPublicKey).");
            return null;
        }
        try {
            byte[] modulus = HexUtil.hex2Bytes(hexModulus);
            byte[] publicExponent = HexUtil.hex2Bytes(hexPublicExponent);
            if (modulus != null && publicExponent != null) {
                return generateRSAPrivateKey(modulus, publicExponent);
            }
        } catch (Exception ex) {
            System.out.println("hexModulus or hexPublicExponent value is invalid. return null(RSAPublicKey).");
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 根据模和指数生成公key
     * @param hexModulusBytes
     * @param hexPublicExponentBytes
     * @return
     */
    private static RSAPublicKey generateRSAPublicKey(byte[] hexModulusBytes, byte[] hexPublicExponentBytes){
        BigInteger hexModulus = new BigInteger(hexModulusBytes);
        BigInteger hexPublicExponent = new BigInteger(hexPublicExponentBytes);
        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(hexModulus,hexPublicExponent);
        RSAPublicKey publicKey = null;
        try {
            publicKey = (RSAPublicKey) KeyFactory.getInstance(AlgorithmConstant.ALGORITHM).generatePublic(rsaPublicKeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    /**
     * 根据模和指数生成私key
     * @param hexModulusBytes
     * @param hexPublicExponentBytes
     * @return
     */
    private static RSAPrivateKey generateRSAPrivateKey(byte[] hexModulusBytes, byte[] hexPublicExponentBytes){
        BigInteger hexModulus = new BigInteger(hexModulusBytes);
        BigInteger hexPublicExponent = new BigInteger(hexPublicExponentBytes);
        RSAPrivateKeySpec rsaPrivateKeySpec = new RSAPrivateKeySpec(hexModulus,hexPublicExponent);
        RSAPrivateKey privateKey = null;
        try {
            privateKey = (RSAPrivateKey) KeyFactory.getInstance(AlgorithmConstant.ALGORITHM).generatePrivate(rsaPrivateKeySpec);
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return privateKey;
    }
}
