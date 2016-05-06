/**
 * 
 */
package com.venkat.cxf.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.venkat.venkatstore.mobilestore.MobileStore;
import com.venkat.venkatstore.types.mobilestore.BuyNewMobielRequest;

/**
 * @author Venkat
 *
 */
public class Application {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext springContext=new ClassPathXmlApplicationContext("META-INF/spring/cxf-context.xml");
		
		
		MobileStore mobileStore=springContext.getBean("storeClient",MobileStore.class);
		System.out.println(mobileStore.buyNewMobile(new BuyNewMobielRequest()));
	}
}
