package CGLib_Package;

import net.sf.cglib.proxy.Enhancer;

public class PrimitiveProxy {
    public Object createProxy(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        // 用Enhancer生成一个原有类的子类，并且设置好callback ， 则原有类的每个方法
        // 调用都会转成调用实现了MethodInterceptor接口的proxy的intercept() 函数
        enhancer.setSuperclass(targetClass);
        enhancer.setCallback(new MyMethodInterceptor());
        return enhancer.create();
    }
}
