import java.lang.reflect.Method;

public class ShallowOrDeepCopy {
    public static Object verificaDeepCopy(Object clone){
        if (clone instanceof Cloneable){
            Object newClone = deepCopy(clone);
            if(newClone == null)
                return clone;
            else return newClone;
        }
        else return clone;
    }

    private static Object deepCopy(Object clone) {
        try{
            Class<?> x = clone.getClass();
            Method method = x.getMethod("clone");
            return (Object)method.invoke(clone);
        }
        catch(Exception error){ return null; }
    }
}
