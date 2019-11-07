package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.entity.LayuiResult;
import com.nsapi.niceschoolapi.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class DeleteController {
    @Autowired
    private DeleteService deleteService;

    @RequestMapping("delStudent")
    @ResponseBody
    public LayuiResult<Map> delStudent(String stuid){
        LayuiResult result = new LayuiResult();
        //  删除学生信息
        Integer deleteStudent = deleteService.deleteStudent(stuid);
        //  删除学生选课信息
        Integer deleteStuCourse = deleteService.deleteStuCourse(stuid);
        //  删除学生成绩表信息
        Integer deleteStuExam = deleteService.deleteStuExam(stuid);
        //  删除教评记录表信息
        Integer deleteEvaluateRecord = deleteService.deleteEvaluateRecord(stuid);
        //  班级表人数-1
        Integer deleteClassinfo = deleteService.deleteClassinfo(stuid);
        //  年级人数-1
        Integer deleteGrade = deleteService.deleteGrade(stuid);
        //  专业人数-1
        Integer deleteMajor = deleteService.deleteMajor(stuid);
        //  系部人数-1
        Integer deleteDepartment = deleteService.deleteDepartment(stuid);
        result.setMsg("删除成功");
        return result;
    }
}
