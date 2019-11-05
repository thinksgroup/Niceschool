package com.nsapi.niceschoolapi.mapper;

import com.nsapi.niceschoolapi.entity.TeacherDB;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddTEacherMapper {

    //  添加教师
    Integer addTeacher(TeacherDB teacherDB);
    //  判断是否要插入新一年分割工号 1要插入，0不用插入
    Integer selectYear();
    //  添加一条分割线
    Integer teaSegmentation();
    //  生成教师工号
    String selTchid();
}
