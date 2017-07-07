package com.lacey.kind.service.impl;

import com.lacey.kind.dao.TeachersDao;
import com.lacey.kind.entity.Teachers;
import com.lacey.kind.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/7.
 */
@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private TeachersDao teachersDao;
    public List<Teachers> queryTaechers() {
        return teachersDao.findAllTeachers();
    }

    public void addTeachers(Teachers teachers) {
        teachersDao.addTeachers(teachers);
    }

    public void deleteTeachers(Long tid) {
        teachersDao.deleteTea(tid);
    }

    public List<Teachers> findTeachers(String key, String val) {
        return teachersDao.findTeaByElement(key,val);
    }

    public Teachers findTeaByTid(long tid) {
        return teachersDao.findTeaByTid(tid);
    }

    public void modifyTeacher(Teachers teachers) {
        teachersDao.updateTeaByTid(teachers);
    }
}
