import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(config.ShiroConfig.class);
        AbstractShiroFilter springShiroFilter = (AbstractShiroFilter) context.getBean("shiroFilterFactoryBean");
        SecurityManager securityManager = (SecurityManager) context.getBean("securityManager");
        System.out.println(securityManager.toString());
        System.out.println(springShiroFilter.toString());

    }

}
