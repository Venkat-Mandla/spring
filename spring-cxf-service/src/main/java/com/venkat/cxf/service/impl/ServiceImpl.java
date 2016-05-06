/**
 * 
 */
package com.venkat.cxf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkat.data.domain.EmployeeDataBean;
import com.venkat.data.impl.EmployeeDaoImpl;
import com.venkat.venkatstore.mobilestore.MobileStore;
import com.venkat.venkatstore.types.mobilestore.BuyNewMobielRequest;
import com.venkat.venkatstore.types.mobilestore.BuyNewMobielResponse;

/**
 * @author Venkat
 *
 */
@Service("cxfService")
public class ServiceImpl implements MobileStore{

	@Autowired
	private EmployeeDaoImpl dao;
	
	@Autowired
	public BuyNewMobielResponse buyNewMobile(BuyNewMobielRequest request) {
		EmployeeDataBean empDataRequest=new EmployeeDataBean();
		empDataRequest.setName(request.getMobileName());
		empDataRequest.setPhoneNumber(request.getMobileModel());
		empDataRequest.setId(Integer.valueOf(request.getAccountDetails().getAccNumber()));
		dao.persistsEmpDetails(empDataRequest);
		return new BuyNewMobielResponse();
	}

	public EmployeeDaoImpl getDao() {
		return dao;
	}

	public void setDao(EmployeeDaoImpl dao) {
		this.dao = dao;
	}

	
}
