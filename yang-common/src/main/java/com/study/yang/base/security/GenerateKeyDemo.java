package com.study.yang.base.security;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/12/18 上午11:09
 * @Description 生成RSA公key和私key
 */
public class GenerateKeyDemo {

    public static void main(String[] args) {
        try {
            generateKeyPairString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateKeyPairString() throws Exception{
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(1024, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();

        String algorithm = publicKey.getAlgorithm(); // 获取算法
        System.out.println("算法:\t"+algorithm);
        KeyFactory keyFact = KeyFactory.getInstance(algorithm);

        RSAPublicKeySpec keySpec = (RSAPublicKeySpec)keyFact.getKeySpec(publicKey, RSAPublicKeySpec.class);

        BigInteger prime = keySpec.getModulus();
        BigInteger exponent = keySpec.getPublicExponent();
        System.out.println("公钥模量:\t"+HexUtil.bytes2Hex(prime.toByteArray()));
        System.out.println("公钥指数:\t"+HexUtil.bytes2Hex(exponent.toByteArray()));

        RSAPrivateCrtKeySpec privateKeySpec = (RSAPrivateCrtKeySpec)keyFact.getKeySpec(privateKey, RSAPrivateCrtKeySpec.class);
        BigInteger privateModulus = privateKeySpec.getModulus();
        BigInteger privateExponent = privateKeySpec.getPrivateExponent();

        System.out.println("私钥模量:\t"+HexUtil.bytes2Hex(privateModulus.toByteArray()));
        System.out.println("私钥指数:\t"+HexUtil.bytes2Hex(privateExponent.toByteArray()));
    }
}
