package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/6/28.
 */
@Configuration
@ComponentScan(basePackages = {"com.domain","com.dao"})
public class UserConfig {
}
