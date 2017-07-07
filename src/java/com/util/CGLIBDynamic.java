package util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/6.
 */
public class CGLIBDynamic implements MethodInterceptor{
    private static CGLIBDynamic cglibDynamic = new CGLIBDynamic();

    public CGLIBDynamic() {
    }

    public static CGLIBDynamic getInstance(){
        return cglibDynamic;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class cls){
        return (T)Enhancer.create(cls,this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("12");
        Object result = methodProxy.invokeSuper(o,objects);
        return result;
    }
}
