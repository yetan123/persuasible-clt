package com.simplify.utils;

import com.simplify.model.dto.CustomerVO;
import com.simplify.model.entity.Customer;
import com.simplify.model.entity.Linkman;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 导入导出Excel
 * @author lanmu
 * @date 2019/12/28
 */
public class ExcelUtil {
    public static List<Customer>  listCustomerByExcel(Workbook workbook) {
        List<Customer> customers = new ArrayList<>();
        if(workbook != null) {
            // 循环工作表Sheet
            for (int numSheet = 0; numSheet <workbook.getNumberOfSheets(); numSheet++) {
                Sheet hssfSheet = workbook.getSheetAt(numSheet);
                if (hssfSheet == null) {
                    continue;
                }
                // 循环行Row
                for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                    Row hssfRow = hssfSheet.getRow(rowNum);
                    Customer customer = null;
                    Linkman linkman = null;
                    if (hssfRow != null) {
                        customer = new Customer();
                        linkman = new Linkman();
                        linkman.setId(new SnowFlake(0, 0).nextId());
                        customer.setId(new SnowFlake(0, 0).nextId());
                        linkman.setCustomerId(customer.getId());
                        linkman.setCustomerName(hssfRow.getCell(0) == null ? "" : hssfRow.getCell(0).toString());
                        linkman.setGenders(hssfRow.getCell(1) == null ? "" : hssfRow.getCell(1).toString());
                        Cell phone = hssfRow.getCell(2);
                        phone.setCellType(CellType.STRING);
                        linkman.setPhone(phone.getStringCellValue());
                        customer.setCompanyName(hssfRow.getCell(3) == null ? "" : hssfRow.getCell(3).toString());
                        customer.setCompanyEmail(hssfRow.getCell(4) == null ? "" : hssfRow.getCell(4).toString());
                        Cell specialPlane = hssfRow.getCell(5);
                        specialPlane.setCellType(CellType.STRING);
                        customer.setSpecialPlane(specialPlane.getStringCellValue());
                        customer.setCompanyAddress(hssfRow.getCell(6) == null ? "" :hssfRow.getCell(6).toString());
                        customer.setTrade(hssfRow.getCell(7) == null ? "" : hssfRow.getCell(7).toString());
                        Cell scale = hssfRow.getCell(8);
                        scale.setCellType(CellType.STRING);
                        customer.setCompanyScale(hssfRow.getCell(8) == null ? "" : scale.getStringCellValue());
                        customer.setCustomerState(hssfRow.getCell(9) == null ? "" :hssfRow.getCell(9).toString());
                        customer.setCustomerCategory(hssfRow.getCell(10) == null ? "" :hssfRow.getCell(10).toString());
                        customer.setCustomerRank(hssfRow.getCell(11) == null ? "" :hssfRow.getCell(11).toString());
                        customer.setLinkman(linkman);
                        customers.add(customer);
                    }
                }
            }
        }
        return customers;
    }
    public static Workbook  getWorkBook(MultipartFile file) {
        //获得文件名
        String fileName = file.getOriginalFilename();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = file.getInputStream();
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
                e.printStackTrace();
        }
        return workbook;
    }

    public static Workbook  getWorkBook(String filename) {
        File file = new File(filename);
        //获得文件名
        String fileName = file.getName();
        //创建Workbook工作薄对象，表示整个excel
        Workbook workbook = null;
        try {
            //获取excel文件的io流
            InputStream is = new FileInputStream(file);
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
            if(fileName.endsWith("xls")){
                //2003
                workbook = new HSSFWorkbook(is);
            }else if(fileName.endsWith("xlsx")){
                //2007
                workbook = new XSSFWorkbook(is);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }
}
