package cn.jiaowu.dao;
import java.util.List;
import cn.jiaowu.entity.Gonggao;

public interface GonggaoDao {
	int deleteByPrimaryKey(Integer id);

    int insert(Gonggao record);

    Gonggao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Gonggao record);
    
    List<Gonggao> getAll();

}