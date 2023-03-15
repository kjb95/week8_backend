package backend.week8.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping(value = {"/", "/api/jwt", "/api/member/*", "/api/item/search", "/api/agroup", "/api/ad"})
	public String forward() {
		return "forward:/index.html";
	}
}
