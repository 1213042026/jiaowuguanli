package cn.jiaowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Kecheng;
import cn.jiaowu.services.IKechengService;
import cn.jiaowu.util.ServerResponse;
@Controller
@RequestMapping("/kecheng")
public class KechengController {

	@Autowired
	private IKechengService iKechengService;

	@RequestMapping(value = "list")
	public String list(Model model) {
		model.addAttribute("list", iKechengService.getAll());
		return "/manage/admin/kechengList";
	}
	
	@RequestMapping(value = "add")
	public String add(Kecheng kecheng) {
		iKechengService.saveOrUpdateKecheng(kecheng);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Kecheng kecheng) {
		iKechengService.saveOrUpdateKecheng(kecheng);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail{id}",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Kecheng> detail(@PathVariable("id") int id) {
		return iKechengService.getKechengDetail(id);
	}
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iKechengService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	@RequestMapping(value = "listJson")
	@ResponseBody
	public ServerResponse listJson(Integer zhuanyeid) {
		return iKechengService.getAllKecheng(zhuanyeid);
	}
}
