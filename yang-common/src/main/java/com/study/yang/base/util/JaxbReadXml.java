package com.study.yang.base.util;


import com.study.yang.exception.BizException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.MessageFormat;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/26 下午2:29
 * @Description xml和对象转换工具
 */
public class JaxbReadXml {

    /**
     * 将xml解析为对应的类
     * @param clazz
     * @param context xml文件地址
     * @return
     * @throws JAXBException
     * @throws BizException
     */
    @SuppressWarnings("unchecked")
    public static <T> T readString(Class<T> clazz, String context) throws BizException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(new File(context));
        } catch (JAXBException e) {
            throw new BizException(e);
        }
    }
    /**
     * 将xml解析为对应的类
     * @param clazz
     * @param xml xml字符串
     * @return
     * @throws BizException
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(Class<T> clazz,String xml) throws BizException {
        try {
            StringReader reader = new StringReader(xml);
            JAXBContext jc = JAXBContext.newInstance(clazz);
            return (T) jc.createUnmarshaller().unmarshal(reader);
        } catch (JAXBException e) {
            throw new BizException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T readConfig(Class<T> clazz, String config, Object... arguments) throws IOException,
            JAXBException {
        InputStream is = null;
        try {
            if (arguments.length > 0) {
                config = MessageFormat.format(config, arguments);
            }
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            is = new FileInputStream(config);
            return (T) u.unmarshal(is);
        } catch (IOException e) {
            throw e;
        } catch (JAXBException e) {
            throw e;
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T readConfigFromStream(Class<T> clazz, InputStream dataStream) throws BizException {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();
            return (T) u.unmarshal(dataStream);
        } catch (JAXBException e) {
            throw new BizException(e);
        }
    }

    /**
     * Java to XML
     * @param rootObject 根对象, Xml 根标签对应的对象
     * @return sw 输出流，该方法将xml数据写入该输出流
     * @throws JAXBException
     */
    public static <T> String objectToXml(T rootObject) throws BizException {
        StringWriter sw = new StringWriter();
        try{
            JAXBContext context = JAXBContext.newInstance(rootObject.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8"); // 编码格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 是否格式化生成的xml串
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false); // 是否省略xml头信息

            marshaller.marshal(rootObject, sw);
        }catch(JAXBException e){
            throw new BizException(e);
        }
        return sw.toString();
    }
}