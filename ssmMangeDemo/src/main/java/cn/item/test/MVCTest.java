package cn.item.test;


import cn.item.bean.Employee;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:springConfig.xml","classpath:springMVConfig.xml"})
public class MVCTest {
    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Test
    public void testPage() throws Exception{
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
       MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/Employee/emps").param("pn", "1")).andReturn();
       //获取request
        MockHttpServletRequest request = mvcResult.getRequest();
        //得到域中对象
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码"+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());

        System.out.println("显示页码：");
        int a[] = pageInfo.getNavigatepageNums() ;
        for(int i : a){
            System.out.println("  "+i);
        }
        List<Employee> emps = pageInfo.getList();
        for(Employee e : emps)
        {
            System.out.println(e.getEmpId() + " " + e.getEmail()+e.getDepartment().getDeptName());
        }
    }
}
