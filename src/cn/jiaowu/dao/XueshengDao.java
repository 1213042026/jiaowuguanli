package cn.jiaowu.dao;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.entity.Xuesheng;

public interface XueshengDao {
    Xuesheng selectLogin(@Param("userName") String userName, @Param("userPw") String userPw);
    int updatePasswordByUsername(@Param("xuehao") String xuehao,@Param("userPwNew") String userPwNew);
    
    int shenhe(Integer id);
    
    int deleteByPrimaryKey(Integer id);

    int insert(Xuesheng record);

    Xuesheng selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xuesheng record);
    
    List<Xuesheng> getAll(@Param("xuehao") String xuehao,@Param("zhuanyeid") Integer zhuanyeid);
    
    int isExists(@Param("xuehao") String xuehao);
}