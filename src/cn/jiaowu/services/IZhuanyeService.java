package cn.jiaowu.services;

import java.util.List;
import cn.jiaowu.entity.Zhuanye;
import cn.jiaowu.util.ServerResponse;

public interface IZhuanyeService {

	void saveOrUpdateZhuanye(Zhuanye zhuanye);

    ServerResponse<Zhuanye> getZhuanyeDetail(Integer id);
    
    ServerResponse getAllZhuanye();

    List<Zhuanye> getAll();
    
    void deleteByPrimaryKey(Integer id);
}
