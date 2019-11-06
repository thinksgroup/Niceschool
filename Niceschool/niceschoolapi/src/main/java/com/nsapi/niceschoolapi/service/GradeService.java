package com.nsapi.niceschoolapi.service;

import com.nsapi.niceschoolapi.entity.TchExamDB;
import com.nsapi.niceschoolapi.entity.TeacherDB;

import java.util.List;
import java.util.Map;

public interface GradeService {
    //  查询学生个人信息
    List<Map> selStudentMessage(String stuid);
    //  查询学生成绩信息
    List<Map> selGrade(String stuid, Integer stime);
    //  管理员详情页面查询教师教评成绩
    List<TchExamDB> selTeaExam(Integer tid);
    //  查询教师个人信息
    List<TeacherDB> selTea(Integer tid);
}
