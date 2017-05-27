package cn.jiaowu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiaowu.dao.ZhuanyeDao;
import cn.jiaowu.entity.Zhuanye;
import cn.jiaowu.services.IZhuanyeService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;

import java.util.ArrayList;
import java.util.List;

@Service("iZhuanyeService")
public class ZhuanyeServiceImpl implements IZhuanyeService {
	@Autowired
	private ZhuanyeDao zhuanyeDao;

	public void saveOrUpdateZhuanye(Zhuanye zhuanye) {
		int rowCount = 0;
		if (zhuanye != null) {
			if (zhuanye.getId() != null) {
				rowCount = zhuanyeDao.updateByPrimaryKeySelective(zhuanye);
			} else {
				zhuanye.setDel(0);//初始时设置为0
				rowCount = zhuanyeDao.insert(zhuanye);
			}
		}
	}

	public ServerResponse<Zhuanye> getZhuanyeDetail(Integer id) {
		if (id == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Zhuanye zhuanye = zhuanyeDao.selectByPrimaryKey(id);
		if (zhuanye == null) {
			return ServerResponse.createByErrorMessage("查询结果为空");
		}
		return ServerResponse.createBySuccess(zhuanye);
	}

	public List<Zhuanye> getAll() {
		// TODO Auto-generated method stub
		return zhuanyeDao.getAll();
	}

	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int rowCount = zhuanyeDao.deleteByPrimaryKey(id);
	}
	
	public ServerResponse getAllZhuanye() {
		return ServerResponse.createBySuccess(zhuanyeDao.getAll());
	}

}