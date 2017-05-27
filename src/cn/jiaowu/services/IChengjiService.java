package cn.jiaowu.services;

import java.util.List;
import cn.jiaowu.entity.Chengji;
import cn.jiaowu.util.ServerResponse;

public interface IChengjiService {

	void saveOrUpdateChengji(Chengji chengji);

    void deleteByPrimaryKey(Integer id);
    
    List<Chengji> getAll(Integer zhuanyeid,Integer xueshengId,Integer kechengId);
    
    ServerResponse isExists(int xueshengId,int kechengId);
}
