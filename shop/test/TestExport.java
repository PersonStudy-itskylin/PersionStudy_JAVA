import java.util.concurrent.TimeUnit;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.qsh.shopping.util.ordercode.FileEveryDaySerialNumber;
import com.qsh.shopping.util.ordercode.QshSerialNumber;


public class TestExport {
	
	@Test
	public void exportTable(){
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		SchemaExport export = new SchemaExport(cfg);
		export.create(true, true);
	}
	
	@Test
	public void testNumber(){
		QshSerialNumber serial = new FileEveryDaySerialNumber(5, "EveryDaySerialNumber.dat");
		for(int i=0;i<5;i++){
			System.out.println(serial.getSerialNumber());
		}

	}
}
