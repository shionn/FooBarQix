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
	@Qualifier("player1")
	private Player player1;
	@Autowired
	@Qualifier("player2")
	private Player player2;

	@RequestMapping(path = "/mk8", method = RequestMethod.GET)
	public ModelAndView mk8() {
		return new ModelAndView("mk8").addObject("drivers", drivers).addObject("karts", karts)
				.addObject("tires", tires).addObject("wings", wings).addObject("player1", player1)
				.addObject("player2", player2);
	}

	@RequestMapping(path = "/mk8", method = RequestMethod.POST)
	public String post(@RequestParam("driver1") String driver1,
			@RequestParam("driver2") String driver2, @RequestParam("kart1") String kart1,
			@RequestParam("kart2") String kart2, @RequestParam("tire1") String tire1,
			@RequestParam("tire2") String tire2, @RequestParam("wing1") String wing1,
			@RequestParam("wing2") String wing2) {
		player1.setDriver(drivers.get(driver1));
		player2.setDriver(drivers.get(driver2));
		player1.setKart(karts.get(kart1));
		player2.setKart(karts.get(kart2));
		player1.setTire(tires.get(tire1));
		player2.setTire(tires.get(tire2));
		player1.setWing(wings.get(wing1));
		player2.setWing(wings.get(wing2));
		return "redirect:/mk8";
	}

}
