package JDKDynamicProxy_Package;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloWorldHandler implements InvocationHandler {
    private Object objOriginal;

    public HelloWorldHandler(Object objOriginal) {
        this.objOriginal = objOriginal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("what is proxy : " + proxy.getClass().getName());   // proxy参数传递的即是代理类的实例。
        doBefore();
        method.invoke(objOriginal, args);
        doAfter();

        return null;
    }

    private void doBefore() {
        System.out.println("Before");
    }

    private void doAfter() {
        System.out.println("after");
    }
}
