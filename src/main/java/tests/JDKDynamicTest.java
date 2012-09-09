package tests;

import JDKDynamicProxy_Package.HelloWorld;
import JDKDynamicProxy_Package.HelloWorldHandler;
import JDKDynamicProxy_Package.HelloWorldImp;

import java.lang.reflect.Proxy;

public class JDKDynamicTest {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorldImp();
        HelloWorldHandler helloWorldHandler = new HelloWorldHandler(helloWorld);
        HelloWorld helloWorldProxy = (HelloWorld) Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(), helloWorldHandler);
        // Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)做了以下几件事.
        //（1）根据参数loader和interfaces调用方法 getProxyClass(loader, interfaces)创建代理类$Proxy0.$Proxy0类 实现了interfaces的接口,并继承了Proxy类.
        //（2）实例化$Proxy0并在构造方法中把DynamicSubject传过去,接着$Proxy0调用父类Proxy的构造器,为h赋值

        // getClass()：取得当前对象所属的Class对象

        System.out.println("Is helloWorldProxy an instance of Proxy? " + (helloWorldProxy instanceof Proxy));
        System.out.println("proxy's class name : " + helloWorldProxy.getClass().getName());
        System.out.println("proxy's interfaces : " + helloWorldProxy.getClass().getInterfaces());
        helloWorldProxy.sayHelloWorld();
    }
}
