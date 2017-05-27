package cn.jiaowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Zhuanye;
import cn.jiaowu.services.IZhuanyeService;
import cn.jiaowu.util.ServerResponse;
@Controller
@RequestMapping("/zhuanye")
public class ZhuanyeController {

	@Autowired
	private IZhuanyeService iZhuanyeService;

	@RequestMapping(value = "list")
	public String list(Model model) {
		model.addAttribute("list", iZhuanyeService.getAll());
		return "/manage/admin/zhuanyeList";
	}
	
	@RequestMapping(value = "add")
	public String add(Zhuanye zhuanye) {
		iZhuanyeService.saveOrUpdateZhuanye(zhuanye);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Zhuanye zhuanye) {
		iZhuanyeService.saveOrUpdateZhuanye(zhuanye);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail{id}",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Zhuanye> detail(@PathVariable("id") int id) {
		return iZhuanyeService.getZhuanyeDetail(id);
	}
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iZhuanyeService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	@RequestMapping(value = "listJson")
	@ResponseBody
	public ServerResponse listJson() {
		return iZhuanyeService.getAllZhuanye();
	}
}
