package test.database;
import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;
import main.database.InteractiveTableTuple;
import main.database.ReasonPair;
 
/**
 * 
 * @author Netanel Felcher
 *
 */
public class InteractiveTableTupleTest{
	
	@Test public void test0(){
		InteractiveTableTuple t=new InteractiveTableTuple();
		assertNull(t.getDate());
		assertNull(t.getName());
		assertNull(t.getRegularDate());
		assert t.getKeyWords().isEmpty();
		assert t.getReasons().isEmpty();
	}		
	@Test public void test1(){
		InteractiveTableTuple t=new InteractiveTableTuple("Justin Bieber", "12/02/2016", null);
		assertEquals(t.getDate(), "12/02/2016");
		assertEquals(t.getName(), "Justin Bieber");
		assertEquals((t.getRegularDate() + ""), "Fri Dec 02 00:00:00 IST 2016");
		assert t.getKeyWords().isEmpty();
	}		
	@Test public void test2(){
		InteractiveTableTuple t=new InteractiveTableTuple();
		t.setName("Justin Bieber");
		t.setDate( "12/02/2016");
		assertEquals(t.getDate(), "12/02/2016");
		assertEquals(t.getName(), "Justin Bieber");
		assertEquals((t.getRegularDate() + ""), "Fri Dec 02 00:00:00 IST 2016");
		assert t.getKeyWords().isEmpty();
		ReasonPair rp=new ReasonPair();
		rp.setProbability(0.4);
		rp.setReason("stubbing");
		LinkedList<ReasonPair> lst= new LinkedList<>();
		lst.add(rp);
		t.setReasons(lst);
		assertEquals(t.getReasons().get(0).getProbability(), 0.4, 0);
		assertEquals(t.getReasons().get(0).getReason(), "stubbing");
	}	
	@Test public void test3(){
		ReasonPair rp=new ReasonPair();
		rp.setProbability(0.4);
		rp.setReason("stubbing");
		LinkedList<ReasonPair> lst= new LinkedList<>();
		lst.add(rp);
		InteractiveTableTuple t=new InteractiveTableTuple("Justin Bieber", "12/02/2016", lst);
		assertEquals(t.getDate(), "12/02/2016");
		assertEquals(t.getName(), "Justin Bieber");
		assertEquals((t.getRegularDate() + ""), "Fri Dec 02 00:00:00 IST 2016");
		assert t.getKeyWords().isEmpty();
		assertEquals(t.getReasons().get(0).getProbability(), 0.4, 0);
		assertEquals(t.getReasons().get(0).getReason(), "stubbing");
		t.addKeyWord("stubbing");
		assertEquals(t.getKeyWords().get(0), "stubbing");
		t.addKeyWord("arrested");
		assertEquals(t.getKeyWords().get(1), "arrested");
	}		
}