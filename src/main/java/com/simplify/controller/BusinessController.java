package com.simplify.controller;

import com.simplify.model.dto.BusinessDTO;
import com.simplify.model.dto.BusinessInfoDTO;
import com.simplify.model.dto.BusinessVO;
import com.simplify.model.vo.BusinessLinkmanVO;
import com.simplify.service.BusinessDTOService;
import com.simplify.service.BusinessService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.simplify.utils.SnowFlake;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商机控制器,负责对商机实体的业务分发
 * @author yanghong
 * @date 2019-12-18
 */
@RestController
@RequestMapping("business")
@CrossOrigin
public class BusinessController {


}
