package shionn.data;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.ApplicationScope;

@Controller
@ApplicationScope
public class DataController {

	@Autowired
	@Value("${data.security}")
	private String security;
	private Map<String, String> datas = new HashMap<>();

	@RequestMapping(path = "data/{key}/{value}", method = RequestMethod.POST)
	@ResponseBody
	public String post(@PathVariable(name = "key") String key,
			@PathVariable(name = "value") String value,
			@RequestHeader(name = "security") String security) {
		if (this.security.equals(security)) {
			this.datas.put(key, value);
		}
		return value;
	}

	@RequestMapping(path = "data/{key}", method = RequestMethod.GET)
	@ResponseBody
	public String get(@PathVariable(name = "key") String key,
			@RequestHeader(name = "security") String security) {
		if (this.security.equals(security)) {
			return this.datas.get(key);
		}
		return key;
	}

	@RequestMapping(path = "data", method = RequestMethod.GET)
	@ResponseBody
	public String get(@RequestHeader(name = "security") String security) {
		if (this.security.equals(security)) {
			return this.datas.entrySet().stream().map(e -> e.getKey() + ':' + e.getValue())
					.reduce("", (e, f) -> e + '\n' + f);
		}
		return "";
	}

}
