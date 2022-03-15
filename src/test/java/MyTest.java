import com.LewisCloud.common.core.domain.model.CreateProject;
import com.LewisCloud.common.core.domain.model.RegisterUser;
import com.LewisCloud.service.ProjectService;
import com.LewisCloud.service.UserService;
import com.LewisCloud.service.label.SubmitProcessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MyTest {
//    @Autowired
//    @Qualifier("userService")
//    private UserService userService;
//
//    @Autowired
//    @Qualifier("projectService")
//    private ProjectService projectService;
//
//    @Test
//    public void TestUser(){
//        userService.registerUser(new RegisterUser(0, "testManager", "manager", "123@qq.com", "123", "123"));
//    }
//
//    @Test
//    public void TestProject(){
//        projectService.createProject(new CreateProject("这是一个测试项目", "测试", 20));
//    }

    @Autowired
    private SubmitProcessService submitProcessService;

    @Test
    public void TestSubmit() {
        String submitString = "{\n" +
                "        \"ProjectName\": \"test1\",\n" +
                "        \"createdAt\": \"2021-07-03 16:39:17\",\n" +
                "        \"Seconds\": 10,\n" +
                "        \"Data\": {\n" +
                "            \"svgArr\": [\n" +
                "                {\n" +
                "                    \"uuid\": \"d671e000-dbdb-11eb-84b8-dbc64ec45ec9\",\n" +
                "                    \"data\": [\n" +
                "                        {\n" +
                "                            \"x\": 757.5754716981131,\n" +
                "                            \"y\": 300.9433962264151\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 865.122641509434,\n" +
                "                            \"y\": 402.8301886792453\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 925.4999999999999,\n" +
                "                            \"y\": 614.1509433962264\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 910.4056603773585,\n" +
                "                            \"y\": 625.4716981132075\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 676.4433962264151,\n" +
                "                            \"y\": 597.1698113207547\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 663.2358490566037,\n" +
                "                            \"y\": 591.5094339622641\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 504.7452830188679,\n" +
                "                            \"y\": 483.9622641509434\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"x\": 210.40566037735846,\n" +
                "                            \"y\": 291.50943396226415\n" +
                "                        }\n" +
                "                    ],\n" +
                "                    \"radius\": 3,\n" +
                "                    \"subarea\": 1,\n" +
                "                    \"color\": \"#ae0bc7\",\n" +
                "                    \"name\": \"bj3\",\n" +
                "                    \"tool\": \"line\",\n" +
                "                    \"isClosed\": true,\n" +
                "                    \"secondaryLabel\": []\n" +
                "                }\n" +
                "            ],\n" +
                "            \"classifications\": [\n" +
                "                {\n" +
                "                    \"uuid\": \"d671e000-dbdb-11eb-84b8-dbc64ec45ec9\",\n" +
                "                    \"classId\": 55\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"LabelType\": \"提交\",\n" +
                "        \"Reviews\": \"通过\",\n" +
                "        \"imagePath\": \"http://images.awkvector.comhttps://jxxl-tagtag-juexing.oss-cn-hangzhou.aliyuncs.com/6635/2021/07/03/c309c5daecc672c9d0013cbd0578f71c.jpg\",\n" +
                "        \"imageWidth\": 2401,\n" +
                "        \"imageHeight\": 1600,\n" +
                "        \"imageSize\": 689543,\n" +
                "        \"id\": 3220563,\n" +
                "        \"imageName\": \"287d3e0d.jpg\",\n" +
                "        \"DataSetName\": \"test_1\",\n" +
                "        \"ProjectId\": 0\n" +
                "    }";

//        submitProcessService.getSubmit(submitString);
    }

}











