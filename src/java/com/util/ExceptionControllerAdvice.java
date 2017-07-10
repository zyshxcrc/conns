package util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Administrator on 2017/7/10.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public String doClassCastException(){
        return "error";
    }

}
