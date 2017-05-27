package cn.jiaowu.services;

import cn.jiaowu.entity.Admin;
import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.util.ServerResponse;
public interface IAdminService {
	ServerResponse<Admin> login(String username, String password);
    ServerResponse updatePasswordByUsername(String username, String password);
    
    ServerResponse saveOrUpdateAdmin(Admin admin);
    
}
