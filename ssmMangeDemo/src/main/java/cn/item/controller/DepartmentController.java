package cn.item.controller;

import cn.item.bean.Department;
import cn.item.bean.Message;
import cn.item.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    /*
    * 返回所有的部门信息*/
    @RequestMapping("/depts")
    @ResponseBody
    public Message getDept(){
        List<Department> list = departmentService.getAllDepartment();
        return  Message.success().add("depts",list);
    }
}
