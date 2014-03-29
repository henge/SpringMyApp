package jp.springbook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAppController {

	@RequestMapping(value = "/helo", method = RequestMethod.GET)
	public String helo(Model model) {
		FormModel fm = new FormModel();
		fm.setInput1("ここに書く");
		model.addAttribute("formModel", fm);
		model.addAttribute("message", "何か書いてください。");
		return "showMessage";
	}
	
	@RequestMapping(value = "/helo", method = RequestMethod.POST)
	public String form(@ModelAttribute FormModel fm, Model model) {
		model.addAttribute("message", "you typed: " + fm.getInput1());
		return "showMessage";
	}
}
