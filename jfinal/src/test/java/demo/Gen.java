package demo;

import com.alibaba.druid.pool.DruidDataSource;
import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

/**
 *
 */
public class Gen {

    public static void main(String[] args) {
        System.out.println(PathKit.getWebRootPath());
        gernerator();
    }

    private static void gernerator(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:oracle:thin:@//180.169.17.69:1521/orcl");
        druidDataSource.setUsername("unionlive");
        druidDataSource.setPassword("unionlive");
        druidDataSource.setValidationQuery("select 1 FROM DUAL");

        Db.query("");
        Db.find("");

        Record record = new Record();

        Db.save("",record);

        /*DruidPlugin dp = new DruidPlugin(
                "jdbc:oracle:thin:@//180.169.17.69:1521/orcl",
                "unionlive",
                "unionlive");
        dp.setValidationQuery("select 1 FROM DUAL");
        dp.start();*/

        // base model 所使用的包名
        String baseModelPkg = "com.ul.app.model.base";
        // base model 文件保存路径
        String baseModelDir = PathKit.getWebRootPath() + "/../src/main/java/com/ul/app/model/base";
        // model 所使用的包名
        String modelPkg = "model";
        // model 文件保存路径
        String modelDir = baseModelDir + "/..";
        Generator gernerator = new Generator(druidDataSource, baseModelPkg, baseModelDir,
                modelPkg, modelDir);
        //不需要生成的表
        gernerator.addExcludedTable("");
        gernerator.generate();
    }
}
