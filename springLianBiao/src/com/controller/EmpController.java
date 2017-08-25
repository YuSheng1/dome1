package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Dept;
import com.bean.Emp;
import com.service.EmpService;

@Controller
@RequestMapping("/item")
public class EmpController {
     @Autowired
     public EmpService empService;
     //��ʾemp
     @RequestMapping("/emptian")
	  public String emptian(HttpServletRequest request){
	  	List<Emp> emplist=empService.savaEmp();	
	  	List<Dept> deptlist=empService.savaDept();
	  	request.setAttribute("userlist", emplist);
	  	request.setAttribute("deptlist", deptlist);
	  	return "emplist";
	  }
     //��Ӳ���
     @RequestMapping("/todeptAdd")
 	 public String todeptAdd(){
 		return "deptadd";
 	  }
     //��ʾ dept�������Ա��
     @RequestMapping("/depttian")
	  public String depttian(HttpServletRequest request){
	  	List<Dept> deptlist=empService.savaDept();	
	  	//System.out.println(deptlist.size());
	  	request.setAttribute("userlist", deptlist);
	  	return "empadd";
	  }
   //���Ա��
  	@RequestMapping("/saveEmp")
  	public String saveEmp(Emp emp,int did){
  		if(did!=-1){
  			Dept dept=empService.getDeptById(did);
  			emp.setDept(dept);
  		}
  		empService.savabeanEmp(emp);
  		return "redirect:/item/emptian";
  	}
  	//��Ӳ���
  	@RequestMapping("/saveDept")
  	public String saveDept(Dept dept){
  		this.empService.savabeanDept(dept);
  		return "redirect:/item/emptian";
  	}
     //ɾ��
     @RequestMapping("/delete/{id}")
 	 public String delete(@PathVariable("id")int id){
 		this.empService.delemp(id);
 		return "redirect:/item/emptian";
 	}
     //���涼���޸Ĳ���
     @RequestMapping("/initData/{id}")
 	public String initData(@PathVariable("id")int id,HttpServletRequest request){
    	 System.out.println("666666666****"+id);
 		Emp emp=this.empService.getEmpById(id);
 		
 		List<Dept> deptlist=empService.savaDept();
 		request.setAttribute("deptlist",deptlist);
 		request.setAttribute("emp", emp);
 		return "update";
 	}
     @RequestMapping("/update")
     public String update(Emp emp,int did){   	
    	 if(did!=-1){
    		 emp.setDept(empService.getDeptById(did));
    	 }
    	 this.empService.update(emp);
    	 return "redirect:/item/emptian";
    	 
     }
   //ģ����ѯ**
     @RequestMapping("/mohu")
     public String mohu(int did,String ename,HttpServletRequest request){
    	 System.out.println("sname+++"+ename);
    	 Map map=new HashMap();
 		map.put("qname",ename);
 		map.put("did",did);
 		//��ģ����ѯ������
    		List<Emp> userlist=empService.listAll(map);
    	  	request.setAttribute("userlist", userlist);
    	  	//������
    		List<Dept> deptlist=empService.savaDept();
    	  	request.setAttribute("deptlist", deptlist);
    	  	
    	  	request.setAttribute("ename", ename);
    	  	request.setAttribute("udid", did);
    	    return "emplist";  	
         }
}

