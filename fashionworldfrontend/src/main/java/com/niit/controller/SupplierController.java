package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
    SupplierDAO supplierDAO;
	
	
	@RequestMapping("/supplier")
	public String showSupplier(Model m)
	{
		List<Supplier> listCategories=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers",listCategories);
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(Model m,@RequestParam("sName")String supplierName,@RequestParam("sAddr")String supplierAddr)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierDAO.addSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{supplierID}")
	public String deleteSupplier(Model m,@PathVariable("supplierID")int supplierID)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierID);
		supplierDAO.deleteSupplier(supplier);
		
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
		@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(Model m,@RequestParam("sID")int supplierID,@RequestParam("sName")String supplierName,@RequestParam("sAddr")String supplierAddr)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierID);
		supplier.setSupplierName(supplierName);
		supplier.setSupplierAddr(supplierAddr);
		supplierDAO.updateSupplier(supplier);
		
		List<Supplier> listSuppliers=supplierDAO.listSuppliers();
		m.addAttribute("listSuppliers", listSuppliers);
		
		m.addAttribute("pageinfo","Manage Supplier");
		return "Supplier";
	}
		@RequestMapping(value="/editSupplier/{supplierID}")
		public String editSupplier(Model m,@PathVariable("supplierID")int supplierID)
		{
			Supplier supplier=supplierDAO.getSupplier(supplierID);
			
			m.addAttribute("supplier",supplier);
			m.addAttribute("pageinfo","Manage Supplier");
			return "UpdateSupplier";
		}

}
