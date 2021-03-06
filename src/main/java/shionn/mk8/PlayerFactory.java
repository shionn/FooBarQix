package shionn.mk8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
public class PlayerFactory {

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

	@Bean(name = { "player1" })
	@SessionScope
	public Player player1() {
		return build();
	}

	@Bean(name = { "player2" })
	@SessionScope
	public Player player2() {
		return build();
	}

	private Player build() {
		Player player = new Player();
		player.setDriver(drivers.get("mario"));
		player.setKart(karts.get("standard-kart"));
		player.setTire(tires.get("standard"));
		player.setWing(wings.get("super-glider"));
		return player;
	}

}
