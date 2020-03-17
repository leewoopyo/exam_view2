package com.exam.view2;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.view2.domain.ExamRIO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	//프로젝트 실행시 해당 컨트롤러 메소드로 이동한다. 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		//바로 home.jsp로 이동한다.
		return "home";
	}
	
	//url에서 경로가 설정될 때 "get1 + 파라메터 값"이 나오면 해당 경로로 들어오면서 파라메터 값을 가져온다
	//파라메터를 메소드의 매개변수 처럼 받는다.(방식1)
	@RequestMapping(value = "/get1", method = RequestMethod.GET)
	public String get1(Model model,String id,String pass ) {
		logger.info("get1.jsp start["+id+" : "+pass+"]");
		
		//id와 pass라는 명칭으로 모델에 값을 담는다.
		model.addAttribute("id",id);
		model.addAttribute("pass",pass);
		
		//get1.jsp로 라우팅 한다.
		//라우팅 : 목적지 설정이란 의미로 쓰면 됨
		return "get1";
		
	}
	
	//url에서 경로가 설정될 때 "get2/id파라메터 값/pass파라메타 값"이 나오면 파마메터 값을 갖고 해당 경로로 들어온다
	//그리고 PathVariable 어노테이션으로 파라메터 값을 인식한다. (방식2)
	@RequestMapping(value = "/get2/{id}/{pass}", method = RequestMethod.GET)
	public String get2(@PathVariable("id") String id,@PathVariable("pass") String pass,Model model) {
		logger.info("get2.jsp start["+id+" : "+pass+"]");
		
		//id와 pass라는 명칭으로 모델에 값을 담는다.
		model.addAttribute("id",id);
		model.addAttribute("pass",pass);
		
		//get2.jsp로 라우팅 한다.
		return "get2";
	}
	
	//url에서 경로가 설정될 때 "post1"이 나오면 해당 경로로 들어온다
	//form 형태로 파라메터 값이 들어온다.
	//모든 파라메터 값을 매개변수 형식으로 받는다.
	@RequestMapping(value = "/post1", method = RequestMethod.POST)
	public String post1(Model model,String name,String studentid,String kor,String eng,String mat) throws UnsupportedEncodingException {
		logger.info("post1.jsp start["+name+" : "+studentid+" : "+kor+" : "+eng+" : "+mat+"]");
		
		//이름은 한글이기 때문에 한글처리 해준다.
		//name = new String(name.getBytes("8859_1"),"utf-8");
		
		//각 요소들의 이름과 값을 정해서 model에 넣는다.
		model.addAttribute("name",name);		//이름
		model.addAttribute("studentid",studentid);	//학번
		model.addAttribute("kor",kor);	//국어
		model.addAttribute("eng",eng);	//영어
		model.addAttribute("mat",mat);	//수학
	
		//post1.jsp로 라우팅 한다.
		return "post1";
	}
	
	//url에서 경로가 설정될 때 "post2"이 나오면 해당 경로로 들어온다
	//파라메터 값을 보내는건 같은데, 위와 다르게 클래스 형태로 값을 받는다.
	//이름이 맞으면 매칭이 되어서 인식이 되고 해당 객체 통으로 값을 넘길 수 있다.
	@RequestMapping(value = "/post2", method = RequestMethod.POST)
	public String post2(Model model,ExamRIO exam) throws UnsupportedEncodingException {
		logger.info("post2.jsp start["+exam.getName()+" : "+exam.getStudentid()+" : "+exam.getKor()+" : "+exam.getEng()+" : "+exam.getMat()+"]");
		
		//이름은 한글이기 때문에 한글처리 해준다.
		//exam.setName(new String(exam.getName().getBytes("8859_1"),"utf-8"));
		
		//각 요소들의 이름과 값을 정해서 model에 넣는다.
		model.addAttribute("exam",exam);
		
		//post2.jsp로 라우팅 한다.
		return "post2";
	}
	
}
