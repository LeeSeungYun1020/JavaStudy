package tpc;

public class TPC27_2 {
}

interface A{
    void a();
}

interface B extends A {
    void b();
}

class C implements B {

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}
