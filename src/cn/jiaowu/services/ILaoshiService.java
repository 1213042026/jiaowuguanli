package cn.jiaowu.services;


import java.util.List;

import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Zhuanye;
import cn.jiaowu.util.ServerResponse;



public interface ILaoshiService {
	ServerResponse<Laoshi> login(String username, String password);
    ServerResponse updatePasswordByUsername(String bianhao, String password);
    
    int shenhe(Integer id);
    
    void deleteByPrimaryKey(Integer id);

    List<Laoshi> getAll(String bianhao,Integer zhuanyeid);
    
    ServerResponse saveOrUpdateLaoshi(Laoshi laoshi);

    ServerResponse<Laoshi> getLaoshiDetail(Integer id);
    
    ServerResponse isExists(String bianhao);
}
