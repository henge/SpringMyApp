package jp.springbook.springmyapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAppController {

	@RequestMapping(value = "/helo", method = RequestMethod.GET)
	public ModelAndView helo() {

		ModelAndView modelAndView = new ModelAndView("showMessage");
		modelAndView.addObject("title", "ModelAndView Sample");
		modelAndView.addObject("message", "ModelAndViewのテストです。");
//		modelAndView.addObject("checkItems", getList());
		modelAndView.addObject("checkItems", getDataList());
		
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
//		modelAndView.addObject("checkItems", getList());
		modelAndView.addObject("checkItems", getDataList());
		modelAndView.addObject("checks", model.getChecks());
		
//		modelAndView.addObject("formModel", new FormModel());
//		modelAndView.setViewName("showMessage");
		return modelAndView;
	}
	
	private List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("MAC OS X");
		list.add("Windows");
		list.add("Linux");
		return list;
	}
	
	private List<ListDataModel> getDataList() {
		List<ListDataModel> list = (List<ListDataModel>)new ArrayList<ListDataModel>();
		list.add(new ListDataModel("One", "1"));
		list.add(new ListDataModel("Two", "2"));
		list.add(new ListDataModel("Three", "3"));
		list.add(new ListDataModel("Four", "4"));
		return list;
	}
	
}
