package com.simplify.controller;



import com.simplify.model.dto.TasksDTO;
import com.simplify.model.entity.CustomerTasks;
import com.simplify.service.CustomerTasksService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("CustomerTasks")
public class CustomerTasksController {
    @Autowired
    private CustomerTasksService customerTasksService;

    @ResponseBody
    @RequestMapping("/findAllCustomerTasks")
    public List<CustomerTasks> findAllCustomerTasks(){
        return customerTasksService.selectAllTasksCustomerTasks();
    }


    @ResponseBody
    @GetMapping("/deleteCustomerTasks")
    public int deleteCustomerTasks(Long id){
        return customerTasksService.deleteCustomerTasks(id);
    }

    @ResponseBody
    @PostMapping("/insertCustomerTasks")
    public int insertCustomerTasks(@RequestBody TasksDTO tasks){
        System.out.println(tasks);
        CustomerTasks c = new CustomerTasks();
        c.setId(new SnowFlake(0,0).nextId());
        c.setTaskName(tasks.getName());
        c.setCustomerId(tasks.getCustomer());
        c.setLinkmanId(tasks.getCustomer());
        c.setTaskContent(tasks.getContent());
        c.setTaskStartTime(tasks.getDate1());
        c.setTaskEndTime(tasks.getDate2());
        c.setTaskParticipant(tasks.getParticipant());
        return customerTasksService.insertCustomerTasks(c);
    }
}
