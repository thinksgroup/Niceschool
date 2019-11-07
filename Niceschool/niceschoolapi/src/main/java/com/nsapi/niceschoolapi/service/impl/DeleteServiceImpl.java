package com.nsapi.niceschoolapi.service.impl;

import com.nsapi.niceschoolapi.mapper.DeleteMapper;
import com.nsapi.niceschoolapi.service.DeleteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class DeleteServiceImpl implements DeleteService {
    @Resource
    private DeleteMapper deleteMapper;

    //  删除学生信息
    @Override
    public Integer deleteStudent(String stuid) {
        return deleteMapper.deleteStudent(stuid);
    }

    //  删除学生选课信息
    @Override
    public Integer deleteStuCourse(String stuid) {
        return deleteMapper.deleteStuCourse(stuid);
    }

    //  删除学生成绩表信息
    @Override
    public Integer deleteStuExam(String stuid) {
        return deleteMapper.deleteStuExam(stuid);
    }

    //  删除教评记录表信息
    @Override
    public Integer deleteEvaluateRecord(String stuid) {
        return deleteMapper.deleteEvaluateRecord(stuid);
    }

    //  班级表人数-1
    @Override
    public Integer deleteClassinfo(String stuid) {
        return deleteMapper.deleteClassinfo(stuid);
    }

    //  年级人数-1
    @Override
    public Integer deleteGrade(String stuid) {
        return deleteMapper.deleteGrade(stuid);
    }

    //  专业人数-1
    @Override
    public Integer deleteMajor(String stuid) {
        return deleteMapper.deleteMajor(stuid);
    }

    //  系部人数-1
    @Override
    public Integer deleteDepartment(String stuid) {
        return deleteMapper.deleteDepartment(stuid);
    }
}
