package shionn.tcg.pojo;

import java.util.Date;

public class Tournament {


	private Date date;
	private String description;
	private String price;
	private String title;
	private String format;

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormat() {
		return format;
	}
}
