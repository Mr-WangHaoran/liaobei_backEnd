import com.liaobei.dao.inter.UserMapper;
import com.liaobei.pojo.User;
import com.liaobei.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author whr
 * @description 测试
 */
public class MainTest {

    private ApplicationContext applicationContext;
    @Before
    public void setApplicationContext(){
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test00(){
        String s = DateUtil.DateFormat(new Date());
        System.out.println(s);
    }

    @Test
    public void test01(){
        UserMapper mapper = applicationContext.getBean(UserMapper.class);
        User user = mapper.findUserByTelAndPwd("123", "123456");
        System.out.println(user);
    }

}
