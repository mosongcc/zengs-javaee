package org.springframework.extend.sqlxml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import java.util.HashMap;
import java.util.Map;

/**
 * Spring xml 扩展解析
 */
public class SqlMappperNamespaceHandlerSupport extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("handle",new SqlMapperHandleAbstractSingleBeanDefinitionParser());
    }

    /**
     * spring扩展xml标签解析
     */
    private class SqlMapperHandleAbstractSingleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{
        @Override
        protected Class<?> getBeanClass(Element element) {
            return SqlMapperHandle.class;
        }

        @Override
        protected void doParse(Element element, BeanDefinitionBuilder builder) {
            String id = element.getAttribute("id");
            String clearLine = element.getAttribute("clearLine");
            Map<String,String> sqlMapper = new HashMap<>();
            System.out.println("=================");
            System.out.println(element.getNodeName());


            NodeList nodeList = element.getOwnerDocument().getChildNodes();
            for (int i = 0;i<nodeList.getLength();i++) {
                Node node = nodeList.item(i);
                System.out.println(node.getNodeName());
                String key = "";//subDoc.getAttribute("name");
                String value = "";//subDoc.getTextContent();
                if("true".equals(clearLine)){
                    //Clean up the line breaks and Spaces
                    value = value.replaceAll("\\n","");
                    while (value.indexOf("  ")>-1){ value = value.replaceAll("  "," "); }
                }
                sqlMapper.put(key,value);
            }
            builder.addPropertyValue("sqlMapper",sqlMapper);
        }
    }

}