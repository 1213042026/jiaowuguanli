package cn.jiaowu.services.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiaowu.dao.AdminDao;
import cn.jiaowu.entity.Admin;
import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.services.IAdminService;
import cn.jiaowu.util.ServerResponse;


@Service("iAdminService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminDao adminDao;

	public ServerResponse<Admin> login(String username, String password) {
		Admin admin = adminDao.selectLogin(username, password);
		if (admin == null) {
			return ServerResponse.createByErrorMessage("用户名密码错误");
		}
		return ServerResponse.createBySuccess("登录成功", admin);
	}


	public ServerResponse updatePasswordByUsername(String userName, String userPwNew){
		int updateCount = adminDao.updatePasswordByUsername(userName,userPwNew);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("密码成功，请您使用新密码登录!", updateCount);
		}
		return ServerResponse.createByErrorMessage("密码修改失败!");
	}


	public ServerResponse saveOrUpdateAdmin(Admin admin) {
		int rowCount = 0;
		if (admin != null) {
			if (admin.getUserId() != null) {
				rowCount = adminDao.updateByPrimaryKeySelective(admin);
			}
		}
		if(rowCount>0){
			return ServerResponse.createBySuccessMessage("更新个人信息成功!");
		}else{
			return ServerResponse.createBySuccessMessage("更新个人信息失败!");
		}
	}
	

}
