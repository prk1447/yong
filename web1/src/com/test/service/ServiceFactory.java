package com.test.service;

import com.test.service.implement.VendorServiceImpl;

public class ServiceFactory 
{
	private static VendorServiceImpl vendorService = new VendorServiceImpl();
	
	public static VendorServiceImpl getVendorService()
	{
		return vendorService;
	}
}
