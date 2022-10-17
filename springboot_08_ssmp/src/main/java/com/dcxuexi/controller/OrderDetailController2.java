package com.dcxuexi.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.dcxuexi.domian.OrderDetail;
import com.dcxuexi.domian.PlatformUser;
import com.dcxuexi.service.OrderDetailService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/***
 * @Title OrderDetailController
 * @Description TOTD
 * @Auter DongChuang
 * @Date 2022/8/28 17:37
 * @Version 1.0.0
 */

@RestController
@RequestMapping("/order2")
public class OrderDetailController2 {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/detail")
    public String getInfoOrderDetail() {


        OrderDetail orderDetail = orderDetailService.selectById(334);

        System.out.println(orderDetail);

        return orderDetail.toString();
    }

    @PostMapping("/getInfoExcel")
    public String getInfoExcel() {
        try {
            File file = new File("C:\\java\\test2.xls");
            List<PlatformUser> userLists = excel(file);

            return  userLists.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "报错";
        }
    }

    public static List<PlatformUser> readexcel(File file) throws Exception{
        return new LinkedList<>();
    }

    @GetMapping("/download")
    public void  downloadTemplateFile(HttpServletResponse response) throws IOException {
        // 模板
        String templateFile = "C:\\java\\list.xlsx";

        List<PlatformUser> data = data();
        Integer count = data.size();
        String time = "2022-09-04";

        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("用户表-导出", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).withTemplate(templateFile).build()) {
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(data,fillConfig,writeSheet);
            HashMap<String, Object> map = MapUtils.newHashMap();
            map.put("total",count);
            map.put("date",time);
            excelWriter.fill(map,fillConfig,writeSheet);

        }





    }

    private List<PlatformUser> data() {
        List<PlatformUser> list = ListUtils.newArrayList();
        for (int i = 0; i < 100; i++) {
            PlatformUser data = new PlatformUser();
            data.setUserId(i+100);
            data.setUserName("王先生"+i);
            data.setEmail("10000"+i+"@qq.com");
            data.setBranchName("上海公司"+i);
            list.add(data);
        }
        return list;
    }









    public static List<PlatformUser> excel(File file) throws Exception {
        InputStream in = new FileInputStream(file);
        // 读取整个Excel
        XSSFWorkbook sheets = new XSSFWorkbook(in);
        // 获取第一个表单Sheet
        XSSFSheet sheetAt = sheets.getSheetAt(0);
        //默认第一行为标题行，i = 0
        XSSFRow titleRow = sheetAt.getRow(0);

        // 导入数据实体类
        List<PlatformUser> userList = new LinkedList<>();

        // 读取每一格内容
        StringBuilder sb = new StringBuilder();
        XSSFCell cell = null;
        cell.setCellType(CellType.STRING);
        // 循环获取每一行数据
        for (int i = 1; i < sheetAt.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = sheetAt.getRow(i);
            // 用户信息
            PlatformUser user = new PlatformUser();
            cell = row.getCell(0);

            if (cell.getStringCellValue().isEmpty()) {
                user.setUserId(null);
            } else {
                sb.delete(0, sb.length());
                sb.append(cell);
                user.setUserId(Integer.parseInt(String.valueOf(sb)));
            }

            cell = row.getCell(1);
            if (cell.getStringCellValue().isEmpty()) {
                user.setUserName("");
            } else {
//                cell.setCellType(CellType.STRING);
                sb.delete(0, sb.length());
                sb.append(cell);
                user.setUserName(String.valueOf(sb));
            }
            cell = row.getCell(2);
            if (cell.getStringCellValue().isEmpty()) {
                user.setEmail("");
            } else {
//                cell.setCellType(CellType.STRING);
                sb.delete(0, sb.length());
                sb.append(cell);
                user.setEmail(String.valueOf(sb));
            }
            cell = row.getCell(3);
            if (cell.getStringCellValue().isEmpty()) {
                user.setBranchName("");
            } else {
//                cell.setCellType(CellType.STRING);
                sb.delete(0, sb.length());
                sb.append(cell);
                user.setBranchName(String.valueOf(sb));
            }
            userList.add(user); //对象方法list中

//            int lie = row.getPhysicalNumberOfCells();
//            for (int index = 0; index < lie; index++) {
//                XSSFCell titleCell = titleRow.getCell(index);
//                cell = row.getCell(index);
//                cell.setCellType(CellType.STRING);
//                if (cell.getStringCellValue().isEmpty()) {
//                    continue;
//                }
//                sb.append(cell);
//            }
//            System.out.println(i + "\t" + sb);
        }

        return userList;
    }















}
