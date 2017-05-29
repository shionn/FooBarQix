package shionn.tcg;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import shionn.tcg.rss.Channel;
import shionn.tcg.rss.Item;
import shionn.tcg.rss.Rss;

@Path("/")
public class MbService {
	private static final Locale LOCALE = Locale.FRANCE;
	private static final SimpleDateFormat MB_DATE_FORMAT = new SimpleDateFormat("EEE dd MMM", LOCALE);
	private static final SimpleDateFormat RFC822_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",
			Locale.ENGLISH);

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Rss get() throws IOException, ParseException {
		Document doc = Jsoup.connect("https://www.magicbazar.fr/tournament/boutique-annecy")
				.header("referer", "https://www.magicbazar.fr").header("accept", MediaType.TEXT_HTML)
				.header("user-agent", "Mozilla/5.0").get();
		List<Item> items = new ArrayList<>();
		for (Element row : doc.select("div.present_tournoi")) {
			Date date = findDate(row);
			if (date.before(nextHeightDay())) {
				for (Element e : row.select("div.contain_tournoi")) {
					Item item = new Item();
					item.setPubDate(formatDate(date));
					item.setDescription(e.select("div").first().text());
					items.add(item);
				}
			}
		}
		Channel channel = new Channel();
		channel.setItems(items);
		Rss rss = new Rss();
		rss.setChannel(channel);
		return rss;
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

	private synchronized String formatDate(Date date) {
		return RFC822_DATE_FORMAT.format(date);
	}

}
