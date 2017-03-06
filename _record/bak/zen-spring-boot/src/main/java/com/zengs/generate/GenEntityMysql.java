package com.zengs.generate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 生成实体类代码
 *
 */
public class GenEntityMysql {

    /*********************************************************************************/
    // 代码生成配置信息 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    //数据库连接配置信息
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://mysql.zingson.com:3306/test";
    private static final String DB_DATABASE = "test";
    private static final String DB_USERNAME = "appadmin";
    private static final String DB_PASSWORD = "appadmin.server";

    //生成文件保存路径与包名
    private static String fileDir = "D:\\workidea\\unionlive\\unionlive-waimai\\wm-boot-api\\src\\main\\java";
    private static String packagePath = "com.unionlive.domain";

    //生成实体类排除表前缀，可指定多个
    private static String[] excludes = new String[]{"pine_"};

    //待生成的表名集合,为空则生成数据库所有表
    private static String[] tableNames = new String[]{};


    /**
     * 完善页面配置信息，即可运行 生成实体类
     * 1. 数据库连接信息配置；
     * 2. 生成实体类文件保存路径；
     * 3. 生成的表
     */
    public static void main_bak(String[] args) {
        System.out.println("开始生成代码......");
        System.out.println("输出路径："+fileDir);
        if(tableNames.length>0){
            new GenEntityMysql().generate(tableNames);
        }else {
            new GenEntityMysql().generate();
        }

        System.out.println("代码生成成功！");
    }

    //↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
    /*********************************************************************************/


    /**
     * SQL 类型转 Java类型共用方法
     * 备注： 各种数据库类型太多，不完整的或者跟需求有偏差，直接调整此方法配置成想要的类型
     * @param sqlType  数据库返回的SQL字段类型，sql类型参数不区分大小写
     * @return  返回Java 类型
     */
    private String sqlType2JavaType(String sqlType) {

        if (sqlType.equalsIgnoreCase("tinyint")
                ||sqlType.equalsIgnoreCase("smallint")
                ||sqlType.equalsIgnoreCase("int")
                ||sqlType.equalsIgnoreCase("integer")
                ||sqlType.equalsIgnoreCase("boolean") //用 0 1表示
                ){
            return "Integer";
        }

        if (sqlType.equalsIgnoreCase("varchar")
                || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar")
                || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("number")    //number不确定小数位，使用String类型
                || sqlType.equalsIgnoreCase("text")) {
            return "String";
        }
        if (sqlType.equalsIgnoreCase("bigint")){ return "Long";}

        if (sqlType.equalsIgnoreCase("bit")){ return "Boolean";}

        if (sqlType.equalsIgnoreCase("float")){ return "Float";}

        if (sqlType.equalsIgnoreCase("decimal")
                || sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real")
                ||sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "Double";
        }

        if (sqlType.equalsIgnoreCase("date")) {
            imports.add("import java.sql.Date;");
            return "Date";
        }
        if (sqlType.equalsIgnoreCase("timestamp")
                || sqlType.equalsIgnoreCase("datetime")){
            imports.add("import java.sql.Timestamp;");
            return "Timestamp";
        }
        if(sqlType.equalsIgnoreCase("time")){
            imports.add("import java.sql.Time;");
            return "Time";
        }

        if (sqlType.equalsIgnoreCase("image")) {return "Blob";}

        return "null";
    }

