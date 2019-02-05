package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

@SuppressWarnings("deprecation")
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try
		{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Supplier> listSuppliers() {
		Session session=sessionFactory.openSession();
		@SuppressWarnings({ "unchecked" })
		Query<Supplier> query=session.createQuery("from Supplier");
		List<Supplier> listSuppliers=query.list();
		session.close();
		return listSuppliers;
	}

	public Supplier getSupplier(int supplierID) {
		Session session=sessionFactory.openSession();
		Supplier supplier=session.get(Supplier.class,supplierID);
		session.close();
		return supplier;

	}
}
