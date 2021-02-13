package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.rmi.dgc.Lease;

public class ProxyTest {
    public static void main(String[] args) {
        Lenovo lenovo = new Lenovo();
        /**
         * 1.类加载器
         * 2.接口数组
         * 3.处理器
         */
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写方法
             * @param proxy 代理对象
             * @param method 代理对象调用的方法，被封装为对象
             * @param args 代理对象调用方法时传递的参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("该方法执行了...");
//                System.out.println(method.getName());
//                System.out.println(args[0]);
////                System.out.println(proxy);
                //增强参数
                //判断是否是sale方法
                if (method.getName().equals("sale")) {
                    double money = (double) args[0];
                    money = money * 85 / 100;
                    System.out.println("专车接");
                    String obj = (String) method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    //增强返回值

                    return obj + "——鼠标垫";
                } else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });

        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
//        proxy_lenovo.show();
    }
}
