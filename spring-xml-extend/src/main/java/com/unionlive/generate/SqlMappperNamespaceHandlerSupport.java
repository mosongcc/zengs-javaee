package com.unionlive.generate;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;

public class SqlMappperNamespaceHandlerSupport extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("select",new AbstractSingleBeanDefinitionParser(){
            @Override
            protected void doParse(Element element, BeanDefinitionBuilder builder) {
                builder.addPropertyValue("id", element.getAttribute("id"));
                builder.addPropertyValue("value", element.getTextContent());
            }

            @Override
            protected Class<?> getBeanClass(Element element) {
                return SqlMapper.class;
            }
        });
    }
}