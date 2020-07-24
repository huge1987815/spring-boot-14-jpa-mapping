package com.huge.springboot;

import com.huge.springboot.dao.EmpDao;
import com.huge.springboot.entity.Dept;
import com.huge.springboot.entity.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@SpringBootTest
class SpringBoot14JpaMappingApplicationTests {
    @Autowired
    private EmpDao empDao;
    //查询所有员工信息
    @Test
    void findAllEmp(){
        List<Emp> empList= this.empDao.findAll(Sort.by(Sort.Direction.DESC,"eid"));
        for (Emp emp : empList) {
            System.out.println(emp.getEid()+"\t"+emp.getEname());
        }
    }
    //删除员工信息
    @Test
    void deleteEmp(){
        Emp emp = this.empDao.findById(18).orElse(new Emp());
        this.empDao.delete(emp);
    }
    //修改员工信息
    @Test
    void updateEmp(){
        //修改员工
        Emp emp = this.empDao.findById(18).orElse(new Emp());
        emp.setEname("小红");
        //保存
        this.empDao.save(emp);
    }
    //添加员工信息
    @Test
    @Transactional
    void contextLoads() {
        //写两个部门
        Dept d1=new Dept();
        d1.setDname("研发部");
        Dept d2=new Dept();
        d2.setDname("人事部");
        //写三个员工
        Emp e1=new Emp();
        e1.setEname("张三");
        e1.setSex("男");
        e1.setAge(23);
        Emp e2=new Emp();
        e2.setEname("李四");
        e2.setSex("女");
        e2.setAge(24);
        Emp e3=new Emp();
        e3.setEname("王五");
        e3.setSex("男");
        e3.setAge(25);
        //建立关系
        e1.setDept(d1);
        e2.setDept(d2);
        e3.setDept(d2);
        /*d1.getEmpSet().add(e1);
        d2.getEmpSet().add(e2);
        d2.getEmpSet().add(e3);*/
        //保存
        this.empDao.save(e1);
        this.empDao.save(e2);
        this.empDao.save(e3);
    }

}
