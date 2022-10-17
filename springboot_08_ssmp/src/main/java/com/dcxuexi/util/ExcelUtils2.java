package com.dcxuexi.util;

import com.dcxuexi.domian.PlatformUser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/***
 * @Title ExcelUtils2
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 21:43
 * @Version 1.0.0
 */
public class ExcelUtils2 {


    public static void excel(String filePath) throws Exception{
        InputStream inp = new FileInputStream(new File(filePath));//输入流
        // 获取工作簿
        String extString = filePath.substring(filePath.lastIndexOf("."));
        Workbook workbook = null;
        if (extString.equals(".xls")) workbook = new HSSFWorkbook(inp); //一个excel用一个HSSFWorkbook
        else if (extString.equals(".xlsx")) workbook = new XSSFWorkbook(inp);
        else {
            System.out.println("错误的文件类型:" + extString);

        }
        //获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 获取行
        for (Row row: sheet
             ) {
            //获取列
            for (Cell cell: row
                 ) {
                // 获取单元格内容
                cell.setCellType(CellType.STRING);
                String stringCellValue = cell.getStringCellValue();

                System.out.println(stringCellValue);
                System.out.println(" ==== ");
            }
            System.out.println("/n");
        }
        //释放资源
        workbook.close();
    }




}
