package com.lacey.kind.service;

import com.lacey.kind.entity.Teachers;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
public interface TeachersService {
    List<Teachers> queryTaechers();
    void addTeachers(Teachers teachers);
    void deleteTeachers(Long tid);
    List<Teachers> findTeachers(String key,String val);
    Teachers findTeaByTid(long tid);
    void modifyTeacher(Teachers teachers);

}
