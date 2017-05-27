package cn.jiaowu.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Chengji;
import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.services.IChengjiService;
import cn.jiaowu.util.Const;
import cn.jiaowu.util.ServerResponse;
import cn.jiaowu.util.Const.Role;
@Controller
@RequestMapping("/chengji")
public class ChengjiController {

	@Autowired
	private IChengjiService iChengjiService;

	@RequestMapping(value = "list")
	public String list(HttpSession session,Model model,Integer zhuanyeid,Integer xueshengid,Integer kechengid) {
		Integer n=(Integer)session.getAttribute(Const.CURRENT_ROLE);	
		if(n!=null && n==Role.ROLE_STUDENT){
			Xuesheng xuesheng=(Xuesheng)session.getAttribute(Const.CURRENT_USER);	
			if(xuesheng!=null){
				model.addAttribute("list", iChengjiService.getAll(zhuanyeid,xuesheng.getId(),kechengid));
			}
			return "manage/xuesheng/chengjiList";
		}else{
			Laoshi laoshi=(Laoshi)session.getAttribute(Const.CURRENT_USER);	
			if(laoshi!=null){
				model.addAttribute("list", iChengjiService.getAll(laoshi.getZhuanyeid(),xueshengid,kechengid));
			}
			return "manage/laoshi/chengjiList";
		}
	}
	
	@RequestMapping(value = "add")
	public String add(Chengji chengji) {
		iChengjiService.saveOrUpdateChengji(chengji);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Chengji chengji) {
		iChengjiService.saveOrUpdateChengji(chengji);
		return "redirect:list";
	}
	
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iChengjiService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "isExists")
	@ResponseBody
	public ServerResponse isExists(Integer xueshengid,Integer kechengid) {
		return iChengjiService.isExists(xueshengid, kechengid);
	}
}
