package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.common.config.MySysUser;
import com.nsapi.niceschoolapi.entity.LayuiResult;
import com.nsapi.niceschoolapi.entity.TchSelStuExamVO;
import com.nsapi.niceschoolapi.service.TchSelStuExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TchSelStuExamController {
    @Autowired
    private TchSelStuExamService tchSelStuExamService;

    @RequestMapping("/tchSelExam")
    public String tchSelExam(Model model){
        String tid=MySysUser.loginName();
        List<Map> tchClass = tchSelStuExamService.selTchClass(tid);
        List<Map> tchGrade = tchSelStuExamService.selTchGrade(tid);
        model.addAttribute("tchClass",tchClass);
        model.addAttribute("tchGrade",tchGrade);
        return "view/student/tchSelStuExam";
    }

    @RequestMapping("/tchSelStuExam")
    @ResponseBody
    public LayuiResult<Map> tchSelStuExam(TchSelStuExamVO tchSelStuExamVO){
        String tid=MySysUser.loginName();
        tchSelStuExamVO.setTid(tid);
        List<Map> exam = tchSelStuExamService.tchSelStuExam(tchSelStuExamVO);
        LayuiResult<Map> result = new LayuiResult<>();
        result.setData(exam);
        return result;
    }
}
