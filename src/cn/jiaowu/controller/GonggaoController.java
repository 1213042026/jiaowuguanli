package cn.jiaowu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Gonggao;
import cn.jiaowu.services.IGonggaoService;
import cn.jiaowu.util.ServerResponse;
@Controller
@RequestMapping("/gonggao")
public class GonggaoController {

	@Autowired
	private IGonggaoService iGonggaoService;

	@RequestMapping(value = "list")
	public String list(Model model) {
		model.addAttribute("list", iGonggaoService.getAll());
		return "/manage/admin/gonggaoList";
	}
	
	@RequestMapping(value = "add")
	public String add(Gonggao gonggao) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gonggao.setAddtime(format.format(new Date()));
		iGonggaoService.saveOrUpdateGonggao(gonggao);
		return "redirect:list";
	}
	
	@RequestMapping(value = "update")
	public String update(Gonggao gonggao) {
		iGonggaoService.saveOrUpdateGonggao(gonggao);
		return "redirect:list";
	}
	
	@RequestMapping(value = "detail{id}",method=RequestMethod.GET)
	@ResponseBody
	public ServerResponse<Gonggao> detail(@PathVariable("id") int id) {
		return iGonggaoService.getGonggaoDetail(id);
	}
	
	@RequestMapping(value = "del{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id) {
		iGonggaoService.deleteByPrimaryKey(id);
		return "redirect:list";
	}
	@RequestMapping(value = "listJson")
	@ResponseBody
	public ServerResponse listJson() {
		return iGonggaoService.getAllGonggao();
	}
}
