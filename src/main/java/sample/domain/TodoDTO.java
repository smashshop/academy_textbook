package sample.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //java.sql.date는 처리하지 못한다
	private Date dueDate;
	
	
}
