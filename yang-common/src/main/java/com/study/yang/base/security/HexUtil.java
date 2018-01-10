package com.study.yang.base.security;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/12/17 下午10:21
 * @Description 转换为16进制工具类
 */
public class HexUtil {

    /**
     * 将byte数组转为16进制
     * @param src
     * @return
     */
    public static String bytes2Hex(byte[] src){
        char[] res = new char[src.length*2];
        final char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        for(int i=0,j=0; i<src.length; i++){
            res[j++] = hexDigits[src[i] >>>4 & 0x0f];
            res[j++] = hexDigits[src[i] & 0x0f];
        }

        return new String(res);
    }

    /**
     * 将16进制转为byte数组
     * @param src
     * @return
     */
    public static byte[] hex2Bytes(String src){
        byte[] res = new byte[src.length()/2];
        char[] chs = src.toCharArray();
        int[] b = new int[2];

        for(int i=0,c=0; i<chs.length; i+=2,c++){
            for(int j=0; j<2; j++){
                if(chs[i+j]>='0' && chs[i+j]<='9'){
                    b[j] = (chs[i+j]-'0');
                }else if(chs[i+j]>='A' && chs[i+j]<='F'){
                    b[j] = (chs[i+j]-'A'+10);
                }else if(chs[i+j]>='a' && chs[i+j]<='f'){
                    b[j] = (chs[i+j]-'a'+10);
                }
            }
            b[0] = (b[0]&0x0f)<<4;
            b[1] = (b[1]&0x0f);
            res[c] = (byte) (b[0] | b[1]);
        }

        return res;
    }
}
