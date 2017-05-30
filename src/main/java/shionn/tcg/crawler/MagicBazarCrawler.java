package shionn.tcg.crawler;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import shionn.tcg.pojo.Tournament;

public class MagicBazarCrawler {
	private static final Locale LOCALE = Locale.FRANCE;
	private static final SimpleDateFormat MB_DATE_FORMAT = new SimpleDateFormat("EEE dd MMM", LOCALE);

	public List<Tournament> crawl() throws IOException, ParseException {
		Document doc = Jsoup.connect("https://www.magicbazar.fr/tournament/boutique-annecy")
				.header("referer", "https://www.magicbazar.fr").header("accept", MediaType.TEXT_HTML)
				.header("user-agent", "Mozilla/5.0").get();
		List<Tournament> tournaments = new ArrayList<>();
		for (Element row : doc.select("div.present_tournoi")) {
			Date date = findDate(row);
			if (date.before(nextHeightDay())) {
				for (Element e : row.select("div.contain_tournoi")) {
					if (!isIgnored(e)) {
						tournaments.add(build(date, e));
					}
				}
			}
		}
		return tournaments;
	}

	private Tournament build(Date date, Element e) {
		Tournament item = new Tournament();
		item.setDate(addHours(date, e));
		item.setDescription(e.select("div").last().text());
		item.setPrice(e.select("div div").get(2).text());
		item.setTitle(e.select("div div").get(3).text());
		item.setFormat(e.select("div div").get(4).text());
		return item;
	}

	private Date addHours(Date date, Element e) {
		try {
			String[] time = e.select("div div div span").text().split(":");
			Calendar calendar = Calendar.getInstance(LOCALE);
			calendar.setTime(date);
			calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
			calendar.set(Calendar.MINUTE, Integer.parseInt(time[1]));
			return calendar.getTime();
		} catch (RuntimeException ex) {
			return date;
		}
	}

	private boolean isIgnored(Element e) {
		return e.text().contains("Yu-Gi-Oh") || e.text().contains("Final Fantasy");
	}

	private Date nextHeightDay() {
		Calendar calendar = Calendar.getInstance(LOCALE);
		calendar.add(Calendar.DAY_OF_YEAR, 8);
		return calendar.getTime();
	}

	private synchronized Date findDate(Element e) throws ParseException {
		String text = e.select("div.day_tournoi").text();
		Date date = MB_DATE_FORMAT.parse(text);
		Calendar calendar = Calendar.getInstance(LOCALE);
		calendar.setTime(date);
		calendar.set(Calendar.YEAR, Calendar.getInstance(LOCALE).get(Calendar.YEAR));
		return calendar.getTime();
	}

}
