package kku.harvest;

import java.time.LocalDate;
import java.util.List;
import java.util.Arrays;

import me.jhenrique.manager.TweetManager;
import me.jhenrique.manager.TwitterCriteria;
import me.jhenrique.model.Tweet;

public class Harvest {
	private static List<String> keywordList = Arrays.asList("superbowl");

	public static void main(String[] args) {
		LocalDate start = LocalDate.parse("2017-02-05"), end = LocalDate.parse("2017-02-06");
		for (String keyword : keywordList) {
			System.out.println(String.format("*********** %s **********", keyword));
			for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
				String harvestStartDate = date.toString();
				String harvestEndDate = date.plusDays(1).toString();
				System.out.println(String.format("start date : %s , end date %s", harvestStartDate, harvestEndDate));
				TwitterCriteria criteria = TwitterCriteria.create().setQuerySearch(keyword).setSince(harvestStartDate).setUntil(harvestEndDate);
				List<Tweet> t = TweetManager.getTweets(criteria);
				System.out.println("tweet size :" + t.size());
			}
			System.out.println("************** End *************");
		}

	}

}
