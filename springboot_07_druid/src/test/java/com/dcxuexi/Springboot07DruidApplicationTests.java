package com.dcxuexi;

import com.dcxuexi.dao.UserDao;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class Springboot07DruidApplicationTests {
    @Autowired
    public UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println(userDao.getById(1));

    }

    @Test
    void filetest() {
        try {
			/*  url������ĵ�·��������
			eg:"�ĵ�·��...\\�ĵ���.xls"      */
            String url = "C:\\java\\test.xlsx";

            //1:����workbook
            Workbook workbook = Workbook.getWorkbook(new File(url));   //�����������ĵ���·��������
			//2:��ȡ��һ��������sheet
			Sheet sheet=workbook.getSheet(0);  //�±��0��ʼ��ʾ��һ��������
			//3:��ȡ����
			for(int i=1;i<sheet.getRows();i++)    //����
			{
				for(int j=0;j<sheet.getColumns();j++)   //����
				{
					Cell cell=sheet.getCell(j,i);  //����һ����Ԫ��  ����ע��j i��˳��Ҫ�ߵ�
					System.out.print(cell.getContents()+" "); //��ȡ��Ԫ�����ݲ����
				}
				System.out.println(); //����
			}
			//4���ر���Դ
			workbook.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
