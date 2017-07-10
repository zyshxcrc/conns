package config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2017/7/10.
 */
public class ServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic servlet = servletContext.addServlet("", "");
        servlet.addMapping("/");
        FilterRegistration.Dynamic filter = servletContext.addFilter("","");
        filter.addMappingForUrlPatterns(null,false,"");
    }
}
