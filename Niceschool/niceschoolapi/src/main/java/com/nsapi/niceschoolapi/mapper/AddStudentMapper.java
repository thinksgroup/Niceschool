package com.nsapi.niceschoolapi.mapper;

import com.nsapi.niceschoolapi.entity.CourseDB;
import com.nsapi.niceschoolapi.entity.StudentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddStudentMapper {
    //  根据前台传来信息添加学生
    Integer addStudent(StudentVO studentVO);
    //  根据学生专业查询该专业开设的必修课程
    List<CourseDB> selCourse(Integer mid);
    //  根据学号查询学生id编号
    Integer selectSid(String stuid);
    //  将学生id以及必修课程的id添加至学生选课表
    Integer addStuCourse(Integer sid, Integer cid);
    //  生成学生学号
    String selStuid(Integer gid);
}
