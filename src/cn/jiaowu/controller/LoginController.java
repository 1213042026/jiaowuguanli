package cn.jiaowu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Admin;
import cn.jiaowu.entity.Gonggao;
import cn.jiaowu.entity.Laoshi;
import cn.jiaowu.entity.Xuesheng;
import cn.jiaowu.services.IAdminService;
import cn.jiaowu.services.IGonggaoService;
import cn.jiaowu.services.ILaoshiService;
import cn.jiaowu.services.IXueshengService;
import cn.jiaowu.util.Const;
import cn.jiaowu.util.ServerResponse;
import cn.jiaowu.util.Const.Role;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private IAdminService iAdminService;
    @Autowired
    private ILaoshiService iLaoshiService;
    @Autowired
    private IXueshengService iXueshengService;
    @Autowired
    private IGonggaoService iGonggaoService;
    
    @RequestMapping(value="login")
    @ResponseBody
    public ServerResponse login(String username, String password, int role,HttpSession session){
    	//查询公告，供用户登录后显示
    	List<Gonggao> gonggaos=iGonggaoService.getAll();
    	if(gonggaos!=null&&gonggaos.size()>0){
    		if(gonggaos.size()>5){//只显示最近5条公告
    			gonggaos=gonggaos.subList(0, 5);
    		}
    		session.setAttribute("gonggaos", gonggaos);
    	}
    	if(role==0){
    		ServerResponse<Admin> response = iAdminService.login(username,password);
    		if(response.isSuccess()){
                Admin admin = response.getData();   
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_USER,admin);
                session.setAttribute(Const.CURRENT_ROLE,Role.ROLE_ADMIN);
            }
    		return response;
    	}
    	else if(role==1){
    		ServerResponse<Laoshi> response = iLaoshiService.login(username,password);
    		if(response.isSuccess()){
    			Laoshi laoshi = response.getData();   
                //说明登录的是老师
                session.setAttribute(Const.CURRENT_USER,laoshi);
                session.setAttribute(Const.CURRENT_ROLE,Role.ROLE_TEACHER);
            }
    		return response;
    	}
    	else{
    		ServerResponse<Xuesheng> response = iXueshengService.login(username,password);
    		if(response.isSuccess()){
    			Xuesheng xuesheng = response.getData();   
                //说明登录的是学生
                session.setAttribute(Const.CURRENT_USER,xuesheng);
                session.setAttribute(Const.CURRENT_ROLE,Role.ROLE_STUDENT);
            }
    		return response;
    	}
    }
    @RequestMapping(value="logout")
    public String logout(HttpSession session){
    	session.invalidate();
    	return "redirect:/login.jsp";
    }
}
