package infra;

import java.util.ArrayList;

import org.junit.Test;

import com.sg.kataapi.dto.ClientBean;
import com.sg.kataapi.dto.OperationBean;
import com.sg.kataapi.interfaces.IRepository;
import com.sg.katainfra.repository.ImplRepository;

public class Testing {


//	@Test
	public void testGetOperations(){
		
		IRepository ir = new ImplRepository();
		
		ArrayList<OperationBean> ob = ir.getOperations();
		
		for(OperationBean o : ob){
			System.out.println(o.getIdOperation());
			System.out.println(o.getOperationName());
			System.out.println(o.getOperationDate());
			System.out.println(o.getAmount());
			System.out.println(o.getBalance());
			System.out.println(o.getClient().toString());
		}
	}
	
//	@Test
	public void testGetClient(){
		
		IRepository ir = new ImplRepository();
		
		ClientBean cb = ir.getClient("thibaud", "1122");
		System.out.println(cb.toString());
		
		
	}
	
//	@Test
	public void testDeposit(){
		IRepository ir = new ImplRepository();
		ir.persistDeposit(350);
	}
	
	@Test
	public void testWithdraw(){
		IRepository ir = new ImplRepository();
		ir.persistWithdraw(350);
	}
	
	@Test
	public void testGetBalance(){
		IRepository ir = new ImplRepository();
		System.out.println(ir.getBalance());
	}
}
