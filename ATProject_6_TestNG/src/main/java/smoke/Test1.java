package smoke;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1 {
    @DataProvider (name = "db_provider")
    public static  Object[][] dbData () {
        return new Object[][] {
                {"SQL", new Integer(1)},
                {"NOSQL", new Integer(2)}
        };
    }
    @Parameters ({"db"})
    @Test (groups = {"smokeTest", "regress"}, dataProvider = "db_provider")
    public void test1 (String e1, int e2) {
        System.out.println("Test1 " + e1 + " " + e2);
    }

    @Test (groups = {"regress"})
    public void test11 () {
        System.out.println("Test11");
    }

    @Test (groups = {"regress"})
    public void test111 () {
        System.out.println("Test111");
    }
}
