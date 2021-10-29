package smoke;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {
    /*@Test (groups = {"smokeTest", "regress"})
    public void test2 () {
        System.out.println("Test2");
    }

    @Test (groups = {"smokeTest", "regress"}, dependsOnMethods = {"test2"}, alwaysRun = true) //зависимость от выполения метода test2 (жёсткая без alwaysRun = true)
    public void test21 () {
        System.out.println("Test21");
    }
    @Test (groups = {"smokeTest", "regress"}, dependsOnGroups = "smokeTest.*", alwaysRun = true) //зависимость от выполения всех методов из группы "smokeTest" (жёсткая без alwaysRun = true)
    public void test211 () {
        System.out.println("Test211");
    }*/
    @Test (retryAnalyzer = Retry.class)
    public void test2111 () {
        System.out.println("Test2111");
        Assert.fail();
    }
}
