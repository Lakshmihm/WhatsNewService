package com.whatsnew.model;

import org.joda.time.DateTime;

import java.util.Locale;

/**
 * This is the BroadCastProgramme POJO class
 *
 * Created by Lakshmi on 02/04/14.
 */
public class BroadCastProgramme
{

	private final Programme programme;

	private final DateTime broadcastDateTime;

	private final DateTime firstBroadcastDateTime;

	private final Locale region;

	public BroadCastProgramme(final Builder builder)
	{
		this.programme = builder.programme;
		this.broadcastDateTime = builder.broadcastDateTime;
		this.firstBroadcastDateTime = builder.firstBroadcastDateTime;
		this.region = builder.region;
	}

	public Programme getProgramme()
	{
		return programme;
	}


	public DateTime getBroadcastDateTime()
	{
		return broadcastDateTime;
	}

	public DateTime getFirstBroadCaseDateTime()
	{
		return firstBroadcastDateTime;
	}

    public Locale getRegion()
	{
		return region;
	}

	public static class Builder
	{

		private Programme programme;

		private DateTime broadcastDateTime;

		private DateTime firstBroadcastDateTime;

		private Locale region;

		public Builder programme(Programme programme)
		{
			this.programme = programme;
			return this;
		}

		public Builder broadcastDateTime(DateTime broadcastDateTime)
		{
			this.broadcastDateTime = broadcastDateTime;
			return this;
		}

		public Builder firstBroadcastDateTime(DateTime firstBroadcastDateTime)
		{
			this.firstBroadcastDateTime = firstBroadcastDateTime;
			return this;
		}

		public Builder region(Locale region)
		{
			this.region = region;
			return this;
		}

		public BroadCastProgramme build()
		{
			return new BroadCastProgramme(this);
		}

	}

}


