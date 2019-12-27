package com.simplify.controller;

import com.simplify.model.entity.Clue;
import com.simplify.service.ClueService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "clue")
@CrossOrigin
public class ClueController {
    @Resource
    ClueService clueService;
    @GetMapping(value = "list")
    public  List<Clue> getAllClue(){
        List<Clue> clueList = clueService.getAllClue();
        for (Clue clue: clueList
        ) {
            System.out.println(clue);
        }
        System.out.println("跳转成功1");
        return clueService.getAllClue();
    }
}
