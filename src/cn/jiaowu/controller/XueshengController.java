package cn.jiaowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.services.IXueshengService;
import cn.jiaowu.util.Const;
import cn.jiaowu.util.ServerResponse;
import cn.jiaowu.util.Const.Role;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/xuesheng")
public class XueshengController {

    @Autowired
    private IXueshengService iXueshengService;

    @RequestMapping(value = "update_pwd",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Xuesheng> update_pwd(HttpSession session,Xuesheng user){
        Xuesheng currentUser = (Xuesheng)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        if(!currentUser.getLoginpw().equals(user.getOldPass())){
        	return ServerResponse.createByErrorMessage("原密码不正确");
        }
        ServerResponse response = iXueshengService.updatePasswordByUsername(currentUser.getXuehao(), user.getLoginpw());
        return response;
    }
    
    @RequestMapping(value = "update_info",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update_info(HttpSession session,Xuesheng user){
    	Xuesheng currentUser = (Xuesheng)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        currentUser.setXingming(user.getXingming());
        currentUser.setXingbie(user.getXingbie());
        currentUser.setZhuanyeid(user.getZhuanyeid());
        currentUser.setNianling(user.getNianling());
        ServerResponse response = iXueshengService.saveOrUpdateXuesheng(currentUser);
        return response;
    }
    
    @RequestMapping(value = "list")
	public String list(Model model,String xuehao,Integer zhuanyeid) {
		model.addAttribute("list", iXueshengService.getAll(xuehao,zhuanyeid));
		return "/manage/admin/xueshengList";
	}
	
	@RequestMapping(value = "add")
	public String add(Xuesheng xuesheng) {
		iXueshengService.saveOrUpdateXuesheng(xuesheng);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Xuesheng xuesheng) {
		iXueshengService.saveOrUpdateXuesheng(xuesheng);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail{id}",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Xuesheng> detail(@PathVariable("id") int id) {
		return iXueshengService.getXueshengDetail(id);
	}
	
	@RequestMapping(value = "shenhe{id}",method=RequestMethod.GET)
	public String shenhe(@PathVariable("id") int id) {
		iXueshengService.shenhe(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iXueshengService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	@RequestMapping(value = "listJson")
	@ResponseBody
	public ServerResponse listJson(Integer zhuanyeid) {
		return iXueshengService.getAllJson(zhuanyeid);
	}
	
	@RequestMapping(value = "isExists")
	@ResponseBody
	public ServerResponse isExists(String xuehao) {
		return iXueshengService.isExists(xuehao);
	}
}
