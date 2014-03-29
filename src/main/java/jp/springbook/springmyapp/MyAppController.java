package jp.springbook.springmyapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	private List<ValidModel> buylist = new ArrayList<ValidModel>();
	
	@RequestMapping(value = "/val", method = RequestMethod.GET)
	public String val(Model model) {
		ValidModel validModel = new ValidModel();
		model.addAttribute("validModel", validModel);
		model.addAttribute("buylist", buylist);
		
		return "validation";
	}
	
	@RequestMapping(value = "/val", method = RequestMethod.POST)
	public String valPost(@Valid @ModelAttribute ValidModel validModel, BindingResult result, Model model) {
		if (result.hasErrors()) {
//			model.addAttribute("vModel", vModel);
		} else {
			
			//		modelAndView.addObject("vModel", vModel);
			validModel.setBuydate(new Date());
			buylist.add(validModel);
			model.addAttribute("validModel", new ValidModel());
		}
		model.addAttribute("buylist", buylist);
		return "validation";
	}
}
