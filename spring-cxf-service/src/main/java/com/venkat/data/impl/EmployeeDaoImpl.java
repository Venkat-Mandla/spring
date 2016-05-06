/**
 * 
 */
package com.venkat.data.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.venkat.data.domain.EmployeeDataBean;

/**
 * @author Venkat
 *
 */
@Repository("empDao")
public class EmployeeDaoImpl {
	
	 @Autowired  
	 private SessionFactory sessionFactory; 
	
	public void persistsEmpDetails(EmployeeDataBean request){
		sessionFactory.getCurrentSession().saveOrUpdate(request);
	}
	public EmployeeDataBean retriveEmpDetails(String empId){
		return (EmployeeDataBean) sessionFactory.getCurrentSession().get(EmployeeDataBean.class, empId);
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
