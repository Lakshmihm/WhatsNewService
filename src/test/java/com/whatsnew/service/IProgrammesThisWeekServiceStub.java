package com.whatsnew.service;

import com.whatsnew.model.BroadCastProgramme;
import com.whatsnew.model.Programme;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This is a stub class to create data for ProgrammesThisWeekService API
 * Created by Lakshmi on 02/04/14.
 */
public class IProgrammesThisWeekServiceStub implements IProgrammesThisWeekService
{

	private static final String   BIG_BANG_THEORY_SERIES = "BIG BANG THEORY";
	private static final String[] BIG_BANG_EPISODES      = {"The Fuzzy Boots Corollary", "The Pancake Batter Anomaly","The Jerusalem Duality",
		"The Peanut Reaction", "The Tangerine Factor" };
	private static final int      BIG_BANG_THEORY_SEASON = 1;

	private static final String   HOW_I_MET_YOUR_MOTHER_SERIES = "HOW I MET YOUR MOTHER";
	private static final int      HWIMY_SEASON = 2;
	private static final String[] HIMYM_EPISODES= {"Okay Awesome", "Matchmaker", "The Wedding", "Best Prom Ever","Drumroll Please"};

	private static final String   MADE_IN_CHELSEA_SERIES = "MADE IN CHELSEA";
	private static final int      MADE_IN_CHELSEA_SEASON = 5;
	private static final String[] MADE_IN_CHELSEA_EPISODES = {"Quick, Let's Have A Quickie", "Do I Look Like Jesus?","Take Your Passion, Make It Happen."};

	@Override
	public List<BroadCastProgramme> programmesThisWeek()
	{
		List<BroadCastProgramme> programmeList = new ArrayList<BroadCastProgramme>();
		for (int i = 0; i < BIG_BANG_EPISODES.length; i++)
		{
			//some randomness for the dates
			DateTime broadCastDate = new DateTime();
			broadCastDate.plusDays(i);
			broadCastDate.plusHours(5 + i);

			DateTime lastBroadcastDateTime = new DateTime();
			lastBroadcastDateTime.minusDays(10 - i);
			Programme programme = new Programme.Builder().seriesName(BIG_BANG_THEORY_SERIES).seasonNumber(BIG_BANG_THEORY_SEASON)
				.episodeName(BIG_BANG_EPISODES[i]).episodeNumber(i).build();
			BroadCastProgramme broadCastProgramme = new BroadCastProgramme.Builder().programme(programme).broadcastDateTime(broadCastDate).
			firstBroadcastDateTime((i % 2 == 0) ? lastBroadcastDateTime : null).region(Locale.UK).build();
			programmeList.add(broadCastProgramme);
		}
		for (int i = 0; i < HIMYM_EPISODES.length; i++)
		{
			//Some randomness for the dates
			DateTime broadCastDate = new DateTime();
			broadCastDate.plusDays(i);
			broadCastDate.plusHours(10 + i);
			DateTime lastBroadcastDateTime = new DateTime();
			lastBroadcastDateTime.minusDays(40 - i);
			Programme programme = new Programme.Builder().seriesName(HOW_I_MET_YOUR_MOTHER_SERIES).seasonNumber(HWIMY_SEASON)
				.episodeName(HIMYM_EPISODES[i]).episodeNumber(i).build();
			BroadCastProgramme broadCastProgramme = new BroadCastProgramme.Builder().programme(programme).broadcastDateTime(broadCastDate).
			firstBroadcastDateTime((i % 2 == 0) ? lastBroadcastDateTime : null).region(Locale.CANADA).build();
			programmeList.add(broadCastProgramme);
		}
		for (int i = 0; i < MADE_IN_CHELSEA_EPISODES.length; i++)
		{
			//Some randomness for the dates
			DateTime broadCastDate = new DateTime();
			broadCastDate.plusDays(i);
			broadCastDate.plusHours(3 + i);
			Programme programme = new Programme.Builder().seriesName(MADE_IN_CHELSEA_SERIES).seasonNumber(MADE_IN_CHELSEA_SEASON)
				.episodeName(MADE_IN_CHELSEA_EPISODES[i]).episodeNumber(i).build();
			DateTime lastBroadcastDateTime = new DateTime();
			lastBroadcastDateTime.minusDays(30 - i);
			BroadCastProgramme broadCastProgramme = new BroadCastProgramme.Builder().programme(programme).broadcastDateTime(broadCastDate).
			firstBroadcastDateTime((i % 2 == 0) ? lastBroadcastDateTime : null).region(Locale.CHINA).build();
			programmeList.add(broadCastProgramme);
		}
		return programmeList;

	}
}
