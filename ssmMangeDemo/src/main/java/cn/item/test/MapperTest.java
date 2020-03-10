package cn.item.test;

import cn.item.bean.Department;
import cn.item.bean.Employee;
import cn.item.dao.DepartmentMapper;
import cn.item.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)//spring 单元测试，可以自动注入组件
@ContextConfiguration(locations = {"classpath:springConfig.xml"})//
public class MapperTest {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    SqlSession sqlSession;


    @Test
    public void test(){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("springConfig.xml");
//        EmployeeMapper employeeMapper =  applicationContext.getBean(EmployeeMapper.class);
//        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(1);
//        System.out.println(employee.getdId())；
    //departmentMapper.insert(new Department(6,"人力资源部"));
         //employeeMapper.insertSelective(new Employee(null, "关羽", "n", "54642343@qq.com", 4));
         //批量插入，使用批量操作的sqlsession
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i = 0;i < 30;i++)
        {
            String uid = UUID.randomUUID().toString().substring(0,5)+i%3;
            employeeMapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));
        }

    }
}
