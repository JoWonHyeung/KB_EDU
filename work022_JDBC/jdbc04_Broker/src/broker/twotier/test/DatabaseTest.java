package broker.twotier.test;

import broker.twotier.dao.Database;
import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.exception.RecordNotFoundException;
import broker.twotier.vo.CustomerRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		
//		try {
//			db.addCustomer(new CustomerRec("777-777","HaBaRee","다산동"));
//		}catch(DuplicateSSNException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		try {
//			db.deleteCustomer("777-777");
//		}catch (RecordNotFoundException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		//db.updateCustomer(new CustomerRec("777-777","A","B"));
		
		
	}

}
