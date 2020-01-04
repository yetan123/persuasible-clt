package com.simplify.service.impl;

import com.simplify.mapper.BusinessParticipantMapper;
import com.simplify.mapper.BusinessTaskMapper;
import com.simplify.model.dto.BusinessTaskDTO;
import com.simplify.model.dto.BusinessTaskPrincipalDTO;
import com.simplify.model.entity.BusinessTask;
import com.simplify.model.entity.BusinessTaskPrincipal;
import com.simplify.model.vo.BusinessTaskVO;
import com.simplify.model.vo.PrincipalBusinessTaskVO;
import com.simplify.service.BusinessTaskService;
import com.simplify.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 商机任务业务实现类
 * @author yuntian
 * @date 2020-1-3
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BusinessTaskServiceImpl implements BusinessTaskService {
    @Autowired
    private BusinessTaskMapper businessTaskMapper;
    @Autowired
    private BusinessParticipantMapper businessPrincipalMapper;
    @Cacheable("businessTask")
    @Override
    public List<BusinessTaskVO> listBusinessTask(Long businessId) {
        List<BusinessTask> businessesTask = businessTaskMapper.listBusinessTaskByBusinessId(businessId);
        List<BusinessTaskVO> businessTaskVOS = new ArrayList<>();
        businessesTask.forEach((businessTask)->{
            BusinessTaskVO businessTaskVO = new BusinessTaskVO();
            businessTaskVO.setId(businessTask.getId().toString());
            businessTaskVO.setParticipants(businessTaskMapper.listBusinessTaskById(businessTask.getId()));
            businessTaskVO.setTaskContent(businessTask.getTaskContent());
            businessTaskVO.setTaskTime(Arrays.asList(businessTask.getTaskTime(),businessTask.getTaskFinishTime()));
            businessTaskVO.setTaskState(businessTask.getTaskState()==0?"未完成":"已完成");
            businessTaskVOS.add(businessTaskVO);
        });
        return businessTaskVOS;
    }

    @Cacheable("businessTaskPrincipal")
    @Override
    public List<PrincipalBusinessTaskVO> listPrincipalBusinessTaskVO() {
        return businessTaskMapper.listUserBusinessTaskVO();
    }
    @CacheEvict(value = {"businessTask"}, allEntries = true)
    @Override
    public Integer addBusinessTask(BusinessTaskDTO businessTaskDTO) {
        SnowFlake snowFlake = new SnowFlake(0,0);
        BusinessTask businessTask = new BusinessTask();
        businessTask.setBusinessId(Long.parseLong(businessTaskDTO.getBusinessId()));
        businessTask.setId(snowFlake.nextId());
        businessTask.setTaskContent(businessTaskDTO.getTaskContent());
        businessTask.setTaskTime(businessTaskDTO.getTaskTime().get(0));
        businessTask.setTaskFinishTime(businessTaskDTO.getTaskTime().get(1));
        businessTask.setTaskState(0);
        int count = 0;
        count+=businessTaskMapper.addBusinessTask(businessTask);
        BusinessTaskPrincipalDTO businessTaskPrincipalDTO = new BusinessTaskPrincipalDTO();
        businessTaskPrincipalDTO.setTaskId(businessTask.getId());
        businessTaskPrincipalDTO.setUserIds(new ArrayList<>());
        businessTaskDTO.getParticipants().forEach((participant)->{
            businessPrincipalMapper.insert(new BusinessTaskPrincipal(snowFlake.nextId(),businessTask.getId()
                    ,Long.parseLong(participant)));
        });
        return count;
    }

    @CacheEvict(value = {"businessTask"}, allEntries = true)
    @Override
    public Integer deleteBusinessTask(Long id) {
        Example example = new Example(BusinessTaskPrincipal.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("taskId",id);
        businessPrincipalMapper.deleteByExample(example);
        return businessTaskMapper.deleteByPrimaryKey(id);
    }

    @CacheEvict(value = {"businessTask"}, allEntries = true)
    @Override
    public Integer updateBusinessTask(BusinessTaskDTO businessTaskDTO) {
        BusinessTask businessTask = new BusinessTask();
        businessTask.setId(Long.parseLong(businessTaskDTO.getId()));
        businessTask.setTaskContent(businessTaskDTO.getTaskContent());
        businessTask.setTaskTime(businessTaskDTO.getTaskTime().get(0));
        businessTask.setTaskFinishTime(businessTaskDTO.getTaskTime().get(1));
        int count = 0;
        count+=businessTaskMapper.updateByPrimaryKeySelective(businessTask);
        BusinessTaskPrincipalDTO businessTaskPrincipalDTO = new BusinessTaskPrincipalDTO();
        businessTaskPrincipalDTO.setTaskId(businessTask.getId());
        businessTaskPrincipalDTO.setUserIds(new ArrayList<>());
        SnowFlake snowFlake = new SnowFlake(0,0);
        businessTaskDTO.getParticipants().forEach((participant)->{
            businessPrincipalMapper
                    .addBusinessParticipant(new BusinessTaskPrincipal(snowFlake.nextId(),businessTask.getId()
                            ,Long.parseLong(participant)));
            businessTaskPrincipalDTO.getUserIds().add(Long.parseLong(participant));
        });
        businessPrincipalMapper.removeBusinessParticipant(businessTaskPrincipalDTO);
        return count;
    }

    @CacheEvict(value = {"businessTask"}, allEntries = true)
    @Override
    public Integer changeBusinessTaskById(Long id) {
        return businessTaskMapper.changeBusinessTaskById(id);
    }
}
