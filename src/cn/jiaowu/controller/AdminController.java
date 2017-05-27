package cn.jiaowu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jiaowu.entity.Admin;
import cn.jiaowu.services.IAdminService;
import cn.jiaowu.util.Const;
import cn.jiaowu.util.ServerResponse;
import cn.jiaowu.util.Const.Role;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService iAdminService;
    
    @RequestMapping(value = "update_pwd",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Admin> update_pwd(HttpSession session,Admin user){
        Admin currentUser = (Admin)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        if(!currentUser.getUserPw().equals(user.getOldPass())){
        	return ServerResponse.createByErrorMessage("原密码不正确");
        }
        ServerResponse response = iAdminService.updatePasswordByUsername(currentUser.getUserName(), user.getUserPw());
        return response;
    }
    
    @RequestMapping(value = "update_info",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse update_info(HttpSession session,Admin user){
        Admin currentUser = (Admin)session.getAttribute(Const.CURRENT_USER);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        currentUser.setXingming(user.getXingming());
        ServerResponse response = iAdminService.saveOrUpdateAdmin(currentUser);
        return response;
    }
}
