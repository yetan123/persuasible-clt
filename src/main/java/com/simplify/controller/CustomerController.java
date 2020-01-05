package com.simplify.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.simplify.model.dto.CustomerVO;
import com.simplify.model.dto.UserVO;
import com.simplify.model.entity.*;
import com.simplify.service.CustomerConverService;
import com.simplify.service.CustomerService;
import com.simplify.service.LinkmanService;
import com.simplify.service.UserService;
import com.simplify.utils.ExcelUtil;
import com.simplify.utils.SnowFlake;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * 客户控制器，负责对客户业务的分发
 * @author lanmu
 * @date 2019/12/18
 */
@RestController
@RequestMapping("customer")
@CrossOrigin
public class CustomerController {
    @Resource
    CustomerService customerService;
    @Resource
    UserService userService;
    @Resource
    CustomerConverService customerConverService;
    @Resource
    LinkmanService linkmanService;


    @PostMapping("/list")
    public PageInfo<CustomerVO> listCustomer(@RequestBody Map params) throws ParseException {
        return getPageInfo(filterParamsConver(params), params.get("pageType").toString());
    }

    @PostMapping("/import")
    public void readExcel(MultipartFile file, @RequestParam("id") String id) {
        List<Customer> customers = ExcelUtil.listCustomerByExcel(ExcelUtil.getWorkBook(file));
        for(Customer customer: customers) {
            customer.setCreateTime(new Date());
            customer.setCustomerSourceId(new Long(0).longValue());
            customer.setUserId(Long.valueOf(id));
            customerService.saveCustomer(customer);
            linkmanService.saveLinkman(customer.getLinkman());
        }
    }

    @GetMapping("/listConvertUser")
    public List<UserVO> listConvertUser(String id) {
        return userService.listUserByNotId(id);
    }

    @PostMapping("/saveConvert")
    public int saveConvert(@RequestBody CustomerConver customerConver) {
        customerService.updateCustomerUserIdById(customerConver.getCustomerId().toString(), customerConver.getReceiveUserId().toString());
        customerConver.setId(new SnowFlake(0,0).nextId());
        customerConverService.saveConverCustomer(customerConver);
        return 2;
    }

    @GetMapping("deleteCustomer")
    public int deleteCustomer(Long id) {
        // 删除客户联系人
        linkmanService.deleteLinkmanByCustomerId(id);
        return customerService.deleteCustomerById(id);
    }

    @PostMapping("saveCustomer")
    public int saveCustomer(@RequestBody Customer customer) {
        customer.setId(new SnowFlake(0, 0).nextId());
        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        Date createTime = Date.from(nowTime.atZone(ZoneId.systemDefault()).toInstant());
        customer.setCreateTime(createTime);
        if(Objects.equals("", customer.getCustomerState()) || customer.getCustomerState() == null) {
            customer.setCustomerState("无状态");
        }
        int customerResult = customerService.saveCustomer(customer);

        Linkman linkman = customer.getLinkman();
        linkman.setCustomerId(customer.getId());
        int linkmanResult = linkmanService.saveLinkman(linkman);
        return customerResult + linkmanResult;
    }

    /**
     * 客户管理筛选数据的初始化
     * @return json
     */
    @GetMapping("/filterDataInit")
    public Map<String, List<?>> filterDataInit() {
        return listState();
    }

    @GetMapping("/downloadExcel")
    public ResponseEntity<byte[]> downloadExcel(HttpServletRequest request) {
        return ExcelUtil.downloadExcel(request);
    }

    @GetMapping("/exportExcel")
    public ResponseEntity<byte[]> exportExcel(String id) {
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("userId", id);
        List<CustomerVO> customerVOS = customerService.listCustomerAndLinkman(parmas);
        return ExcelUtil.exportExcel(customerVOS);
    }

    @PostMapping("/saveLinkman")
    public int saveLinkman(@RequestBody Linkman linkman) {
        return linkmanService.saveLinkman(linkman);
    }

    /**
     * 获取分页信息
     * @param params: 前端发送过来的参数
     * pageType:用什么页面获取分页这里用来判断调用什么方法。
     * 客户管理一共三个页面：我的客户,我转交的,转交我的
     * 名称对应客户管理三个用来显示数据.vue文件
     * @return pageInfo
     * @auhor lanmu
     * @date 2019/12/21 17:29
     */
    private PageInfo<CustomerVO> getPageInfo(Map params, String pageType) throws ParseException {
        int pageNum = 1;
        int pageSize = 5;
        List<CustomerVO> customers = null;
        if(params.get("pageNum") != null) {
            pageNum = (Integer) params.get("pageNum");
        }
        if(params.get("pageSize") != null) {
            pageSize = (Integer) params.get("pageSize");
        }
       PageHelper.startPage(pageNum, pageSize, true);
        // 我的客户
        if("my".equals(pageType)) {
            customers = customerService.listCustomerAndLinkman(params);
            // 我转交的
        } else if("i_pass".equals(pageType)) {
            customers = customerService.listConver(params);
        } else if("pass_me".equals(pageType)) {
            customers = customerService.listConverToMe(params);
        }
        PageInfo<CustomerVO> page = new PageInfo<>(customers);
        return page;
    }

    /**
     * 获取筛选数据方法
     * @return Map
     * @author lanmu
     * @date 2019/12/21 17:30
     */
    private Map<String, List<?>> listState() {
        Map<String, List<?>> filterDataMap = new HashMap<>();
        List<CustomerCategory> customerCategories = customerService.listCustomerCategory();
        List<CustomerRank> customerRanks = customerService.listCustomerRank();
        List<CustomerState> customerStates = customerService.listCustomerState();
        List<CustomerSource> customerSources = customerService.listCustomerSource();
        filterDataMap.put("categorys", customerCategories);
        filterDataMap.put("ranks", customerRanks);
        filterDataMap.put("states", customerStates);
        filterDataMap.put("sources", customerSources);
        return filterDataMap;
    }

    private Map filterParamsConver(Map params) throws ParseException {
        if(params.get("customerFollowDate") != null && !"".equals(params.get("customerFollowDate"))) {
           String  customerCreateDate = params.get("customerFollowDate").toString();
            params.put("customerFollowDate", converTime(customerCreateDate));
        }
        if(params.get("customerCreateDate") != null) {
            Object createDate = params.get("customerCreateDate");
            if (createDate != null && createDate instanceof ArrayList) {
                ArrayList listDate = (ArrayList) params.get("customerCreateDate");
                params.put("createStartDate", converTime(listDate.get(0).toString()));
                params.put("createEndDate", converTime(listDate.get(1).toString()));
            } else {
                params.put("createStartDate", null);
                params.put("createEndDate", null);
            }
        }
        System.out.println("params：" + params);
        return params;
    }

    private String converTime(String time) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date parse = df.parse(time);
        SimpleDateFormat df1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
        Date date1 = df1.parse(parse.toString());
        df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date1);
    }

    @ResponseBody
    @GetMapping("/selectById")
    public CustomerVO selectById(String id){
       CustomerVO customerVO = customerService.selectByID(id);
        return customerVO;
    }

    @ResponseBody
    @GetMapping("/selectALL")
    public List<Customer> selectALL(){
        return customerService.selectALL();
    }
}

