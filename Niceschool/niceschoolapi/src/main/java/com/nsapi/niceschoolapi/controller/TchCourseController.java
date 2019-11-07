package com.nsapi.niceschoolapi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nsapi.niceschoolapi.entity.*;
import com.nsapi.niceschoolapi.service.TchCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tchcoursemanage")
public class TchCourseController extends BaseController {
    @Autowired
    private TchCourseService tchCourseService;

    /**
     * 进入教师授课管理页面
     */
    @RequestMapping("tchcoursemanage")
    public String classmanage() {
        return "view/teacher/tchcoursemanage";
    }


/*******************************************************************查询*********************************************************************/

    /**
     * 查询全部教师
     */
    @RequestMapping("findalltch")
    @ResponseBody
    public Object findAllTch(TeacherDB teacherDB, Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findAllTch(teacherDB);
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tchData = new HashMap<String, Object>();
        tchData.put("code", 0);
        tchData.put("msg", "");
        tchData.put("count", pageInfo.getTotal());
        tchData.put("data", pageInfo.getList());
        return tchData;
    }
    /**
     * 查询全部教师姓名
     */
    @RequestMapping("findalltchbyname")
    @ResponseBody
    public Object findAllTchByName(Integer page, Integer limit){
        PageHelper.startPage(page, limit);
        List<TeacherDB> listAll = tchCourseService.findAllTchByName();
        PageInfo pageInfo = new PageInfo(listAll);
        Map<String, Object> tchData = new HashMap<String, Object>();
        tchData.put("code", 0);
        tchData.put("msg", "");
        tchData.put("count", pageInfo.getTotal());
        tchData.put("data", pageInfo.getList());
        return tchData;
    }





}
