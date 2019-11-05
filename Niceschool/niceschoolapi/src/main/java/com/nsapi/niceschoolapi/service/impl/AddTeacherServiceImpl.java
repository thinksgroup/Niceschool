package com.nsapi.niceschoolapi.service.impl;

import com.nsapi.niceschoolapi.entity.TeacherDB;
import com.nsapi.niceschoolapi.mapper.AddTEacherMapper;
import com.nsapi.niceschoolapi.service.AddTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AddTeacherServiceImpl implements AddTeacherService {
    @Resource
    private AddTEacherMapper addTEacherMapper;


    //  添加教师
    @Override
    public Integer addTeacher(TeacherDB teacherDB) {
        return addTEacherMapper.addTeacher(teacherDB);
    }
    //  判断是否要插入新一年分割工号 1要插入，0不用插入
    @Override
    public Integer selectYear() {
        return addTEacherMapper.selectYear();
    }

    //  添加一条分割线
    @Override
    public Integer teaSegmentation() {
        return addTEacherMapper.teaSegmentation();
    }

    //  生成教师工号
    @Override
    public String selTchid() {
        return addTEacherMapper.selTchid();
    }
}
