package shionn.mk8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionScope
public class Mk8Controller {

	@Autowired
	@Qualifier("drivers")
	private Stats drivers;

	@Autowired
	@Qualifier("karts")
	private Stats karts;

	@Autowired
	@Qualifier("tires")
	private Stats tires;

	@Autowired
	@Qualifier("wings")
	private Stats wings;

	@Autowired
	private Player player1;
	@Autowired
	private Player player2;

	@RequestMapping(path = "/mk8", method = RequestMethod.GET)
	public ModelAndView mk8() {
		return new ModelAndView("mk8").addObject("drivers", drivers).addObject("karts", karts)
				.addObject("tires", tires).addObject("wings", wings).addObject("player1", player1)
				.addObject("player2", player2);
	}

	@RequestMapping(path = "/mk8", method = RequestMethod.POST)
	public String post(@RequestParam("driver1") String driver1,
			@RequestParam("driver2") String driver2) {
		player1.setDriver(drivers.get(driver1));
		player2.setDriver(drivers.get(driver2));

		return "redirect:/mk8";
	}

}
