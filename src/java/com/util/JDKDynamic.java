package util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/7/6.
 */
public class JDKDynamic implements InvocationHandler {
    private Object target;
    public JDKDynamic(Object object){
        this.target = object;
    }
    @SuppressWarnings("unchecked")
    public <T> T getProxy(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("12");
        Object result = method.invoke(target,args);
        return result;
    }
}
