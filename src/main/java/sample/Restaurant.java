package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Restaurant {
	
	private Chef chef;
	
	public Restaurant(Chef chef) {
		this.chef = chef;
	}
	
//	@Autowired
//	public void setChef(Chef chef) {
//		this.chef = chef;
//	}
	
	public void printChef() {
		System.out.println("주방장 이름 : " + chef.getName());
	}
	
}
