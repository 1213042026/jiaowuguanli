package cn.jiaowu.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.jiaowu.dao.ChengjiDao;
import cn.jiaowu.entity.Chengji;
import cn.jiaowu.services.IChengjiService;
import cn.jiaowu.util.ResponseCode;
import cn.jiaowu.util.ServerResponse;
import java.util.List;

@Service("iChengjiService")
public class ChengjiServiceImpl implements IChengjiService {
	@Autowired
	private ChengjiDao chengjiDao;

	public void saveOrUpdateChengji(Chengji chengji) {
		int rowCount = 0;
		if (chengji != null) {
			if (chengji.getId() != null) {
				rowCount = chengjiDao.updateByPrimaryKeySelective(chengji);
			} else {
				rowCount = chengjiDao.insert(chengji);
			}
		}
	}

	public List<Chengji> getAll(Integer zhuanyeid,Integer xueshengId,Integer kechengId) {
		// TODO Auto-generated method stub
		return chengjiDao.getAll(zhuanyeid,xueshengId,kechengId);
	}

	public void deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		int rowCount = chengjiDao.deleteByPrimaryKey(id);
	}
	
	public ServerResponse isExists(int xueshengId, int kechengId) {
		int n=chengjiDao.isExists(xueshengId, kechengId);
		if(n==0){
			return ServerResponse.createBySuccessMessage("可以添加");
		}else{
			return ServerResponse.createByErrorMessage("该课程已存在成绩！");
		}
	}
}
