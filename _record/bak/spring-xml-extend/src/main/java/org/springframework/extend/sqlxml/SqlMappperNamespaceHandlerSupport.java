package org.springframework.extend.sqlxml;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;

/**
 * Spring xml 扩展解析
 */
public class SqlMappperNamespaceHandlerSupport extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("select",new SqlMapperAbstractSingleBeanDefinitionParser());
        registerBeanDefinitionParser("insert",new SqlMapperAbstractSingleBeanDefinitionParser());
        registerBeanDefinitionParser("update",new SqlMapperAbstractSingleBeanDefinitionParser());
        registerBeanDefinitionParser("delete",new SqlMapperAbstractSingleBeanDefinitionParser());
    }

    /**
     * spring扩展xml标签解析
     */
    private class SqlMapperAbstractSingleBeanDefinitionParser extends AbstractSingleBeanDefinitionParser{
        @Override
        protected Class<?> getBeanClass(Element element) {
            return SqlMapper.class;
        }

        @Override
        protected void doParse(Element element, BeanDefinitionBuilder builder) {
            String id = element.getAttribute("id");
            String clearLine = element.getAttribute("clearLine");
            String value = element.getTextContent();
            if("true".equals(clearLine)){
                //Clean up the line breaks and Spaces
                value = value.replaceAll("\\n","");
                while (value.indexOf("  ")>-1){ value = value.replaceAll("  "," "); }
            }
            builder.addPropertyValue("id",id);
            builder.addPropertyValue("value",value);
        }
    }

}