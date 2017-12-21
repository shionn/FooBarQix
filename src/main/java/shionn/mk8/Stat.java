package shionn.mk8;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Stat {
	private List<String> names;
	private BigDecimal landSpeed, antiGravSpeed, waterSpeed, glidingSpeed;
	private BigDecimal acceleration;
	private BigDecimal weight;
	private BigDecimal landHandling, antiGravHandling, waterHandling, glidingHandling;
	private BigDecimal traction;
	private BigDecimal miniTurbo;

	public List<String> getNames() {
		return names;
	}

	public Stat names(List<String> names) {
		this.names = names;
		return this;
	}

	public BigDecimal getLandSpeed() {
		return landSpeed;
	}

	public BigDecimal getAntiGravSpeed() {
		return antiGravSpeed;
	}

	public BigDecimal getWaterSpeed() {
		return waterSpeed;
	}

	public BigDecimal getGlidingSpeed() {
		return glidingSpeed;
	}

	public Stat speed(BigDecimal land, BigDecimal antiGrav, BigDecimal water, BigDecimal gliding) {
		landSpeed = land;
		antiGravSpeed = antiGrav;
		waterSpeed = water;
		glidingSpeed = gliding;
		return this;
	}

	public BigDecimal getAcceleration() {
		return acceleration;
	}

	public Stat acceleration(BigDecimal acceleration) {
		this.acceleration = acceleration;
		return this;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public Stat weight(BigDecimal weight) {
		this.weight = weight;
		return this;
	}

	public BigDecimal getLandHandling() {
		return landHandling;
	}

	public BigDecimal getAntiGravHandling() {
		return antiGravHandling;
	}

	public BigDecimal getWaterHandling() {
		return waterHandling;
	}

	public BigDecimal getGlidingHandling() {
		return glidingHandling;
	}

	public BigDecimal getTraction() {
		return traction;
	}

	public Stat handling(BigDecimal land, BigDecimal antiGrav, BigDecimal water,
			BigDecimal gliding) {
		landHandling = land;
		antiGravHandling = antiGrav;
		waterHandling = water;
		glidingHandling = gliding;
		return this;
	}

	public Stat traction(BigDecimal traction) {
		this.traction = traction;
		return this;
	}

	public BigDecimal getMiniTurbo() {
		return miniTurbo;
	}

	public Stat miniTurbo(BigDecimal miniTurbo) {
		this.miniTurbo = miniTurbo;
		return this;
	}

	public String getId() {
		return getIds().stream().sorted().findFirst().orElseThrow(() -> {
			throw new IllegalStateException();
		});
	}

	public List<String> getIds() {
		return getNames().stream().map(String::toLowerCase).map(s -> s.replaceAll("[^a-z]", "-"))
				.sorted().collect(Collectors.toList());
	}

}
