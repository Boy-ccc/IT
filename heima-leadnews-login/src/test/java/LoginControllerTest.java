import com.heima.login.controller.v2.LoginV2Controller;
import com.heima.model.user.pojos.ApUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class LoginControllerTest {

    @Autowired
    private LoginV2Controller loginV2Controller;

    @Test
    /**
     * 用户名和密码正确
     */
    public void test1() {
        ApUser apUser = new ApUser();
        apUser.setName("abc");
        apUser.setPassword("123456");
        Assert.assertEquals(200, java.util.Optional.ofNullable(loginV2Controller.login(apUser).getCode()));
    }

    @Test
    /**
     * 用户名存在，密码不正确
     */
    public void test2() {
        ApUser apUser = new ApUser();
        apUser.setName("abc");
        apUser.setPassword("123457");
        Assert.assertEquals("密码错误", java.util.Optional.ofNullable(loginV2Controller.login(apUser).getErrorMessage()));
    }

    @Test
    /**
     * 用户名不存在
     */
    public void test3() {
        ApUser apUser = new ApUser();
        apUser.setName("abcd");
        apUser.setPassword("123567");
        Assert.assertEquals("密码错误", java.util.Optional.ofNullable(loginV2Controller.login(apUser).getErrorMessage()));
    }

}
