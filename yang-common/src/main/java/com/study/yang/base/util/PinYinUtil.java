package com.study.yang.base.util;

import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/21 下午4:18
 * @Description
 */
@Slf4j
public final class PinYinUtil {

    private PinYinUtil() {

    }


    /**
     * 获取字符串首字母
     *
     * @param src
     * @return
     */

    public static String getPinYininitial(String src) {
        if (StringUtils.isBlank(src)) {
            return "";
        }
        HanyuPinyinOutputFormat hanYuPinOutputFormat = new HanyuPinyinOutputFormat();
        hanYuPinOutputFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        hanYuPinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanYuPinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);

        char[] input = src.trim().toCharArray();
        input = ArrayUtils.subarray(input, 0, 1);
        StringBuffer output = new StringBuffer();
        try {

            for (int i = 0; i < input.length; i++) {
                if (Character.toString(input[i]).matches("[\u4E00-\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], hanYuPinOutputFormat);
                    output.append(temp[0]);
                    output.append(" ");
                } else
                    output.append(Character.toString(input[i]));
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("getPinYininitial is error in class【PinYinUtil】");
        }

        String result = StringUtils.trim(output.toString());
        result = StringUtils.upperCase(result);
        return String.valueOf(result.charAt(0));

    }


    /**
     * 获取全拼及首字母 index 0 全拼,
     * <p>
     * index 1 首字母
     * <p>
     * 支持多音字
     *
     * @param src
     * @return
     */
    public static Pair<Set<String>, Set<String>> getPinyinSpell(String src) {
        if (StringUtils.isNotBlank(src)) {
            char[] srcChar;
            srcChar = src.toCharArray();
            HanyuPinyinOutputFormat hanYuPinOutputFormat = getDefaultOutputFormat();
            String[][] temp = new String[src.length()][];

            for (int i = 0; i < srcChar.length; i++) {
                char c = srcChar[i];
                if (c > 128) {
                    try {
                        String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(srcChar[i], hanYuPinOutputFormat);
                        if (pinyin != null && pinyin.length > 0) {
                            Set<String> pinSet = new LinkedHashSet<String>(Arrays.asList(pinyin));
                            temp[i] = pinSet.toArray(new String[pinSet.size()]);
                        } else {
                            temp[i] = new String[]{""};
                        }
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        log.error("getPinYinSpell is error in class【PinYinUtil】");
                    }
                } else {
                    temp[i] = new String[]{String.valueOf(srcChar[i])};
                }
            }

            List<String[]> pingyinArray = DoExchange(temp);
            Set<String> wholeSpellSet = new HashSet<String>();
            Set<String> firstSpellSet = new HashSet<String>();
            for (String[] s : pingyinArray) {
                wholeSpellSet.add(s[0]);
                firstSpellSet.add(s[1]);
            }

            Pair<Set<String>, Set<String>> pair = new Pair<Set<String>, Set<String>>(wholeSpellSet, firstSpellSet);
            return pair;
        }
        return null;
    }


    /**
     * 获取拼音全拼
     *
     * @param src
     * @return
     */
    public static String getPinYin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                if (Character.toString(t1[i]).matches("[\\一-\\龥]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];// 取出该汉字全拼的第一种读音并连接到字符串t4后
                } else {
                    t4 += Character.toString(t1[i]);
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            log.error("getPinYin is error in class【PinYinUtil】");
        }
        return t4;
    }


    /**
     * 获取拼音首字母
     *
     * @param str
     * @return
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }


    /**
     * 判断传入字符串是否汉字
     *
     * @param s
     * @return
     */
    public static boolean isChinese(String s) {
        return s.matches("[\\u4E00-\\u9FA5]+");
    }


    /**
     * 判断传入字符是否汉字
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        return isChinese(Character.toString(c));
    }


    /**
     * 获取ASCII表
     *
     * @param cnStr
     * @return
     */
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }


    private static HanyuPinyinOutputFormat getDefaultOutputFormat() {
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 小写
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 没有音调数字
        format.setVCharType(HanyuPinyinVCharType.WITH_V);// v显示
        return format;
    }

    private static List<String[]> DoExchange(String[][] strJaggedArray) {
        int len = strJaggedArray.length;
        List<String[]> list = new ArrayList<String[]>();
        list.add(new String[]{"", ""});
        for (int x = 0; x < len; x++) {
            int len1 = list.size();
            String[] pinyins = strJaggedArray[x];
            List<String[]> tmpList = new ArrayList<String[]>();
            for (int i = 0; i < pinyins.length; i++) {
                String wholeSpell = pinyins[i];
                if (StringUtils.isBlank(wholeSpell)) {
                    continue;
                }

                String firstSpell = Character.toString(wholeSpell.charAt(0));

                if ((firstSpell.equals("c") || firstSpell.equals("z") || firstSpell.equals("s")) && wholeSpell.length() > 1) {
                    char secondChar = wholeSpell.charAt(1);
                    if (secondChar == 'h') {
                        firstSpell += "h";
                    }
                }

                for (int j = 0; j < len1; j++) {
                    String[] tmp = list.get(j);
                    String newWholeSpell = tmp[0] + wholeSpell;
                    String newFirstSpell = tmp[1] + firstSpell;
                    tmpList.add(new String[]{newWholeSpell, newFirstSpell});
                }
            }

            if (tmpList.size() != 0) {
                list.clear();
                list.addAll(tmpList);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        String src = "和面";
        String name = PinYinUtil.getPinYininitial(src);
        System.out.println(name);
        Pair<Set<String>, Set<String>> p = PinYinUtil.getPinyinSpell(src);
        System.out.println(p);
        boolean b = PinYinUtil.isChinese(src);
        System.out.println(b);
        name = PinYinUtil.getPinYin(src);
        System.out.println(name);
        name = PinYinUtil.getPinYinHeadChar(src);
        System.out.println(name);
        name = PinYinUtil.getCnASCII(src);
        System.out.println(name);
    }

}
