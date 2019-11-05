package com.nsapi.niceschoolapi.controller;

import com.nsapi.niceschoolapi.entity.CourseDB;
import com.nsapi.niceschoolapi.entity.PoliticsTypeDB;
import com.nsapi.niceschoolapi.entity.StudentVO;
import com.nsapi.niceschoolapi.service.AddStudentService;
import com.nsapi.niceschoolapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AddStudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private AddStudentService addStudentService;

    @RequestMapping("/addStudentPage")
    public String selPolitics(Model model){
        //  查询政治面貌表
        List<PoliticsTypeDB> stupol = studentService.selPolitics();
        model.addAttribute("stupol",stupol);
        return "view/student/addStudent";
    }


    //  添加学生
    @RequestMapping("/addStudent")
    public String addStudent(StudentVO studentVO, String birthday, String tertime) throws Exception{
        //  将接收到的时间进行类型转换
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1=format.parse(birthday);
        Date date2=format.parse(tertime);
        studentVO.setSbirthday(date1);
        studentVO.setEntertime(date2);
        //  生成学生学号
        String stui = addStudentService.selStuid(studentVO.getGid());
        studentVO.setStuid(stui);
        //  根据前台传来信息添加学生
        Integer addStudent = addStudentService.addStudent(studentVO);
        //  获取学号
        String stuid = studentVO.getStuid();
        //  根据学号查询学生id编号
        Integer sid = addStudentService.selectSid(stuid);
        //  获取所选专业id
        Integer mid = studentVO.getMid();
        //  根据学生专业查询该专业开设的必修课程
        List<CourseDB> selCourse = addStudentService.selCourse(mid);
        for(CourseDB cou : selCourse){
            //  将学生id以及必修课程的id添加至学生选课表
            Integer addStuCourse = addStudentService.addStuCourse(sid,cou.getCid());
            System.out.println(addStuCourse);
        }
        System.out.println(selCourse);
        return "redirect:selectStudent";
    }
}

