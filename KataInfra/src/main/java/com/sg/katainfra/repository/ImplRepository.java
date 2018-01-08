package com.sg.katainfra.repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapi.interfaces.IRepository;
import com.sg.katainfra.hibernate.model.Client;
import com.sg.katainfra.hibernate.model.Operation;

@Component
public class ImplRepository implements IRepository {

	/**
	 * @return list of operations
	 */
	public ArrayList<OperationBean> getOperations() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operation.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Query query = session.createQuery("from Operation");
			List<Operation> operationsHQL = query.getResultList();
			ArrayList<OperationBean> operationsBeans = new ArrayList<OperationBean>();
			OperationBean bean;

			for (Operation o : operationsHQL) {
				bean = new OperationBean();
				ClientBean cli = new ClientBean();
				cli.setClientName(o.getClient().getClientName());
				cli.setIdClient(o.getClient().getIdClient());
				cli.setClientPassword(o.getClient().getClientPassword());

				bean.setIdOperation(o.getIdOperation());
				bean.setOperationName(o.getOperationName());
				bean.setOperationDate(o.getOperationDate());
				bean.setAmount(o.getAmount());
				bean.setBalance(o.getBalance());
				bean.setClient(cli);

				operationsBeans.add(bean);
			}

			return operationsBeans;

		} finally {
			factory.close();
		}
	}

	/**
	 * @param name the name of the client
	 * @param password the 4 digits password
	 * @return Client bean
	 */
	public ClientBean getClient(String name, String password) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operation.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Query query = session.createQuery("from Client where clientName= ?1 and clientPassword =:password");
			query.setParameter(1, name);
			query.setParameter("password", password);
			List<Client> clientHQL = query.getResultList();
			
			if(clientHQL.size()>0){
				ClientBean bean = new ClientBean();
				bean.setClientName(clientHQL.get(0).getClientName());
				bean.setClientPassword(clientHQL.get(0).getClientPassword());
				bean.setIdClient(clientHQL.get(0).getIdClient());
				return bean;
			}
			
			System.out.println("client returned : " + clientHQL.size());

			return null;

		} finally {
			factory.close();
		}
	}
	
	
	/**
	 * @param amount the amount to deposit
	 */
	public void persistDeposit(int amount) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operation.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Transaction t1 = session.beginTransaction();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String date = formatter.format(Calendar.getInstance().getTime());

			Query subQuery = session.createQuery("select balance from Operation order by id_op desc");
			subQuery.setMaxResults(1);
			int currentBalance = (Integer) subQuery.getSingleResult();

			Query query = session.createSQLQuery("Insert into ope(op_name,ope_date,amount,balance,fk_idCLI) values(:op_name,:ope_date,:amount,:balance,:fk_idCLI)");
			query.setParameter("op_name","D");
			query.setParameter("ope_date", date);
			query.setParameter("amount", amount);
			query.setParameter("balance",currentBalance+amount);
			query.setParameter("fk_idCLI",1);
			query.executeUpdate();
			t1.commit();

		} finally {
			factory.close();
		}
		
	}
	
	
	/**
	 * @param amount the amount to withdraw
	 */
	public void persistWithdraw(int amount) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operation.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			Transaction t1 = session.beginTransaction();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String date = formatter.format(Calendar.getInstance().getTime());

			Query subQuery = session.createQuery("select balance from Operation order by id_op desc");
			subQuery.setMaxResults(1);
			int currentBalance = (Integer) subQuery.getSingleResult();

			Query query = session.createSQLQuery("Insert into ope(op_name,ope_date,amount,balance,fk_idCLI) values(:op_name,:ope_date,:amount,:balance,:fk_idCLI)");
			query.setParameter("op_name","W");
			query.setParameter("ope_date", date);
			query.setParameter("amount", amount);
			query.setParameter("balance",currentBalance-amount);
			query.setParameter("fk_idCLI",1);
			query.executeUpdate();
			t1.commit();
					
//			Operation op = new Operation();
//			op.setAmount(amount);
//			op.setOperationDate(date);
//			op.setOperationName("W");
//			op.setBalance(currentBalance-amount);
//			Client c = new Client();
//			c.setIdClient(2);
//			op.setClient(c);
//			session.persist(op);
//			t1.commit();

		} finally {
			factory.close();
		}
		
	}
	
	
	/**
	 * @return the current balance
	 */
	public int getBalance() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Operation.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			Query subQuery = session.createQuery("select balance from Operation order by id_op desc");
			subQuery.setMaxResults(1);
			return (Integer) subQuery.getSingleResult();

		} finally {
			factory.close();
		}
		
	}

}
