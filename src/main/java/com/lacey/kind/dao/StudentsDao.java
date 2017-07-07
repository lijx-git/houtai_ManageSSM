package com.lacey.kind.dao;

import com.lacey.kind.entity.Students;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
public interface StudentsDao {
    List<Students> queryAll();
    Students findStuById(long sid);
    void deleteStuById(long sid);
    void addStudent(Students students);
    List<Students> findStu(@Param("key") String key, @Param("val") String val);
}
