package cn.jiaowu.services;

import java.util.List;
import cn.jiaowu.entity.Gonggao;
import cn.jiaowu.util.ServerResponse;

public interface IGonggaoService {

	void saveOrUpdateGonggao(Gonggao gonggao);

    ServerResponse<Gonggao> getGonggaoDetail(Integer id);
    
    ServerResponse getAllGonggao();

    List<Gonggao> getAll();
    
    void deleteByPrimaryKey(Integer id);
}
