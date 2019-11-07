package com.nsapi.niceschoolapi.mapper;

import com.nsapi.niceschoolapi.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TchCourseMapper {
    //查询全部教师
    List<TeacherDB> findAllTch(TeacherDB teacherDB);
    //查询全部教师姓名
    List<TeacherDB> findAllTchByName();

}
