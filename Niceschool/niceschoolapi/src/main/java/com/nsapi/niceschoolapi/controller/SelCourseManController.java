package com.nsapi.niceschoolapi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsapi.niceschoolapi.entity.*;
import com.nsapi.niceschoolapi.service.SelCourseManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SelCourseManController {
    @Autowired
    private SelCourseManageService selCourseManageService;

    @RequestMapping("selCourses")
    public String selCourses(){
        System.out.println("----------------------");
        return "SelCourseMan";
    }
    @RequestMapping("selSc")
    @ResponseBody
    public Object selSc(Integer page, Integer limit, StuCourseVO stuCourseVO){
        System.out.println(stuCourseVO.getSname());
        PageHelper.startPage(page, limit);
        List<StuCourseVO> stuCourseVOS = selCourseManageService.selSc(stuCourseVO);
        PageInfo pageInfo = new PageInfo(stuCourseVOS);
        Map<String, Object> tableData = new HashMap<String, Object>();
        //这是layui要求返回的json数据格式
        tableData.put("code", 0);
        tableData.put("msg", "");
        //将全部数据的条数作为count传给前台（一共多少条）
        tableData.put("count", pageInfo.getTotal());
        //将分页后的数据返回（每页要显示的数据）
        tableData.put("data", pageInfo.getList());
        // System.out.print(cs);
        return tableData;
    }
    @RequestMapping("selDe")
    @ResponseBody
    public Object selDe(){
        List<DepartmentDB> departmentDBS = selCourseManageService.selDe();
        //System.out.println(departmentDBS);
        return departmentDBS;
    }
    @RequestMapping("selMa")
    @ResponseBody
    public Object selMa(Integer did){
        //System.out.println(did);
        List<MajorDB> majors = selCourseManageService.selMa(did);
        //System.out.println(majors);
        return majors;
    }
    @RequestMapping("selGr")
    @ResponseBody
    public Object selGr(Integer mid){
        //System.out.println(mid);
        List<GradeDB> gradeDBS = selCourseManageService.selGr(mid);
       // System.out.println(gradeDBS);
        return gradeDBS;
    }
    @RequestMapping("selCl")
    @ResponseBody
    public Object selCl(Integer gid){
       // System.out.println(gid);
        List<ClassinfoDB> classinfoDBS = selCourseManageService.selClass(gid);
       // System.out.println(classinfoDBS);
        return classinfoDBS;
    }
    @RequestMapping("selSt")
    @ResponseBody
    public Object selSt(Integer classid){
        //System.out.println(classid);
        List<StudentDB> studentDBS = selCourseManageService.selSt(classid);
       // System.out.println(studentDBS);
        return studentDBS;
    }
}
