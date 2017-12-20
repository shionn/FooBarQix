package shionn.tcg;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shionn.tcg.crawler.MagicBazarCrawler;
import shionn.tcg.pojo.Tournament;
import shionn.tcg.rss.Channel;
import shionn.tcg.rss.Item;
import shionn.tcg.rss.Rss;

@RestController
public class MbRssController {
	private static final SimpleDateFormat RFC822_DATE_FORMAT = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z",
			Locale.ENGLISH);

	@ResponseBody
	@RequestMapping(path = "/mb-rss", produces = { MediaType.APPLICATION_RSS_XML_VALUE })
	public Rss get() throws IOException, ParseException {
		List<Item> items = new ArrayList<>();
		for (Tournament tournament : new MagicBazarCrawler().crawl()) {
			Item item = new Item();
			item.setPubDate(formatDate(tournament.getDate()));
			item.setTitle(tournament.getTitle() + " (" + tournament.getPrice() + ")");
			item.setDescription(tournament.getDescription());
			items.add(item);
		}
		Channel channel = new Channel();
		channel.setItems(items);
		Rss rss = new Rss();
		rss.setChannel(channel);
		return rss;
	}

	private synchronized String formatDate(Date date) {
		return RFC822_DATE_FORMAT.format(date);
	}

}
