package cn.jiaowu.dao;
import org.apache.ibatis.annotations.Param;
import cn.jiaowu.entity.Admin;
import cn.jiaowu.entity.Kecheng;

public interface AdminDao {
    Admin selectLogin(@Param("userName") String userName, @Param("userPw") String userPw);
    int updatePasswordByUsername(@Param("userName") String userName,@Param("userPwNew") String userPwNew);
    int updateByPrimaryKeySelective(Admin record);
}