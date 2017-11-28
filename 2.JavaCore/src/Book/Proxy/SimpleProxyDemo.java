package Book.Proxy;

public class SimpleProxyDemo {
    public static void comsumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonono");
    }

    public static void main(String[] args) {
        comsumer(new ReadObject());
        comsumer(new SimpleProxy(new ReadObject()));
    }
}
