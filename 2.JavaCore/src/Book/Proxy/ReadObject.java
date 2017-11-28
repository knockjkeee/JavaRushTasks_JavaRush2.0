package Book.Proxy;

public class ReadObject implements Interface {

    @Override
    public void doSomething() {
    System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somerhingElse " + arg);
    }
}
