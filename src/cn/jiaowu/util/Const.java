package cn.jiaowu.util;
import java.util.Set;

public class Const {

    public static final String CURRENT_USER = "currentUser";
    public static final String CURRENT_ROLE = "currentRole";
    public static final String ROOT="/jiaowu/";
    
   public interface Role{
    	int ROLE_ADMIN = 0;//管理员
    	int ROLE_TEACHER=1;//教师
        int ROLE_STUDENT = 2; //普通用户 
    }
}
