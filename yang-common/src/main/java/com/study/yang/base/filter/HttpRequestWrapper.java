package com.study.yang.base.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Iterator;
import java.util.Map;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/11 上午9:23
 * @Description
 */
public class HttpRequestWrapper extends HttpServletRequestWrapper {

    public HttpRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        // 遍历每一个参数，检查是否含有
        String[] encodedValues = new String[count];
        for (int i = 0; i < count; i++) {
            encodedValues[i] = XXSUtils.cleanXSS(values[i]);
        }
        return encodedValues;
    }

    public String getServletPath() {
        return XXSUtils.cleanXSS(super.getServletPath());
    }

    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        if (value == null) {
            return null;
        }
        return XXSUtils.cleanXSS(value);
    }

    public String getHeader(String name) {
        String value = super.getHeader(name);
        if (value == null)
            return null;
        return XXSUtils.cleanXSS(value);
    }

    public Map<String, String[]> getParameterMap() {
        Map<String, String[]> map = super.getParameterMap();
        if (map != null) {
            Iterator<Map.Entry<String, String[]>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String[]> entry = it.next();
                String[] encodedValues = entry.getValue();
                for (int i = 0; i < encodedValues.length; i++) {
                    encodedValues[i] = XXSUtils.cleanXSS(encodedValues[i]);
                }
            }
        }
        return map;
    }
}
