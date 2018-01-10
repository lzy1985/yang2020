package com.study.yang.base.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/12/17 下午10:12
 * @Description
 */
public class TestDemo {


    private static final String PUBLIC_HEX_MODULUS = "00DA3641CCBFDBBBE3470BB7B5CE643CE8E4C1342735E9A462D7D6B51508B1B1F6343D850FAB47B67E8811101CEFA3D098C3F54DDB6929706F9017DA36CC7EB4FBEA1D9D9F5471E02D3BE412F5BB9F1167ABD07BA3BD92BC1DF849B616472645DC29C3CB574A18FCABF4E3109D4DC8B3F73AE5EB8772AA1A93A10ADB6342DB19B7";
    private static final String PUBLIC_HEX_EDPONENT= "010001";
    private static final String PRIVATE_HEX_MODULUS = "00DA3641CCBFDBBBE3470BB7B5CE643CE8E4C1342735E9A462D7D6B51508B1B1F6343D850FAB47B67E8811101CEFA3D098C3F54DDB6929706F9017DA36CC7EB4FBEA1D9D9F5471E02D3BE412F5BB9F1167ABD07BA3BD92BC1DF849B616472645DC29C3CB574A18FCABF4E3109D4DC8B3F73AE5EB8772AA1A93A10ADB6342DB19B7";
    private static final String PRIVATE_EDPONENT= "60EF4351AA54F965203563599F22C6300B168C8D7294A4D2C7E0F8362CD38B23BCD72B59E79386CD34B2A7BEC2F1B98373617041ACB89CDAE25EC6301BAD99C59085F65AB929941596A0A90C1E457F146D6E8C75B927ADBB1AD1583B2785BA5179AF5F537D45FF6D279F263679DA0EC101EB47530D60038BE427978E734B6829";

    public static void main(String[] args) throws Exception {
        String pwd = "你猜猜达到撒范德萨";
        // 公钥
        PublicKey publicKey = RSAKeyUtil.getRSAPublicKey(PUBLIC_HEX_MODULUS,PUBLIC_HEX_EDPONENT);
        PrivateKey privateKey = RSAKeyUtil.getRSAPrivateKey(PRIVATE_HEX_MODULUS,PRIVATE_EDPONENT);
        // 私钥

        String result = RSAEncryptUtil.encrypt(pwd,publicKey);
        System.out.println("rsa加密后:\t" + result);
        System.out.println("rsa解密后:\t" + RSAEncryptUtil.decrypt(result,privateKey));
    }




}
