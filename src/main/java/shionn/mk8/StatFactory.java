package shionn.mk8;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
public class StatFactory {

	@Autowired
	@Value("${mk8.driver.name}")
	private String[] driverName;

	@Autowired
	@Value("${mk8.driver.speed.land}")
	private String[] driverSpeedLand;
	@Autowired
	@Value("${mk8.driver.speed.antig}")
	private String[] driverSpeedAntiG;
	@Autowired
	@Value("${mk8.driver.speed.water}")
	private String[] driverSpeedWater;
	@Autowired
	@Value("${mk8.driver.speed.gliding}")
	private String[] driverSpeedGliding;

	@Autowired
	@Value("${mk8.driver.accel}")
	private String[] driverAccel;
	@Autowired
	@Value("${mk8.driver.weight}")
	private String[] driverWeight;

	@Autowired
	@Value("${mk8.driver.handling.land}")
	private String[] driverHandlingLand;
	@Autowired
	@Value("${mk8.driver.handling.antig}")
	private String[] driverHandlingAntiG;
	@Autowired
	@Value("${mk8.driver.handling.water}")
	private String[] driverHandlingWater;
	@Autowired
	@Value("${mk8.driver.handling.gliding}")
	private String[] driverHandlingGliding;

	@Autowired
	@Value("${mk8.driver.traction}")
	private String[] driverTraction;
	@Autowired
	@Value("${mk8.driver.turbo}")
	private String[] driverTurbo;

	@Bean(name = "drivers")
	@ApplicationScope
	private Stats drivers() {
		Stats stats = new Stats();
		for (int i = 0; i < driverName.length; i++) {
			Stat stat = new Stat();
			stat.names(Arrays.asList(driverName[i].split("=")))
					.speed(new BigDecimal(driverSpeedLand[i]), new BigDecimal(driverSpeedAntiG[i]),
							new BigDecimal(driverSpeedWater[i]),
							new BigDecimal(driverSpeedGliding[i]))
					.acceleration(new BigDecimal(driverAccel[i]))
					.weight(new BigDecimal(driverWeight[i]))
					.handling(new BigDecimal(driverHandlingLand[i]),
							new BigDecimal(driverHandlingAntiG[i]),
							new BigDecimal(driverHandlingWater[i]),
							new BigDecimal(driverHandlingGliding[i]))
					.traction(new BigDecimal(driverTraction[i]))
					.miniTurbo(new BigDecimal(driverTurbo[i]));
			stats.add(stat);
		}
		return stats;
	}

	@Autowired
	@Value("${mk8.kart.name}")
	private String[] kartName;

	@Autowired
	@Value("${mk8.kart.speed.land}")
	private String[] kartSpeedLand;
	@Autowired
	@Value("${mk8.kart.speed.antig}")
	private String[] kartSpeedAntiG;
	@Autowired
	@Value("${mk8.kart.speed.water}")
	private String[] kartSpeedWater;
	@Autowired
	@Value("${mk8.kart.speed.gliding}")
	private String[] kartSpeedGliding;

	@Autowired
	@Value("${mk8.kart.accel}")
	private String[] kartAccel;
	@Autowired
	@Value("${mk8.kart.weight}")
	private String[] kartWeight;

	@Autowired
	@Value("${mk8.kart.handling.land}")
	private String[] kartHandlingLand;
	@Autowired
	@Value("${mk8.kart.handling.antig}")
	private String[] kartHandlingAntiG;
	@Autowired
	@Value("${mk8.kart.handling.water}")
	private String[] kartHandlingWater;
	@Autowired
	@Value("${mk8.kart.handling.gliding}")
	private String[] kartHandlingGliding;

	@Autowired
	@Value("${mk8.kart.traction}")
	private String[] kartTraction;
	@Autowired
	@Value("${mk8.kart.turbo}")
	private String[] kartTurbo;

	@Bean(name = "karts")
	@ApplicationScope
	private Stats karts() {
		Stats stats = new Stats();
		for (int i = 0; i < kartName.length; i++) {
			Stat stat = new Stat();
			stat.names(Arrays.asList(kartName[i].split("=")))
					.speed(new BigDecimal(kartSpeedLand[i]), new BigDecimal(kartSpeedAntiG[i]),
							new BigDecimal(kartSpeedWater[i]), new BigDecimal(kartSpeedGliding[i]))
					.acceleration(new BigDecimal(kartAccel[i]))
					.weight(new BigDecimal(kartWeight[i]))
					.handling(new BigDecimal(kartHandlingLand[i]),
							new BigDecimal(kartHandlingAntiG[i]),
							new BigDecimal(kartHandlingWater[i]),
							new BigDecimal(kartHandlingGliding[i]))
					.traction(new BigDecimal(kartTraction[i]))
					.miniTurbo(new BigDecimal(kartTurbo[i]));
			stats.add(stat);
		}
		return stats;
	}

