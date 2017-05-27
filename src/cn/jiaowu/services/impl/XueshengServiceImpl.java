package cn.jiaowu.services.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jiaowu.dao.XueshengDao;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.services.IXueshengService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;


@Service("iXueshengService")
public class XueshengServiceImpl implements IXueshengService {

	@Autowired
	private XueshengDao xueshengDao;

	public ServerResponse<Xuesheng> login(String username, String password) {
		Xuesheng xuesheng = xueshengDao.selectLogin(username, password);
		if (xuesheng == null) {
			return ServerResponse.createByErrorMessage("用户名密码错误");
		}
		return ServerResponse.createBySuccess("登录成功", xuesheng);
	}


	public ServerResponse updatePasswordByUsername(String xuehao, String userPwNew){
		int updateCount = xueshengDao.updatePasswordByUsername(xuehao,userPwNew);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("密码成功，请您使用新密码登录!", updateCount);
		}
		return ServerResponse.createByErrorMessage("密码修改失败!");
	}
	
	public void deleteByPrimaryKey(Integer id) {
		int rowCount = xueshengDao.deleteByPrimaryKey(id);
	}


	public List<Xuesheng> getAll(String xuehao,Integer zhuanyeid) {
		return xueshengDao.getAll(xuehao,zhuanyeid);
	}


	public ServerResponse<Xuesheng> getXueshengDetail(Integer id) {
		if (id == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Xuesheng xuesheng = xueshengDao.selectByPrimaryKey(id);
		if (xuesheng == null) {
			return ServerResponse.createByErrorMessage("查询结果为空");
		}
		return ServerResponse.createBySuccess(xuesheng);
	}


	public ServerResponse saveOrUpdateXuesheng(Xuesheng xuesheng) {
		int rowCount = 0;
		if (xuesheng != null) {
			if (xuesheng.getId() != null) {
				rowCount = xueshengDao.updateByPrimaryKeySelective(xuesheng);
			} else {
				rowCount = xueshengDao.insert(xuesheng);
			}
		}
		if(rowCount>0){
			return ServerResponse.createBySuccessMessage("更新个人信息成功!");
		}else{
			return ServerResponse.createBySuccessMessage("更新个人信息失败!");
		}
	}


	public int shenhe(Integer id) {
		return xueshengDao.shenhe(id);
	}


	public ServerResponse getAllJson(Integer zhuanyeid) {
		return ServerResponse.createBySuccess(xueshengDao.getAll("",zhuanyeid));
	}
	
	public ServerResponse isExists(String xuehao){
		int n=xueshengDao.isExists(xuehao);
		if(n==0){
			return ServerResponse.createBySuccessMessage("可以添加");
		}else{
			return ServerResponse.createByErrorMessage("该学号已经存在！");
		}
	}
}
