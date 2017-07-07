package com.lacey.kind.service.impl;

import com.lacey.kind.dao.StudentsDao;
import com.lacey.kind.entity.Students;
import com.lacey.kind.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/25.
 */
@Service
public class StudentsServiceImpl implements StudentsService {
    @Autowired
    private StudentsDao studentsDao;

    public List<Students> findAllStu() {
        return studentsDao.queryAll();
    }
    public Students findStuById(long sid)
    {
        return studentsDao.findStuById(sid);
    }

    public void deleteStuById(long sid) {
        studentsDao.deleteStuById(sid);
    }
    public void addStudent(Students students)
    {
        studentsDao.addStudent(students);
    }
    public  List<Students> findStu(String key,String val)
    {
        return studentsDao.findStu( key, val);
    }
}
