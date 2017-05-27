package cn.jiaowu.services;

import java.util.List;
import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.util.ServerResponse;

public interface IKechengService {

	void saveOrUpdateKecheng(Kecheng kecheng);

    ServerResponse<Kecheng> getKechengDetail(Integer id);
    
    ServerResponse getAllKecheng(Integer zhuanyeid);

    List<Kecheng> getAll();
    
    void deleteByPrimaryKey(Integer id);
    
   
}
