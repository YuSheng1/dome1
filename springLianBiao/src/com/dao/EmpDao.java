package com.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Dept;
import com.bean.Emp;

@Transactional
@Component
public class EmpDao {
	@Autowired
    private SessionFactory sf;
    
    public Session getsession(){
    	return this.sf.getCurrentSession();
    }
    //添加
    public void savabeanEmp(Emp emp){
    	getsession().save(emp);
    }
    //添加
    public void savabeanDept(Dept dept){
    	getsession().save(dept);
    }
    //显示员工
    public List<Emp> elist(){
    	String hql="from Emp";
    	List<Emp> elist=getsession().createQuery(hql).list();		
    	return elist;
    }
    //显示部门
    public List<Dept> dlist(){
    	String hql="from Dept";
    	List<Dept> dlist=getsession().createQuery(hql).list();
    	return dlist;
    }
    //----------****删除*****-----------
    
    public Emp getEmpById(int id){
    	Session session=getsession();
    	Emp emp=(Emp)session.get(Emp.class,id);
    	return emp;
    }
    public Dept getDeptById(int id){
    	Session session=getsession();
    	Dept dept=(Dept)session.get(Dept.class,id);
    	return dept;
    }
    public void delemp(Emp emp){
		Session session=getsession();
		emp.setDept(null);
		session.delete(emp);
	}
    //---------******修改*****---------
    public void update(Emp emp){
    	Session session=getsession();
    	session.update(emp);
    }
    
    //---------模糊查询-----------
    public List<Emp> deptlist(String dname){
    	String hql="" + "select * from Emp where id in(select id dept where dname='"+dname+"')";
    	return null;
    }
    public List<Emp> emplist(String ename){
    	Session session=getsession();
    	String hql="from Emp e where e.ename like '%"+ename+"%'";
    	List <Emp> userlist=session.createQuery(hql).list();
    	return userlist;
    }
    public List<Emp> emplistto(int did){
    	Session session=getsession();
    	String hql="from Emp where did = "+did+"";
    	List <Emp> userlist=session.createQuery(hql).list();
    	return userlist;
    }

	public List<Emp> listAll(Map map){
		String hql="from Emp where 0=0 ";//
		hql=listDataHql(hql, map);
		Session session=getsession();
		List<Emp> list=session.createQuery(hql).list();
		return list;
	}
	
	public String listDataHql(String hql,Map map){
		String qname=(String)map.get("qname");
		int did=(int)map.get("did");
		System.out.println("123"+qname+"---"+did);
		if(qname!=null&&!qname.equals("")&&did!=-1){
			System.out.println("3");
			hql+=" and ename like '%"+qname+"%' and did='"+did+"'";
		}else if(qname==null||qname.equals("")&&did!=-1){
			System.out.println("1");
			hql+=" and  did='"+did+"'";
		}
		else if(qname!=null&&!qname.equals("")&&did==-1){
			System.out.println("2");
			hql+=" and ename like '%"+qname+"%' ";
		}
		return hql;
	}
}
