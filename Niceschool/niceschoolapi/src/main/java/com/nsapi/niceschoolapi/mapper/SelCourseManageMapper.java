package com.nsapi.niceschoolapi.mapper;

import com.nsapi.niceschoolapi.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SelCourseManageMapper {
    List<DepartmentDB> selDe();
    List<MajorDB> selMa(Integer did);
    List<GradeDB> selGr(Integer mid);
    List<ClassinfoDB> selClass(Integer gid);
    List<StudentDB> selSt(Integer classid);
    List<StuCourseVO> selSc(StuCourseVO stuCourseVO);
}
