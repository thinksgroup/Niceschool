package com.nsapi.niceschoolapi.mapper;

import com.nsapi.niceschoolapi.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuExamMapper {
    List<DepartmentDB> selDes();
    List<MajorDB> selMas(Integer did);
    List<GradeDB> selGrs(Integer mid);
    List<ClassinfoDB> selClasss(Integer gid);
    List<StuExamVO> selScs(StuExamVO stuExamVO);
    int add(StuExamVO stuExamVO);
    int selExam(StuExamVO stuExamVO);
    StuExamDB selExams(StuExamVO stuExamVO);
    int updateExam(StuExamDB stuExamDB);
}
