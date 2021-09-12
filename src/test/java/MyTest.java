import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.service.ProjectService;
import com.LewisCloud.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyTest {
    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;

    @Test
    public void TestUser(){
        userService.registerUser(new RegisterUser(0, "testManager", "manager", "123@qq.com", "123", "123"));
    }

    @Test
    public void TestProject(){
        projectService.createProject(new CreateProject("这是一个测试项目", "测试", 20));
    }


}











