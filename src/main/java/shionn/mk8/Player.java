package shionn.mk8;

import java.math.BigDecimal;

public class Player {

	private Stat driver;
	private Stat kart;
	private Stat tire;
	private Stat wing;

	public Stat getDriver() {
		return driver;
	}

	public void setDriver(Stat driver) {
		this.driver = driver;
	}

	public Stat getKart() {
		return kart;
	}

	public void setKart(Stat kart) {
		this.kart = kart;
	}

	public Stat getTire() {
		return tire;
	}

	public void setTire(Stat tire) {
		this.tire = tire;
	}

	public Stat getWing() {
		return wing;
	}

	public void setWing(Stat wing) {
		this.wing = wing;
	}

	public BigDecimal getLandSpeed() {
		return driver.getLandSpeed().add(kart.getLandSpeed()).add(tire.getLandSpeed())
				.add(wing.getLandSpeed());
	}

	public BigDecimal getAntiGravSpeed() {
		return driver.getAntiGravSpeed().add(kart.getAntiGravSpeed()).add(tire.getAntiGravSpeed())
				.add(wing.getAntiGravSpeed());
	}

	public BigDecimal getWaterSpeed() {
		return driver.getWaterSpeed().add(kart.getWaterSpeed()).add(tire.getWaterSpeed())
				.add(wing.getWaterSpeed());
	}

	public BigDecimal getGlidingSpeed() {
		return driver.getGlidingSpeed().add(kart.getGlidingSpeed()).add(tire.getGlidingSpeed())
				.add(wing.getGlidingSpeed());
	}

	public BigDecimal getAcceleration() {
		return driver.getAcceleration().add(kart.getAcceleration()).add(tire.getAcceleration())
				.add(wing.getAcceleration());
	}

	public BigDecimal getWeight() {
		return driver.getWeight().add(kart.getWeight()).add(tire.getWeight()).add(wing.getWeight());
	}

	public BigDecimal getLandHandling() {
		return driver.getLandHandling().add(kart.getLandHandling()).add(tire.getLandHandling())
				.add(wing.getLandHandling());
	}

	public BigDecimal getAntiGravHandling() {
		return driver.getAntiGravHandling().add(kart.getAntiGravHandling())
				.add(tire.getAntiGravHandling()).add(wing.getAntiGravHandling());
	}

	public BigDecimal getWaterHandling() {
		return driver.getWaterHandling().add(kart.getWaterHandling()).add(tire.getWaterHandling())
				.add(wing.getWaterHandling());
	}

	public BigDecimal getGlidingHandling() {
		return driver.getGlidingHandling().add(kart.getGlidingHandling())
				.add(tire.getGlidingHandling()).add(wing.getGlidingHandling());
	}

	public BigDecimal getTraction() {
		return driver.getTraction().add(kart.getTraction()).add(tire.getTraction())
				.add(wing.getTraction());
	}

	public BigDecimal getMiniTurbo() {
		return driver.getMiniTurbo().add(kart.getMiniTurbo()).add(tire.getMiniTurbo())
				.add(wing.getMiniTurbo());
	}

}