	@Autowired
	@Value("${mk8.tire.name}")
	private String[] tireName;

	@Autowired
	@Value("${mk8.tire.speed.land}")
	private String[] tireSpeedLand;
	@Autowired
	@Value("${mk8.tire.speed.antig}")
	private String[] tireSpeedAntiG;
	@Autowired
	@Value("${mk8.tire.speed.water}")
	private String[] tireSpeedWater;
	@Autowired
	@Value("${mk8.tire.speed.gliding}")
	private String[] tireSpeedGliding;

	@Autowired
	@Value("${mk8.tire.accel}")
	private String[] tireAccel;
	@Autowired
	@Value("${mk8.tire.weight}")
	private String[] tireWeight;

	@Autowired
	@Value("${mk8.tire.handling.land}")
	private String[] tireHandlingLand;
	@Autowired
	@Value("${mk8.tire.handling.antig}")
	private String[] tireHandlingAntiG;
	@Autowired
	@Value("${mk8.tire.handling.water}")
	private String[] tireHandlingWater;
	@Autowired
	@Value("${mk8.tire.handling.gliding}")
	private String[] tireHandlingGliding;

	@Autowired
	@Value("${mk8.tire.traction}")
	private String[] tireTraction;
	@Autowired
	@Value("${mk8.tire.turbo}")
	private String[] tireTurbo;

	@Bean(name = "tires")
	@ApplicationScope
	private Stats tires() {
		Stats stats = new Stats();
		for (int i = 0; i < tireName.length; i++) {
			Stat stat = new Stat();
			stat.names(Arrays.asList(tireName[i].split("=")))
					.speed(new BigDecimal(tireSpeedLand[i]), new BigDecimal(tireSpeedAntiG[i]),
							new BigDecimal(tireSpeedWater[i]), new BigDecimal(tireSpeedGliding[i]))
					.acceleration(new BigDecimal(tireAccel[i]))
					.weight(new BigDecimal(tireWeight[i]))
					.handling(new BigDecimal(tireHandlingLand[i]),
							new BigDecimal(tireHandlingAntiG[i]),
							new BigDecimal(tireHandlingWater[i]),
							new BigDecimal(tireHandlingGliding[i]))
					.traction(new BigDecimal(tireTraction[i]))
					.miniTurbo(new BigDecimal(tireTurbo[i]));
			stats.add(stat);
		}
		return stats;
	}

	@Autowired
	@Value("${mk8.wing.name}")
	private String[] wingName;

	@Autowired
	@Value("${mk8.wing.speed.land}")
	private String[] wingSpeedLand;
	@Autowired
	@Value("${mk8.wing.speed.antig}")
	private String[] wingSpeedAntiG;
	@Autowired
	@Value("${mk8.wing.speed.water}")
	private String[] wingSpeedWater;
	@Autowired
	@Value("${mk8.wing.speed.gliding}")
	private String[] wingSpeedGliding;

	@Autowired
	@Value("${mk8.wing.accel}")
	private String[] wingAccel;
	@Autowired
	@Value("${mk8.wing.weight}")
	private String[] wingWeight;

	@Autowired
	@Value("${mk8.wing.handling.land}")
	private String[] wingHandlingLand;
	@Autowired
	@Value("${mk8.wing.handling.antig}")
	private String[] wingHandlingAntiG;
	@Autowired
	@Value("${mk8.wing.handling.water}")
	private String[] wingHandlingWater;
	@Autowired
	@Value("${mk8.wing.handling.gliding}")
	private String[] wingHandlingGliding;

	@Autowired
	@Value("${mk8.wing.traction}")
	private String[] wingTraction;
	@Autowired
	@Value("${mk8.wing.turbo}")
	private String[] wingTurbo;

	@Bean(name = "wings")
	@ApplicationScope
	private Stats wings() {
		Stats stats = new Stats();
		for (int i = 0; i < wingName.length; i++) {
			Stat stat = new Stat();
			stat.names(Arrays.asList(wingName[i].split("=")))
					.speed(new BigDecimal(wingSpeedLand[i]), new BigDecimal(wingSpeedAntiG[i]),
							new BigDecimal(wingSpeedWater[i]), new BigDecimal(wingSpeedGliding[i]))
					.acceleration(new BigDecimal(wingAccel[i]))
					.weight(new BigDecimal(wingWeight[i]))
					.handling(new BigDecimal(wingHandlingLand[i]),
							new BigDecimal(wingHandlingAntiG[i]),
							new BigDecimal(wingHandlingWater[i]),
							new BigDecimal(wingHandlingGliding[i]))
					.traction(new BigDecimal(wingTraction[i]))
					.miniTurbo(new BigDecimal(wingTurbo[i]));
			stats.add(stat);
		}
		return stats;
	}

}
