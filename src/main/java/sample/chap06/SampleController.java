package sample.chap06;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sample.domain.SampleDTO;
import sample.domain.SampleDTOList;
import sample.domain.TodoDTO;

@Controller
@RequestMapping("/sample/*")
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		System.out.println("SampleContorller의 basic() 메소드 호출됨");
	}
	
	@RequestMapping("/1")
	public void basic1() {
		System.out.println("SampleContorller의 basic1111111() 메소드 호출됨");
	}
	
	@RequestMapping("/2")
	public void basic2() {
		System.out.println("SampleContorller의 basic22222222() 메소드 호출됨");
	}
	
	@RequestMapping(value = "/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basic3() {
		System.out.println("SampleContorller의 basic3() 메소드 호출됨");
	}
	
	@GetMapping("/basicOnlyGet")
	public void basicGet() {
		System.out.println("SampleContolller의 basicGet() 메소드 호출됨");
	}
	
	@PostMapping("/basicOnlyGet")
	public void basicPost() {
		System.out.println("SampleContolller의 basicPost() 메소드 호출됨");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		System.out.println("================" + dto);
		return "sample/Ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String myName, @RequestParam("age") String myAge) {
		System.out.println("myName : " + myName);
		System.out.println("myAge : " + myAge);
		return "sample/Ex02"; //기본타입은 JSP로 전달되지않음
	}
	
	@GetMapping("/ex03List")
	public String ex03List(@RequestParam("ids") ArrayList<String> ids) {
		System.out.println("ids로 전달된 값들이 저장된 ArrayList : " + ids);
		return "sample/Ex03List"; //JSP로 전달이되지않음
	}
	
	@GetMapping("/ex03Array")
	public String ex03Array(@RequestParam("ids") String[] ids) {
		System.out.println("ids로 전달된 값들이 저장된 Array : " + Arrays.toString(ids));
		return "sample/Ex03Array";
	}
	
	@GetMapping("/ex03SampleDTOList")
	public String ex03SampleDTOList(SampleDTOList sampleList) {
		System.out.println("sampleList로 전달된 값들이 저장된 List : " + sampleList);
		return "sample/Ex03SampleDTOList";
	}
	//localhost:8080/pro00/sample/ex03SampleDTOList?sampleList%5B0%5D.name=aaaa&sampleList%5B0%5D.age=44&sampleList%5B1%5D.name=nnnn&sampleList%5B1%5D.age=55
	
	
	@GetMapping("/ex04Todo")
	public String ex04(TodoDTO todo) {
		System.out.println("전달된 값들 : " + todo);
		return "sample/Ex04Todo";
	}
	//localhost:8080/pro00/sample/ex04Todo?title=김상원&dueDate=2022-05-25 14:33:44
	
	@GetMapping("/ex05")
	public String ex05(SampleDTO dto, int page) {
	//public String ex05(SampleDTO dto, Integer page) {
	//public String ex05(SampleDTO dto, String[] page) {
		System.out.println("전달된 dto : " + dto);
		System.out.println("전달된 page : " + page); // JSP로는 전달되지 않음
		//System.out.println("전달된 page[0] " + page[0]);
		return "sample/Ex05";
	}
	//localhost:8080/pro00/sample/ex05?name=김상원&age=24&page=9
	
	
	
	
	@GetMapping("/ex06")
	public String ex06(@ModelAttribute("name") String name, 
					   @ModelAttribute("age") int age) {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		return "sample/Ex06";
	}
	
	@GetMapping("/ex07")
	public String ex07() {
		return "redirect:/sample/Ex06?name=김상원&age=44";
	}
	@GetMapping("/ex077")
	public String ex07(RedirectAttributes rttr) {
		rttr.addAttribute("name", "김상원");
		rttr.addAttribute("age", 25);
		return "redirect:/sample/Ex06";
	}
	
	@GetMapping("/ex08")
	public @ResponseBody SampleDTO ex8() {
		System.out.println("ex08==============================");
		SampleDTO dto = new SampleDTO();
		dto.setAge(24);
		dto.setName("김상원");
		return dto;
	}
	@GetMapping("/ex088")
	public String ex88(Model model) {
		System.out.println("ex088==============================");
		SampleDTO dto = new SampleDTO();
		dto.setAge(24);
		dto.setName("김상원");
		model.addAttribute("dto", dto);
		return "sample2/Ex08";
	}
	
	@GetMapping("/ex09")
	public ResponseEntity<String> ex09(){
		
		String msg = "{'name' : '김상원', 'age' : 24}";
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content-type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<String>(msg, httpHeaders, HttpStatus.OK);
	}
	
}
