package com.zing;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON字符串生成POJO实体类文件
 */
public class JsonGeneratePojo {

    private ObjectMapper objectMapper = new ObjectMapper();

    private DefaultName defaultName = new DefaultName();

    private boolean isJsonAnnotation = false;

    /**
     * 设置为true，添加JSON注解
     * @param b
     */
    public void setJsonAnnotation(boolean b){
        this.isJsonAnnotation = b;
    }

    /**
     * 设置属性名称输出规则
     * @param pojoNameImpl
     */
    public void setDefaultName(DefaultName pojoNameImpl){
        this.defaultName = pojoNameImpl;
    }

    /**
     * 生成文件保存路径，可为绝对路径，默认为空，项目目录
     */
    private String filePath = "";

    public JsonGeneratePojo(){
    }
    public JsonGeneratePojo(String filePath){
        this.filePath = filePath;
    }


    /**
     * 生成JSON 对应Java实体类
     * @param classPackage 生成的包名，包含类名
     * @param json 需要一个key-value格式JSON，如何是集合，只需取第一个
     */
    public void start(String classPackage,String json) throws IOException {
        System.out.println("*******************************************");
        System.out.println("Start json generate pojo file...");

        Map<String,Object> objectMap = objectMapper.readValue(json,Map.class);
        this.generatePojo(classPackage,objectMap);

        System.out.println("Build Success");
        System.out.println("*******************************************");
    }

    /**
     * 递归生成代码
     * @param classPackage
     * @param obj
     * @throws IOException
     */
    private void generatePojo(String classPackage,Object obj) throws IOException {
        if(obj instanceof Map){
            List<String[]> list = new ArrayList<>();
            Map<String,Object> objectMap = (Map<String, Object>) obj;
            for (Map.Entry<String,Object> map:objectMap.entrySet()){
                String k = map.getKey();
                Object v = map.getValue();
                if(v instanceof Map){
                    //Map类型生成实体类
                    String[] attribute = {defaultName.className(k),k};//0 类型 1名字
                    list.add(attribute);
                    this.generatePojo(UtilsMethod.replaceClassName(classPackage,k),v);
                }else if(v instanceof List){
                    //List类型生成实体类，只取一个Map获取结构信息
                    String[] attribute = {"List<"+defaultName.className(k)+">",k};//0 类型 1名字
                    list.add(attribute);
                    for (Object o : (List) v) {
                        this.generatePojo(UtilsMethod.replaceClassName(classPackage,k),o);
                        break;
                    }
                }else{
                    //普通类型直接输出字段
                    String type = v.getClass().getSimpleName();
                    String[] attribute = {type,k};//0 类型 1名字
                    list.add(attribute);
                }
            }
            writeFile(classPackage,list);
        }
        if(obj instanceof List){
            List<Object> list = (List<Object>) obj;
            for (Object o : list) {
                this.generatePojo(classPackage,o);
                break;
            }
        }
    }

    /**
     * 生成代码，写入文件
     * @param classPath
     * @param list
     * @throws IOException
     */
    private void writeFile(String classPath,List<String[]> list) throws IOException {

        StringBuffer builder = new StringBuffer("package #package#;#br#");
        builder.append("#br##import##br##br#");
        builder.append("public class #className# { #br##br#");
        list.forEach((v)->{
            if(isJsonAnnotation){
                builder.append("\t@JsonProperty(\""+v[1]+"\") #br#");
            }
            String attr = "\tprivate #type# #attribute#; #br#";
            attr = attr.replace("#type#",v[0]).replace("#attribute#",defaultName.attrName(v[1]));
            builder.append(attr);
        });
        builder.append("#br#");
        list.forEach((v)->{
            StringBuffer method = new StringBuffer();
            method.append("\tpublic #type# #getMethod#(){#br#");
            method.append("\t\treturn #attribute#; #br#");
            method.append("\t}#br#");

            method.append("\tpublic void #setMethod#(#type# #attribute#){#br#");
            method.append("\t\tthis.#attribute# = #attribute#; #br#");
            method.append("\t}#br#");

            String gsMethod = method.toString()
                    .replaceAll("#type#",v[0])
                    .replaceAll("#attribute#",defaultName.attrName(v[1]))
                    .replaceAll("#getMethod#",defaultName.getMethodName(v[1]))
                    .replaceAll("#setMethod#",defaultName.setMethodName(v[1]));

            builder.append(gsMethod);
        });
        builder.append("}#br#");
        String br = System.getProperty("line.separator");

        StringBuffer sbimport = new StringBuffer();
        if(builder.indexOf("List")>0){
            sbimport.append("import java.util.List;#br#");
        }
        if(builder.indexOf("JsonProperty")>0){
            sbimport.append("import com.fasterxml.jackson.annotation.JsonProperty;#br#");
        }

        String packageName = classPath.substring(0,classPath.lastIndexOf("."));
        String className = classPath.substring(classPath.lastIndexOf(".")+1);
        className = defaultName.className(className);
        String javaCode = builder.toString()
                .replace("#package#",packageName)
                .replace("#import#",sbimport)
                .replace("#className#",className)
                .replaceAll("#br#",br);

        String path = filePath+File.separator+packageName.replaceAll("\\.","/");
        File file = new File( path);
        if(!file.exists()){
            file.mkdirs();
        }
        File javaFile = new File(path+File.separator+className+".java");
        System.out.println("Build file:"+javaFile.getPath());
        FileUtils.writeStringToFile(javaFile,javaCode,"UTF-8");
    }

}
