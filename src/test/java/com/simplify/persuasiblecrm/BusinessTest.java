package com.simplify.persuasiblecrm;

import com.simplify.model.entity.Business;
import com.simplify.service.BusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BusinessTest {

    @Resource
    BusinessService businessService;

    @Test
    public void selectAll(){
        List<Business> business=businessService.selectALl();
        for (Business b:business) {
            System.out.println(b);
        }
    }

    @Test
    public void listBusiness(){
        List<Business> business=businessService.listBusiness();
        for (Business b:business) {
            System.out.println(b);
        }
    }

    @Test
    public void listBusinessById(){
        Long id =new Long(1);
        List<Business> business=businessService.listBusinessById(id);
        for (Business b:business) {
            System.out.println(b);
        }
    }

    @Test
    public void deleteBusinessById(){
        Long id = new Long(5);
        businessService.deleteBusinessById(id);
    }

}
