package jp.springbook.springmyapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyAppController {

	@RequestMapping(value = "/helo", method = RequestMethod.GET)
	public String helo(Model model) {
		model.addAttribute("message", "this is sample. ok?");
		return "showMessage";
	}
}
