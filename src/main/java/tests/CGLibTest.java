package tests;

import CGLib_Package.Primitive;
import CGLib_Package.PrimitiveProxy;

public class CGLibTest {
    public static void main(String[] args) {
        Primitive primitiveProxy = (Primitive) new PrimitiveProxy().createProxy(Primitive.class);
        primitiveProxy.eat();
    }
}
