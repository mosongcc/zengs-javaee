
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.xmlbeans.impl.common.SystemCache;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.lang.System.nanoTime;

public class PoiTest{


    /**
     * 导出excel测试
     */
    public static void main(String[] args) throws Throwable {
        long beginTime = System.nanoTime();
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();
        for(int rownum = 0; rownum < 500000; rownum++){
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 10; cellnum++){
                Cell cell = row.createCell(cellnum);
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address);
            }
        }
        FileOutputStream out = new FileOutputStream("out/temp/sxssf.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();

        Long endTime = System.nanoTime();

        System.out.println((endTime-beginTime)/1000/1000/1000);
    }

    public static void xlsx() throws IOException {
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        long beginTime = System.nanoTime();
        SXSSFWorkbook wb = new SXSSFWorkbook(100); // keep 100 rows in memory, exceeding rows will be flushed to disk
        Sheet sh = wb.createSheet();

        //循环读取数据库数据

        for(int rownum = 0; rownum < list.size(); rownum++){
            Row row = sh.createRow(rownum);
            row.createCell(0).setCellValue("");
            row.createCell(1).setCellValue("");
            row.createCell(2).setCellValue("");
            row.createCell(3).setCellValue("");

        }
        FileOutputStream out = new FileOutputStream("out/temp/sxssf.xlsx");
        wb.write(out);
        out.close();
        wb.dispose();

        Long endTime = System.nanoTime();

        System.out.println((endTime-beginTime)/1000/1000/1000);
    }

}




























