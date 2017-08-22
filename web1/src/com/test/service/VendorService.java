package com.test.service;

import java.util.List;

import com.test.dto.Vendor;

public interface VendorService 
{
	public List<Vendor> selectVendorsList(Vendor vendor);
	
	public int insertVendor(Vendor vendor);
	
	public Vendor selectVendor(Vendor vendor);
	
	public int deleteVendor(Vendor vendor);
	
	public int updateVendor(Vendor vendor);
}
