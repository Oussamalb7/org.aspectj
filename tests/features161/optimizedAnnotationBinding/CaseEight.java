// CaseEight - annotations in packages two
package p.q.r;

import java.lang.annotation.*;

public class CaseEight {

  public static void main(String []argv) {
      CaseEight o = new CaseEight();
      o.a();
      o.b();
      o.c();
      o.d();
      o.e();
    }

                       public void a() {}
    @Anno(Level.NONE)  public void b() {}
    @Anno(Level.ONE)   public void c() {}
    @Anno(Level.TWO)   public void d() {}
    @Anno(Level.THREE) public void e() {}

  }

  enum Level { NONE, ONE, TWO, THREE; }

  @Retention(RetentionPolicy.RUNTIME)
  @interface Anno { Level value();}
  
aspect X {

  before(p.q.r.Level l): execution(@Anno !@Anno(Level.NONE) * *(..)) && @annotation(Anno(l)) {
    System.out.println(l);
  }
}
