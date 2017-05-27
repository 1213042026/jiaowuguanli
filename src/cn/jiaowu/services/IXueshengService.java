package cn.jiaowu.services;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.util.ServerResponse;



public interface IXueshengService {
	ServerResponse<Xuesheng> login(String username, String password);
    ServerResponse updatePasswordByUsername(String xuehao, String password);
    
    int shenhe(Integer id);
    
    void deleteByPrimaryKey(Integer id);

    ServerResponse saveOrUpdateXuesheng(Xuesheng xuesheng);
   
    ServerResponse<Xuesheng> getXueshengDetail(Integer id);
    
    List<Xuesheng> getAll(String xuehao,Integer zhuanyeid);
    
    ServerResponse getAllJson(Integer zhuanyeid);
    
    ServerResponse isExists(String xuehao);
}
