package com.whatsnew.service;

import com.whatsnew.exception.JSONParsingException;
import com.whatsnew.exception.WhatsNewServiceException;
import com.whatsnew.model.BroadCastProgramme;
import com.whatsnew.model.Programme;
import com.whatsnew.util.JSONUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides the implementation for {@link com.whatsnew.service.WhatsNewService}
 * Created by Lakshmi on 02/04/14.
 */
public class WhatsNewService implements IWhatsNewService
{

	private final IProgrammesThisWeekService iProgrammesThisWeekService;

	public WhatsNewService(final IProgrammesThisWeekService iProgrammesThisWeekService)
	{
		this.iProgrammesThisWeekService = iProgrammesThisWeekService;
	}

	@Override
	public String newProgrammesThisWeek() throws WhatsNewServiceException
	{
		List<BroadCastProgramme> programmeList = iProgrammesThisWeekService.programmesThisWeek();
		List<Programme> newProgrammes = new ArrayList<Programme>();

		if (programmeList != null)
		{
			for (BroadCastProgramme broadCastProgramme : programmeList)
			{
				// only add Programmes which are new(i.e no firstBroadcastDateTime)
				if (broadCastProgramme.getFirstBroadCaseDateTime() == null)
				{
					newProgrammes.add(broadCastProgramme.getProgramme());
				}
			}
		}
		try
		{
			return JSONUtils.toJSON(newProgrammes);
		} catch (JSONParsingException e)
		{
			throw new WhatsNewServiceException("Exception parsing JSON", e);
		}
	}
}
