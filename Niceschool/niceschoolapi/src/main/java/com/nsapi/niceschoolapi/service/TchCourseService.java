package com.nsapi.niceschoolapi.service;

import com.nsapi.niceschoolapi.entity.*;

import java.util.List;

public interface TchCourseService {
    //查询全部教师
    List<TeacherDB> findAllTch(TeacherDB teacherDB);
    //查询全部教师姓名
    List<TeacherDB> findAllTchByName();

}