package cn.jiaowu.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jiaowu.entity.Chengji;

public interface ChengjiDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Chengji record);

    int updateByPrimaryKeySelective(Chengji record);
    
    List<Chengji> getAll(@Param("zhuanyeid") Integer zhuanyeid,@Param("xueshengid") Integer xueshengId,@Param("kechengid") Integer kechengId);
   
    int isExists(@Param("xueshengid") Integer xueshengId,@Param("kechengid") Integer kechengId);
}