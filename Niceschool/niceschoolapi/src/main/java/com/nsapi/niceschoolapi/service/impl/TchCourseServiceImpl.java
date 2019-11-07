package com.nsapi.niceschoolapi.service.impl;

import com.nsapi.niceschoolapi.entity.*;
import com.nsapi.niceschoolapi.mapper.TchCourseMapper;
import com.nsapi.niceschoolapi.service.TchCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class TchCourseServiceImpl implements TchCourseService {
    @Resource
    private TchCourseMapper tchCourseMapper;
    //查询全部教师
    @Override
    public List<TeacherDB> findAllTch(TeacherDB teacherDB) {
        return tchCourseMapper.findAllTch(teacherDB);
    }
    //查询全部教师姓名
    @Override
    public List<TeacherDB> findAllTchByName() {
        return tchCourseMapper.findAllTchByName();
    }

}