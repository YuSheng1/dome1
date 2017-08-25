package com.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Dept;
import com.bean.Emp;
import com.dao.EmpDao;
import com.service.EmpService;
@Service
public class EmpServiceimp implements EmpService{
		@Autowired
		public EmpDao empdao;
		//显示员工
		@Override
		public List<Emp> savaEmp(){
			return this.empdao.elist();
		}
		//显示部门
		@Override
		public List<Dept> savaDept(){
			return this.empdao.dlist();
		}
		//添加员工
		@Override
		public void savabeanEmp(Emp emp) {
			 this.empdao.savabeanEmp(emp);
		}
		//添加部门
		@Override
		public void savabeanDept(Dept dept){
			this.empdao.savabeanDept(dept);
		}
		//-----******-----
		
		@Override
		public Emp getEmpById(int id){
			return this.empdao.getEmpById(id);
		}
		@Override
		public Dept getDeptById(int id){
			return this.empdao.getDeptById(id);
		}
		@Override
		public void delemp(int id){
			Emp emp=getEmpById(id);
			this.empdao.delemp(emp);
		}
		
		//-------修改------
		@Override
		public void update(Emp emp){
			this.empdao.update(emp);
		}
		
		//---------模糊查询-----------
		@Override
		public List<Emp> emplist(String ename){
			return this.empdao.emplist(ename);
		}
		@Override
		public List<Emp> emplistto(int did){
        return this.empdao.emplistto(did);
		}
		@Override
		public List<Emp> listAll(Map map) {
			
			return this.empdao.listAll(map);
		}
}
