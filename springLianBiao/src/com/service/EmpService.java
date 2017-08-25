package com.service;

import java.util.List;
import java.util.Map;

import com.bean.Dept;
import com.bean.Emp;

public interface EmpService {
	//��ʾ
     public List<Emp> savaEmp();
     public List<Dept> savaDept();
     
     //���
     public void savabeanEmp(Emp emp);
     public void savabeanDept(Dept dept);
     
     //����Ա����id���в���
     public Emp getEmpById(int id);
     //���ݲ��ŵ�id���в���
     public Dept getDeptById(int id);
     //����id����ɾ��
     public void delemp(int id);
     
     //�޸�
     public void update(Emp emp);
     
     //��ѯ
     public List<Emp> emplist(String ename);
     public List<Emp> emplistto(int did);
     public List<Emp> listAll(Map map);
} 
