package cn.item.service;

import cn.item.bean.Department;
import cn.item.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartment() {
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }
}
