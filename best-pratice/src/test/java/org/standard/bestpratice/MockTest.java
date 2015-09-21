package org.standard.bestpratice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@RunWith(JMock.class)
public class MockTest {
	
//	JUnit4Mockery context = new JUnit4Mockery() {
//        {
//            setImposteriser(ClassImposteriser.INSTANCE);
//        }
//    };
 
    //private static final Logger LOG = context.mock(Logger.class);
    private static final Logger LOG = LoggerFactory.getLogger(MockTest.class);
 
    @Test
    public void tryToUnderstandJMock() {
 
//        context.checking(new Expectations() {
// 
//            {
//                allowing(logger).debug(with(any(String.class)));
//                allowing(logger).info(with(any(String.class)));
//            }
//        });
        
    	LOG.debug("getWholeDocument got called");
        
    	//LOG.info("wasaaaaa!!!!");
        
    }
	
}
