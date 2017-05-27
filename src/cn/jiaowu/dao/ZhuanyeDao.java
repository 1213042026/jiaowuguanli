package cn.jiaowu.dao;
import java.util.List;
import cn.jiaowu.entity.Zhuanye;

public interface ZhuanyeDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Zhuanye record);

    Zhuanye selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhuanye record);
    
    List<Zhuanye> getAll();

}