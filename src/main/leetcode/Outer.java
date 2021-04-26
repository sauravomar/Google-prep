package main.leetcode;


//public class Outer
//{
//    private int data = 10;
//
//    class Inner
//    {
//        private int data = 20;
//        private int getData()
//        {
//            return data;
//        }
//        public void main(String[] args)
//        {
//            Inner inner = new Inner();
//            System.out.println(inner.getData());
//
//        }
//    }
//    private int getData()
//    {
//        return data;
//    }
//    public static void main(String[] args)
//    {
//        Outer outer = new Outer();
//        Outer.Inner inner = outer.new Inner();
//        System.out.printf("%d", outer.getData());
////        inner.main(args);
//    }
//}

interface OuterInterface
{
    public void InnerMethod();
    public interface InnerInterface
    {
        public void InnerMethod();
    }
}
public class Outer implements OuterInterface.InnerInterface, OuterInterface
{
    public void InnerMethod()
    {
        System.out.println(100);
    }


    public static void main(String[] args)
    {
        Outer obj = new Outer();
        obj.InnerMethod();
    }
}
 class Test implements Runnable
{
    public void run()
    {
        System.out.printf("%d",3);
    }
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(new Test());
        thread.start();
        System.out.printf("%d",1);
        thread.join();
        System.out.printf("%d",2);
    }

}



