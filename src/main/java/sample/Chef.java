package sample;

import org.springframework.stereotype.Component;

@Component
public class Chef {
	
	private String name = "홍길동";

	public String getName() {
		return name;
	}

}
