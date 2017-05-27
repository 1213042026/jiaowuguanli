package cn.jiaowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Admin;
import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.services.ILaoshiService;
import cn.jiaowu.util.Const;
import cn.jiaowu.util.ServerResponse;
import cn.jiaowu.util.Const.Role;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/laoshi")
public class LaoshiController {

    @Autowired
    private ILaoshiService iLaoshiService;

    @RequestMapping(value = "update_pwd",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Laoshi> update_pwd(HttpSession session,Laoshi user){
        Laoshi currentUser = (Laoshi)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        if(!currentUser.getLoginpw().equals(user.getOldPass())){
        	return ServerResponse.createByErrorMessage("原密码不正确");
        }
        ServerResponse response = iLaoshiService.updatePasswordByUsername(currentUser.getBianhao(), user.getLoginpw());
        return response;
    }
    
    @RequestMapping(value = "update_info",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update_info(HttpSession session,Laoshi user){
        Laoshi currentUser = (Laoshi)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        currentUser.setXingming(user.getXingming());
        currentUser.setXingbie(user.getXingbie());
        currentUser.setZhuanyeid(user.getZhuanyeid());
        currentUser.setNianling(user.getNianling());
        ServerResponse response = iLaoshiService.saveOrUpdateLaoshi(currentUser);
        return response;
    }
    
    @RequestMapping(value = "list")
	public String list(Model model,String bianhao,Integer zhuanyeid) {
		model.addAttribute("list", iLaoshiService.getAll(bianhao,zhuanyeid));
		return "/manage/admin/laoshiList";
	}
	
	@RequestMapping(value = "add")
	public String add(Laoshi laoshi) {
		iLaoshiService.saveOrUpdateLaoshi(laoshi);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Laoshi laoshi) {
		iLaoshiService.saveOrUpdateLaoshi(laoshi);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail{id}",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Laoshi> detail(@PathVariable("id") int id) {
		return iLaoshiService.getLaoshiDetail(id);
	}
	
	@RequestMapping(value = "shenhe{id}",method=RequestMethod.GET)
	public String shenhe(@PathVariable("id") int id) {
		iLaoshiService.shenhe(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iLaoshiService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	
	@RequestMapping(value = "isExists")
	@ResponseBody
	public ServerResponse isExists(String bianhao) {
		return iLaoshiService.isExists(bianhao);
	}
}
