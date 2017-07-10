package controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.File;

/**
 * Created by Administrator on 2017/7/6.
 */
@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        //当前Subject
        Subject currentUser = SecurityUtils.getSubject();
        //加密（md5+盐），返回一个32位的字符串小写
        String salt="("+request.getParameter("username")+")";
        String md5Pwd=new Md5Hash(request.getParameter("password"),salt).toString();
        //传递token给shiro的realm
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"),md5Pwd);
        try {
            currentUser.login(token);
            return "welcome";

        } catch (AuthenticationException e) {//登录失败
            request.setAttribute("msg", "用户名和密码错误");
        }
        return "login";
    }
    @RequestMapping(method = RequestMethod.GET)
    public String logins(){
        return "home";
    }
    @RequestMapping(value = "/login/{loginId}",method = RequestMethod.GET)
    public String getLogin(@PathVariable("loginId") long loginId){
        return loginId+"";
    }
    @RequestMapping("doLogin")
    public void doLogin(@RequestPart MultipartFile file, @Valid User user, Error error) throws Exception{
        file.transferTo(new File("/WEB-INF/statics/"+file.getOriginalFilename()));
    }
    @RequestMapping("doLogins")
    public void doLogins(@RequestPart Part file, @Valid User user, Error error) throws Exception{/*使用Part接口时，不需要配置MulpartResolver*/
        file.write(new File("/WEB-INF/statics/"+file.getOriginalFilename()));
    }
}
