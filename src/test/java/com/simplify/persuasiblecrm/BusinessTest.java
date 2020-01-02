package com.simplify.persuasiblecrm;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.entity.Business;
import com.simplify.service.BusinessDTOService;
import com.simplify.service.BusinessService;
import com.simplify.utils.SnowFlake;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BusinessTest {

    @Resource
    BusinessService businessService;

    @Resource
    BusinessDTOService businessDTOService;


    @Test
    public void deleteBusinessById(){
        Long id = new Long(10);
        businessService.deleteBusinessById(id);
    }


}
