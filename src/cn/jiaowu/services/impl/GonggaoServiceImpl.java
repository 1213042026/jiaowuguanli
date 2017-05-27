package cn.jiaowu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.jiaowu.dao.GonggaoDao;
import cn.jiaowu.entity.Gonggao;
import cn.jiaowu.services.IGonggaoService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;

import java.util.ArrayList;
import java.util.List;

@Service("iGonggaoService")
public class GonggaoServiceImpl implements IGonggaoService {
	@Autowired
	private GonggaoDao gonggaoDao;

	public void saveOrUpdateGonggao(Gonggao gonggao) {
		int rowCount = 0;
		if (gonggao != null) {
			if (gonggao.getId() != null) {
				rowCount = gonggaoDao.updateByPrimaryKeySelective(gonggao);
			} else {
				rowCount = gonggaoDao.insert(gonggao);
			}
		}
	}

	public ServerResponse<Gonggao> getGonggaoDetail(Integer id) {
		if (id == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Gonggao gonggao = gonggaoDao.selectByPrimaryKey(id);
		if (gonggao == null) {
			return ServerResponse.createByErrorMessage("查询结果为空");
		}
		return ServerResponse.createBySuccess(gonggao);
	}

	public List<Gonggao> getAll() {
		// TODO Auto-generated method stub
		return gonggaoDao.getAll();
	}

	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int rowCount = gonggaoDao.deleteByPrimaryKey(id);
	}
	
	public ServerResponse getAllGonggao() {
		return ServerResponse.createBySuccess(gonggaoDao.getAll());
	}

}


