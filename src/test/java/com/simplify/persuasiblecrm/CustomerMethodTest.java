package com.simplify.persuasiblecrm;

import com.simplify.model.dto.CustomerVO;
import com.simplify.model.entity.Customer;
import com.simplify.service.CustomerService;
import com.simplify.service.LinkmanService;
import com.simplify.utils.ExcelUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class CustomerMethodTest {
    @Resource
    LinkmanService linkmanService;
    @Test
    public void method() {
    }
}
