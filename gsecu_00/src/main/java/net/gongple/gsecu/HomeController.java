package net.gongple.gsecu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/admin/h", method=RequestMethod.GET)
	public String highAdmin(Model model) {
		model.addAttribute("msg", "최고");
		return "admin/high_admin";
	}

	@RequestMapping(value="/admin/m", method=RequestMethod.GET)
	public String middleAdmin(Model model) {
		model.addAttribute("msg", "중간");
		return "admin/low_admin";
	}

	@RequestMapping(value="/admin/l", method=RequestMethod.GET)
	public String lowAdmin(Model model) {
		model.addAttribute("msg", "실무");
		return "admin/middle_admin";
	}
	
	@RequestMapping(value="/user/in", method=RequestMethod.GET)
	public String in(Model model) {
		model.addAttribute("msg", "IN");
		return "in";
	}
	
	@RequestMapping(value="/user/out", method=RequestMethod.GET)
	public String out(Model model) {
		model.addAttribute("msg", "OUT");
		return "out";
	}

}