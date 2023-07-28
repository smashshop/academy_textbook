package sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@Log4j
public class sampleTests {
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant;
	
	
//	public void setRestaurant(Restaurant restaurant) {
//		this.restaurant = restaurant;
//	}
	
	@Test
	public void testEx() {
		//assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("------------------------------------------");
		log.info(restaurant.getChef());
		log.info(restaurant.toString());
		
		restaurant.printChef();
	}
	
}
