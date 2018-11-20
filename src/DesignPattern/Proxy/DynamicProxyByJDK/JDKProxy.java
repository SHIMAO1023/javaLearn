package DesignPattern.Proxy.DynamicProxyByJDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

    //被代理的目标
    private Object _target = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy do sth before target do sth");
        Object obj = method.invoke(_target, args);
        System.out.println("proxy do sth after target do sth");
        return obj;
    }

    //绑定被代理的目标与代理对象的关系，返回代理对象
    public Object bind(Object target) {
        this._target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
