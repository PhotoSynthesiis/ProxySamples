package CGLib_Package;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before eat I cannot move");
        methodProxy.invokeSuper(obj, args);
        System.out.println("after eat I want to sleep");
        return "this is a life of a primitive animal";
    }
}
