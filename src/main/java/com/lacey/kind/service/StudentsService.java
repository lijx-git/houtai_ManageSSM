package com.lacey.kind.service;

import com.lacey.kind.entity.Students;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface StudentsService {
    List<Students> findAllStu();
    Students findStuById(long sid);
    void deleteStuById(long sid);
    void addStudent(Students students);
    List<Students> findStu(String key,String val);
}
