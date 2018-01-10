package com.study.yang.base.filter;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午9:22
 * @Description
 */
public class XXSUtils {
    private static List<Pattern> patterns = null;

    private static List<Object[]> getXssPatternList() {
        List<Object[]> ret = new ArrayList<Object[]>();
        ret.add(new Object[]{"<(no)?script[^>]*>.*?</(no)?script>", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(javascript:|vbscript:|view-source:)*", Pattern.CASE_INSENSITIVE});
        ret.add(new Object[]{"<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"(window\\.location|window\\.|\\.location|document\\.cookie|document\\.|alert\\(.*?\\)|window\\.open\\()*", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        ret.add(new Object[]{"<+\\s*\\w*\\s*(oncontrolselect|oncopy|oncut|ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|ondeactivate|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop|onerror=|onerroupdate|onfilterchange|onfinish|onfocus|onfocusin|onfocusout|onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|onmousemove|onmousout|onmouseover|onmouseup|onmousewheel|onmove|onmoveend|onmovestart|onabort|onactivate|onafterprint|onafterupdate|onbefore|onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|onbeforeeditocus|onbeforepaste|onbeforeprint|onbeforeunload|onbeforeupdate|onblur|onbounce|oncellchange|onchange|onclick|oncontextmenu|onpaste|onpropertychange|onreadystatechange|onreset|onresize|onresizend|onresizestart|onrowenter|onrowexit|onrowsdelete|onrowsinserted|onscroll|onselect|onselectionchange|onselectstart|onstart|onstop|onsubmit|onunload)+\\s*=+", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL});
        return ret;
    }

    private static List<Pattern> getPatterns() {
        if (patterns == null) {
            List<Pattern> list = new ArrayList<Pattern>();
            String regex = null;
            Integer flag = null;
            int arrLength = 0;
            for (Object[] arr : getXssPatternList()) {
                arrLength = arr.length;
                for (int i = 0; i < arrLength; i++) {
                    regex = (String) arr[0];
                    flag = (Integer) arr[1];
                    list.add(Pattern.compile(regex, flag));
                }
            }
            patterns = list;
        }
        return patterns;
    }

    public static String cleanXSS(String value) {
        if (StringUtils.isNotBlank(value)) {
            Matcher matcher = null;
            for (Pattern pattern : getPatterns()) {
                matcher = pattern.matcher(value);
                if (matcher.find()) {
                    value = matcher.replaceAll("");
                }
            }
            value = value.replaceAll("<", "<").replaceAll(">", ">");
        }
        return value;
    }

    public static void main(String[] args) {
        String value = null;
        value = XXSUtils.cleanXSS("<script language=text/javascript>alert(document.cookie);</script>");
        System.out.println("type-1: '" + value + "'");
        value = XXSUtils.cleanXSS("<script src='' onerror='alert(document.cookie)'></script>");
        System.out.println("type-2: '" + value + "'");
        value = XXSUtils.cleanXSS("</script>");
        System.out.println("type-3: '" + value + "'");
        value = XXSUtils.cleanXSS(" eval(abc);");
        System.out.println("type-4: '" + value + "'");
        value = XXSUtils.cleanXSS(" expression(abc);");
        System.out.println("type-5: '" + value + "'");
        value = XXSUtils.cleanXSS("<img src='' onerror='alert(document.cookie);'></img>");
        System.out.println("type-6: '" + value + "'");
        value = XXSUtils.cleanXSS("<img src='' onerror='alert(document.cookie);'/>");
        System.out.println("type-7: '" + value + "'");
        value = XXSUtils.cleanXSS("<img src='' onerror='alert(document.cookie);'>");
        System.out.println("type-8: '" + value + "'");
        value = XXSUtils.cleanXSS("<script language=text/javascript>alert(document.cookie);");
        System.out.println("type-9: '" + value + "'");
        value = XXSUtils.cleanXSS("<script>window.location='url'");
        System.out.println("type-10: '" + value + "'");
    }

}
