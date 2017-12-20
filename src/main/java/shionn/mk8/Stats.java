package shionn.mk8;

import java.util.ArrayList;

public class Stats extends ArrayList<Stat> {
	private static final long serialVersionUID = 5947525112826303380L;

	public Stat get(String id) {
		return stream().filter(d -> d.getId().equals(id)).findAny().get();
	}

}
