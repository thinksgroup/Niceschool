package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.entity.LayuiResult;
import com.nsapi.niceschoolapi.entity.SelAllExamVO;
import com.nsapi.niceschoolapi.service.SelAllExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class SelStuAllExamController {
    @Autowired
    private SelAllExamService selAllExamService;
    @RequestMapping("/selStuAllExam")
    public String selStuAllExam(){
        return "view/student/selStuAllExam";
    }
    @RequestMapping("/selAllExam")
    @ResponseBody
    public LayuiResult<Map> selAllExam(SelAllExamVO selAllExamVO){
        List<Map> exam = selAllExamService.selAllExam(selAllExamVO);
        LayuiResult<Map> result = new LayuiResult<>();
        result.setData(exam);
        return result;
    }
}
