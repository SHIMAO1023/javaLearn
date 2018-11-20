package DesignPattern.Proxy.DynamicProxyByJDK;

public class testProxy {

    public static void main(String[]args){

        JDKProxy jdkProxy=new JDKProxy();

        TestProxyTarget proxy=(TestProxyTarget) jdkProxy.bind(new TestProxyTargetImpl());

        proxy.sayHello();

    }

}
