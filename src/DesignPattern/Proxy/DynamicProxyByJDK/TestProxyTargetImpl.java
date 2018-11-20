package DesignPattern.Proxy.DynamicProxyByJDK;

public class TestProxyTargetImpl implements TestProxyTarget {

    @Override
    public void sayHello() {
        System.out.println("do sth by myself !");

    }
}
