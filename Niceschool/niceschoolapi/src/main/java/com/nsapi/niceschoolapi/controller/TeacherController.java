package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.entity.LayuiResult;
import com.nsapi.niceschoolapi.entity.PoliticsTypeDB;
import com.nsapi.niceschoolapi.entity.TeacherDB;
import com.nsapi.niceschoolapi.entity.pageCount;
import com.nsapi.niceschoolapi.service.StudentService;
import com.nsapi.niceschoolapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService lxxTeacherService;
    @Autowired
    private StudentService lxxStudentService;

    // 跳转教师查询页面
    @RequestMapping("/selectTeacher")
    public String selectTeacher(){
        return "view/teacher/selTeacher";
    }


    //  查询教师信息
    @RequestMapping("selTeacher")
    @ResponseBody
    public LayuiResult<Map> selTeacher(TeacherDB teacherDB, pageCount pageCount){
        LayuiResult<Map> result = new LayuiResult<>();
        //  查询所有教师信息/模糊查询教师信息
        List<Map> list = lxxTeacherService.selTeacher(teacherDB,pageCount);
        //  查询符合条件的教师数量
        int count = lxxTeacherService.selTeacherCount(teacherDB);
        result.setData(list);
        result.setCount(count);
        return result;
    }

    //  根据教师编号查询教师信息
    @RequestMapping("/selTeacherId")
    public String selTeacherId(Integer id, Model model){
        List<TeacherDB> tea = lxxTeacherService.selTeacherId(id);
        //  查询政治面貌
        List<PoliticsTypeDB> selpol = lxxStudentService.selPolitics();
        model.addAttribute("tea",tea);
        model.addAttribute("selpol",selpol);
        return "view/teacher/updTeacher";
    }

    //  修改教师信息
    @RequestMapping("/updateTeacher")
    @ResponseBody
    public LayuiResult<TeacherDB> updTeacher(TeacherDB teacherDB, String birthday) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=format.parse(birthday);
        teacherDB.setTbirthday(date);
        int a =lxxTeacherService.updTeacher(teacherDB);
        LayuiResult result= new LayuiResult();
        //删除提示
        result.setMsg("修改成功！");
        return result;
    }

}
