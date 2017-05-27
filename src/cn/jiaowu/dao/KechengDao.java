package cn.jiaowu.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jiaowu.entity.Kecheng;

public interface KechengDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Kecheng record);

    Kecheng selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kecheng record);
    
    List<Kecheng> getAll(@Param("zhuanyeid") Integer zhuanyeid);
    
    List<Kecheng> getAllByZhuanye(int id);
}