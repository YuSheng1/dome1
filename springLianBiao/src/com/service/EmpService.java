package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Dept;
import com.bean.Emp;

public interface EmpService {
	//显示
     public List<Emp> savaEmp();
     public List<Dept> savaDept();
     
     //添加
     public void savabeanEmp(Emp emp);
     public void savabeanDept(Dept dept);
     
     //根据员工的id进行查找
     public Emp getEmpById(int id);
     //根据部门的id进行查找
     public Dept getDeptById(int id);
     //根据id进行删除
     public void delemp(int id);
     
     //修改
     public void update(Emp emp);
     
     //查询
     public List<Emp> emplist(String ename);
     public List<Emp> emplistto(int did);
     public List<Emp> listAll(Map map);
} 
