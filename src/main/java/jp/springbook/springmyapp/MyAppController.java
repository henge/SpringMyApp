package jp.springbook.springmyapp;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAppController {

	@RequestMapping(value = "/helo", method = RequestMethod.GET)
	public ModelAndView helo() {

		ModelAndView modelAndView = new ModelAndView("showMessage");
		modelAndView.addObject("title", "ModelAndView Sample");
		modelAndView.addObject("message", "ModelAndViewのテストです。");
		
		FormModel model = new FormModel();
		model.setInput1("ここに書く");
		modelAndView.addObject("formModel", model);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/helo", method = RequestMethod.POST)
	public ModelAndView form(@ModelAttribute FormModel model) {
		ModelAndView modelAndView = new ModelAndView("showMessage");
		modelAndView.addObject("title", "ModelAndView Sample");
		modelAndView.addObject("message", "you typed: " + model.getInput1());
		modelAndView.addObject("formModel", model);
//		modelAndView.addObject("formModel", new FormModel());
//		modelAndView.setViewName("showMessage");
		return modelAndView;
	}
	
}