    private Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库连接驱动 "+DB_DRIVER+" 未找到");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private void closeConnection(Connection conn){
        try {
            if(conn!=null&&!conn.isClosed()){ conn.close(); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private String[] colNames; // 列名数组
    private String[] colTypes; // 列名类型数组
    private int[]    colSizes; // 列数据长度，暂时没用到，可根据列长度来更准确选择java类型

    private Set<String> imports;  //引入包

    /**
     * 查询出数据库所有表生成代码
     */
    private void generate(){
        String t = null;
        if(DB_URL.toLowerCase().indexOf("mysql")>0){
            t = "select table_name from information_schema.tables where table_schema='"+DB_DATABASE+"' and table_type='base table'";
        }
        Connection conn = getConnection();
        try {
            if(t==null){
                throw new Exception("不支持的数据库类型");
            }
            PreparedStatement pstm = conn.prepareStatement(t);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                generate(rs.getString(1));
            }
            rs.close();
            pstm.close();
        }catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    private void generate(String[] tableNames){
        for (String tableName:tableNames) {
            generate(tableName);
        }
    }

    /**
     * 生成指定表
     * @param tableName
     */
    private void generate(String tableName){
        imports = new HashSet<>();
        Connection conn = getConnection();
        try {
            String strsql = "select * from " + tableName; //通过查询获取表结构信息
            PreparedStatement pstmt = conn.prepareStatement(strsql);
            ResultSetMetaData rsmd = pstmt.getMetaData();
            int size = rsmd.getColumnCount();
            colNames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            for (int i = 0; i < size; i++) {
                colNames[i] = initcap(rsmd.getColumnName(i+1),true);
                colTypes[i] = sqlType2JavaType(rsmd.getColumnTypeName(i+1));
                colSizes[i] = rsmd.getColumnDisplaySize(i+1);
            }
            //生成实体类
            printFile(genPackagePath(packagePath)+initcap(tableName) + ".java",parseEntity(tableName));
            //生成实体类扩展Dto
            printFile(genPackagePath(packagePath+".dto")+initcap(tableName) + "Dto.java",parseEntityDto(tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(conn);
        }
    }

    private void printFile(String pathName,String content){
        try {
            FileWriter fw = new FileWriter(pathName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成包路径
     * @return
     */
    private String genPackagePath(String pack){
        String p = pack.replaceAll("\\.","/");
        File file = new File(fileDir+p);
        if(!file.exists()){
            file.mkdirs();
        }
        return fileDir+p+"/";
    }

    /**
     * 解析处理(生成实体类主体代码)
     */
    private String parseEntity(String tableName) {
        String entityName = initcap(tableName);
        StringBuffer sb = new StringBuffer("package ").append(packagePath).append(";\r\n");
        sb.append("\r\n{{imports}}\r\n");
        sb.append("/**\r\n");
        sb.append(" * @date "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +" \r\n");
        sb.append(" * @author zengs\r\n");
        sb.append(" * @tableName "+tableName+"\r\n");
        sb.append(" * @descript \r\n *    According to the table to generate entity class\r\n");
        sb.append(" */\r\n");
        sb.append("public class " + entityName + " implements Serializable {\r\n\r\n");
        processAllAttrs(sb);
        sb.append("\r\n");
        processAllMethod(sb);
        sb.append("\r\n}\r\n\r\n");
        String importStr = "import java.io.Serializable;\r\n";
        for (String v:imports) {
            importStr += v+"\r\n";
        }
        String code = sb.toString().replace("{{imports}}",importStr);
        System.out.println(packagePath+"."+entityName + ".java");
        return code;
    }

    /**
     * 解析处理(生成实体类扩展类主体代码)
     */
    private String parseEntityDto(String tableName){
        String entityName = initcap(tableName);
        String dtoPackage = packagePath+".dto";
        String dtoFileName = entityName +"Dto.java";
        StringBuffer sb = new StringBuffer("package ").append(dtoPackage).append(";\r\n");
        sb.append("\r\n{{imports}}\r\n");
        sb.append("/**\r\n");
        sb.append(" * @date "+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) +" \r\n");
        sb.append(" * @author zengs\r\n");
        sb.append(" * @descript \r\n *    generate entity dto class\r\n");
        sb.append(" */\r\n");
        String entity = initcap(tableName);
        sb.append("public class " + entity + "Dto extends "+entity+" {\r\n\r\n");
        sb.append("\r\n\r\n}\r\n\r\n");
        String importStr = "import "+packagePath+"."+entityName+";\r\n";
        String code = sb.toString().replace("{{imports}}",importStr);
        System.out.println(dtoPackage+"."+dtoFileName);
        return code;
    }

    /**
     * 生成所有的方法
     * @param sb
     */
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            sb.append("    public void set" + initcap(colNames[i]) + "(" + colTypes[i] + " " + colNames[i] + "){\r\n");
            sb.append("        this." + colNames[i] + "=" + colNames[i] + ";\r\n");
            sb.append("    }\r\n");

            sb.append("    public " + colTypes[i] + " get" + initcap(colNames[i]) + "(){\r\n");
            sb.append("        return " + colNames[i] + ";\r\n");
            sb.append("    }\r\n");
        }
    }

    /**
     * 解析输出属性
     *
     * @return
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            sb.append("    private " + colTypes[i] + " " + colNames[i] + ";\r\n");
        }
    }

    /**
     * 把输入字符串变成驼峰命名法，且首字母大写
     * @param str
     * @return
     */
    private String initcap(String str,boolean isAttribute) {
        //生成实体类排除表前缀
        for (String exclude:excludes) {
            int i = exclude.length();
            if(str.length()>i&&exclude.equalsIgnoreCase(str.substring(0,i))){
                str = str.replaceFirst(exclude,"");
            }
        }
        char[] charArr = str.toLowerCase().toCharArray();
        //首字母大写
        if ((!isAttribute) && charArr[0] >= 'a' && charArr[0] <= 'z') {
            charArr[0] = (char) (charArr[0]-32);
        }
        //下划线后一位字母变大写
        for (int i = 1;i<charArr.length;i++) {
            if('_'==charArr[i]){
                charArr[i+1] = (char)(charArr[i+1]-32);
            }
        }
        return new String(charArr).replace("_","");
    }
    private String initcap(String str) {
        return initcap(str,false);
    }




}
