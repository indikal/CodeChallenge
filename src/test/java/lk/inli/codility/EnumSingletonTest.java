package lk.inli.codility;

import org.junit.Assert;
import org.junit.Test;

public class EnumSingletonTest {

  @Test
  public void testSingleton() {
    String info = "My test info";
    EnumSingleton singleton1 = EnumSingleton.INSTANCE;
    Assert.assertNotNull(info, singleton1.getInfo());

    singleton1.setInfo(info);
    Assert.assertEquals(info, singleton1.getInfo());

    EnumSingleton singleton2 = EnumSingleton.INSTANCE;
    Assert.assertEquals(info, singleton2.getInfo());

    info = "My new info";
    singleton1.setInfo(info);
    Assert.assertEquals(info, singleton1.getInfo());
    Assert.assertEquals(info, singleton2.getInfo());
  }
}
