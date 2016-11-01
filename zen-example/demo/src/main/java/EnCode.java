import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Collection;

/**
 *
 */
public class EnCode {

    public static void main(String[] args) throws Exception {

        String gbkDirPath = "D:\\workidea\\zengs-javaee\\zen-simple\\generate\\src\\main\\java\\com\\zengs";//GBK�����ʽԴ���ļ�·��
        String utf8DirPath = "D:\\UTF8\\src";//תΪUTF-8�����ʽԴ���ļ�����·��

        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//��ȡ����java�ļ�
        for (File gbkFile : gbkFileList) {
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8�����ʽ�ļ�����·��
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//ʹ��GBK�����ʽ��ȡ�ļ���Ȼ����UTF-8�����ʽд������
        }
    }

}

