package Book.Proxy;

public class SimpleProxy implements Interface{
    private Interface proxy;

    public SimpleProxy(Interface proxy) {
        this.proxy = proxy;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse " + arg);
        proxy.somethingElse(arg);
    }
}
