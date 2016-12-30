import java.lang.reflect.*;


class Dog{
    private String name = "Tom";

    private void sleep(){
        System.out.println("==> Sleeping");
    }

    public void bark(){
        System.out.println("==> Barking");
    }
}

public class Reflection{

    public static void main(String args[]){
        try{
            fetchClassInformation("Dog");

            invokePrivateMethod(new Dog(), "sleep");
        }catch(Throwable e){
            System.err.println(e);
        }
    }

    static void fetchClassInformation (String className) throws Exception{
        Class cls = Class.forName(className);

        System.out.println("==> Methods of class " + cls.getName());
        for(Method m : cls.getDeclaredMethods()){
            System.out.println(m.toString());
        }

        System.out.println("==> Fields of class " + cls.getName());
        for(Field f : cls.getDeclaredFields()){
            System.out.println(f.toString());
        }
    }

    static void invokePrivateMethod(Object obj, String methodName) throws Exception{
        Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
    }
}



