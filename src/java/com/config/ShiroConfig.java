package config;

import dao.MyRealm;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/30.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myRealm(){
        return new MyRealm();
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(myRealm());
        return defaultSecurityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        /*1.设置Realm extends AuthorizingRealm
        * 2.设置SecurityManager 设置 realms
        * 3.设置ShiroFilterFactoryBean web.xml delegatingFilterProxy filter_name 设置 SecurityManager ShiroFilterChain
        * 4.设置LifeCycleBeanPostProcessor
        * 5.设置MethodInvokingFactoryBean SecurityUtils.setSecurityManager()*/
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> shiroFilterChainMap = new HashMap<String,String>();
        shiroFilterChainMap.put("/select","anon");
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");

        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
