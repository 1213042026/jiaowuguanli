package cn.jiaowu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jiaowu.dao.KechengDao;
import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.services.IKechengService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;
import java.util.List;

@Service("iKechengService")
public class KechengServiceImpl implements IKechengService {
	@Autowired
	private KechengDao kechengDao;

	public void saveOrUpdateKecheng(Kecheng kecheng) {
		int rowCount = 0;
		if (kecheng != null) {
			if (kecheng.getId() != null) {
				rowCount = kechengDao.updateByPrimaryKeySelective(kecheng);
			} else {
				kecheng.setDel(0);//初始时设置为0
				rowCount = kechengDao.insert(kecheng);
			}
		}
	}

	public ServerResponse<Kecheng> getKechengDetail(Integer id) {
		if (id == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.ILLEGAL_ARGUMENT.getCode(),
					ResponseCode.ILLEGAL_ARGUMENT.getDesc());
		}
		Kecheng kecheng = kechengDao.selectByPrimaryKey(id);
		if (kecheng == null) {
			return ServerResponse.createByErrorMessage("查询结果为空");
		}
		return ServerResponse.createBySuccess(kecheng);
	}

	public List<Kecheng> getAll() {
		// TODO Auto-generated method stub
		return kechengDao.getAll(null);
	}

	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int rowCount = kechengDao.deleteByPrimaryKey(id);
	}
	
	public ServerResponse getAllKecheng(Integer zhuanyeid) {
		return ServerResponse.createBySuccess(kechengDao.getAll(zhuanyeid));
	}

	

}
