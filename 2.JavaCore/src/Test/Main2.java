package Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {
        Object[] elements = new Object[1000];
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }
        Integer key = new Random().nextInt(elements.length) + 1;
        int result = Arrays.binarySearch(elements, key);
        if (result >= 0) {
            System.out.println(elements[result]);
        }
    }


    static class TraceHandler implements InvocationHandler {
        public Object targer;

        public TraceHandler(Object t) {
            this.targer = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.print(targer);
            System.out.print("." + method.getName() + "(");
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    if (i < args.length - 1) {
                        System.out.print(", ");
                    }
                }
            }
            System.out.println(")");

            return method.invoke(targer, args);
        }
    }
}

