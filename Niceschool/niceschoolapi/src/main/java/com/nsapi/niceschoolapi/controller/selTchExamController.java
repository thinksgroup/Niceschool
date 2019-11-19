package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.entity.LayuiResult;
import com.nsapi.niceschoolapi.entity.SelTchExamVO;
import com.nsapi.niceschoolapi.service.SelTchExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class selTchExamController {
    @Autowired
    private SelTchExamService selTchExamService;

    @RequestMapping("/tchExam")
    public String tchExam(){
        return "view/teacher/selTchExam";
    }

    @RequestMapping("/selTchExam")
    @ResponseBody
    public LayuiResult<Map> selTchExam(SelTchExamVO selTchExamVO){
        List<Map> selTchExam = selTchExamService.selTchExam(selTchExamVO);
        LayuiResult<Map> result = new LayuiResult<>();
        result.setData(selTchExam);
        return result;
    }
}
