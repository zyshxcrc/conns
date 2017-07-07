import dao.UserDAO;
import dao.impl.UserDaoImpl;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.CGLIBDynamic;
import util.JDKDynamic;

public class Test {
    public static void main(String[] args)
    {
        UserDAO userDAO = new JDKDynamic(new UserDaoImpl()).getProxy();
        userDAO.getUser(1);
        UserDAO userDAO1 = CGLIBDynamic.getInstance().getProxy(UserDaoImpl.class);
        userDAO1.getUser(1);
        ApplicationContext context = new AnnotationConfigApplicationContext(config.ShiroConfig.class);
        AbstractShiroFilter springShiroFilter = (AbstractShiroFilter) context.getBean("shiroFilterFactoryBean");
        SecurityManager securityManager = (SecurityManager) context.getBean("securityManager");
        System.out.println(securityManager.toString());
        System.out.println(springShiroFilter.toString());

    }

}
