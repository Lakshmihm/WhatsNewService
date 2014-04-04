package com.whatsnew.model;

import java.util.Arrays;

/**
 *  POJO to hold Programme information
 * Created by Lakshmi on 02/04/14.
 */
public class Programme
{

	private String seriesName;

	private int seasonNumber;

	private String episodeName;

	private int episodeNumber;

	protected Programme()
	{

	}

	public Programme(Builder builder)
	{
		this.seriesName = builder.seriesName;
		this.episodeName = builder.episodeName;
		this.seasonNumber = builder.seasonNumber;
		this.episodeNumber = builder.episodeNumber;
	}

	public static class Builder
	{
		private String seriesName;

		private int seasonNumber;

		private String episodeName;

		private int episodeNumber;

		public Builder seriesName(String seriesName)
		{
			this.seriesName = seriesName;
			return this;
		}

		public Builder seasonNumber(int seasonNumber)
		{
			this.seasonNumber = seasonNumber;
			return this;
		}

		public Builder episodeName(String episodeName)
		{
			this.episodeName = episodeName;
			return this;
		}

		public Builder episodeNumber(int episodeNumber)
		{
			this.episodeNumber = episodeNumber;
			return this;
		}

		public Programme build()
		{
			return new Programme(this);
		}

	}

	public String getSeriesName()
	{
		return seriesName;
	}

	public int getSeasonNumber()
	{
		return seasonNumber;
	}

	public String getEpisodeName()
	{
		return episodeName;
	}

	public int getEpisodeNumber()
	{
		return episodeNumber;
	}

	@Override public boolean equals(Object obj)
	{
		if (obj instanceof Programme)
		{
			Programme programme = (Programme) obj;
			return (programme.episodeNumber == this.episodeNumber) &&
				(programme.seasonNumber == this.seasonNumber) &&
				(programme.episodeName.equals(this.episodeName)) &&
				(programme.seriesName.equals(this.seriesName));
		}

		return false;
	}

	@Override public int hashCode()
	{
		return Arrays.hashCode(new Object[] { episodeName, seasonNumber, episodeName, seriesName });
	}
}
