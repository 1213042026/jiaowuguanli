package cn.jiaowu.dao;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.jiaowu.entity.Laoshi;

public interface LaoshiDao {
	Laoshi selectLogin(@Param("userName") String userName, @Param("userPw") String userPw);
    int updatePasswordByUsername(@Param("bianhao") String bianhao,@Param("userPwNew") String userPwNew);
    
    int shenhe(Integer id);
    
    int deleteByPrimaryKey(Integer id);

    int insert(Laoshi record);

    Laoshi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Laoshi record);
    
    List<Laoshi> getAll(@Param("bianhao") String bianhao,@Param("zhuanyeid") Integer zhuanyeid);
    
    int isExists(@Param("bianhao") String bianhao);
}