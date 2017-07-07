package com.lacey.kind.dao;

import com.lacey.kind.entity.Teachers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/6/6.
 */
public interface TeachersDao {
   List<Teachers> findAllTeachers();
   void addTeachers(Teachers teachers);
   void deleteTea(Long tid);
   List<Teachers> findTeaByElement(@Param(value = "key") String key,@Param(value = "val") String val);
   Teachers findTeaByTid(long tid);
   void updateTeaByTid(Teachers teachers);
}
