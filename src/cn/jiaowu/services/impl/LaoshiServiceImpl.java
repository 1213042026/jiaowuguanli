package cn.jiaowu.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiaowu.dao.LaoshiDao;
import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.services.ILaoshiService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;


@Service("iLaoshiService")
public class LaoshiServiceImpl implements ILaoshiService {

	@Autowired
	private LaoshiDao laoshiDao;

	public ServerResponse<Laoshi> login(String username, String password) {
		Laoshi laoshi = laoshiDao.selectLogin(username, password);
		if (laoshi == null) {
			return ServerResponse.createByErrorMessage("用户名密码错误");
		}
		return ServerResponse.createBySuccess("登录成功", laoshi);
	}


	public ServerResponse updatePasswordByUsername(String bianhao, String userPwNew){
		int updateCount = laoshiDao.updatePasswordByUsername(bianhao,userPwNew);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("密码成功，请您使用新密码登录!", updateCount);
		}
		return ServerResponse.createByErrorMessage("密码修改失败!");
	}


	public void deleteByPrimaryKey(Integer id) {
		int rowCount = laoshiDao.deleteByPrimaryKey(id);
	}


	public List<Laoshi> getAll(String bianhao,Integer zhuanyeid) {
		return laoshiDao.getAll(bianhao,zhuanyeid);
	}


	public ServerResponse<Laoshi> getLaoshiDetail(Integer id) {
		if (id == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Laoshi laoshi = laoshiDao.selectByPrimaryKey(id);
		if (laoshi == null) {
			return ServerResponse.createByErrorMessage("查询结果为空");
		}
		return ServerResponse.createBySuccess(laoshi);
	}


	public ServerResponse saveOrUpdateLaoshi(Laoshi laoshi) {
		int rowCount = 0;
		if (laoshi != null) {
			if (laoshi.getId() != null) {
				rowCount = laoshiDao.updateByPrimaryKeySelective(laoshi);
			} else {
				rowCount = laoshiDao.insert(laoshi);
			}
		}
		if(rowCount>0){
			return ServerResponse.createBySuccessMessage("更新个人信息成功!");
		}else{
			return ServerResponse.createBySuccessMessage("更新个人信息失败!");
		}
	}


	public int shenhe(Integer id) {
		return laoshiDao.shenhe(id);
	}
	
	public ServerResponse isExists(String bianhao){
		int n=laoshiDao.isExists(bianhao);
		if(n==0){
			return ServerResponse.createBySuccessMessage("可以添加");
		}else{
			return ServerResponse.createByErrorMessage("该工号已经存在！");
		}
	}
}
