package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ConnWebAPPInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {/*web.xml配置*/
    /*1.ServletContainerInitializer实现类配置servlet容器
    * 2.SpringServletContainerInitializer委托实现WebApplicationInitializer接口的实现类配置
    * 3.AbstractAnnotationConfigDispatcherServletInitializer*/
    @Override
    protected Class<?>[] getRootConfigClasses() {/*返回的类配置spring容器ContextLoaderListener配置的其他bean*/
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {/*返回的类配置Web调用DispatcherServlet配置使用的bean*/
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {/*设置dispatcherServlet属性*/
        registration.setMultipartConfig(new MultipartConfigElement("/WEB-INF/statics/",2097152,4092,0));
        //registration.setLoadOnStartup(3);
        //registration.setInitParameter();
    }

    @Override
    protected Filter[] getServletFilters() {/*设置filter*/
        return super.getServletFilters();
    }
}
