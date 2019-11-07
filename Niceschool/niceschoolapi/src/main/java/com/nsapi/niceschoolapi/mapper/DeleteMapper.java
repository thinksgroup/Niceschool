package com.nsapi.niceschoolapi.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeleteMapper {
    //  删除学生信息
    Integer deleteStudent(String stuid);
    //  删除学生选课信息
    Integer deleteStuCourse(String stuid);
    //  删除学生成绩表信息
    Integer deleteStuExam(String stuid);
    //  删除教评记录表信息
    Integer deleteEvaluateRecord(String stuid);
    //  班级表人数-1
    Integer deleteClassinfo(String stuid);
    //  年级人数-1
    Integer deleteGrade(String stuid);
    //  专业人数-1
    Integer deleteMajor(String stuid);
    //  系部人数-1
    Integer deleteDepartment(String stuid);
}
