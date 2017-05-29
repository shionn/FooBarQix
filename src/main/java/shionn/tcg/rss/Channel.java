package shionn.tcg.rss;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Code sous licence GPLv3 (http://www.gnu.org/licenses/gpl.html)
 *
 * @author <b>Shionn</b>, shionn@gmail.com <i>http://shionn.org</i><br>
 *         GCS d- s+:+ a+ C++ UL/M P L+ E--- W++ N K- w-- M+ t+ 5 X R+ !tv b+ D+ G- e+++ h+ r- y+
 */
public class Channel {

	private String title;
	private String link;
	private String description;
	private List<Item> items;
	private String language;
	private String updatePeriod = "hourly";
	private int updateFrequency = 1;

	@XmlElement(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "link")
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "item")
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@XmlElement(name = "language")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@XmlElement(name = "updatePeriod", namespace = NameSpaces.SY)
	public String getUpdatePeriod() {
		return updatePeriod;
	}

	@XmlElement(name = "updateFrequency", namespace = NameSpaces.SY)
	public int getUpdateFrequency() {
		return updateFrequency;
	}
}
