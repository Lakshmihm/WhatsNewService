package com.whatsnew.service;

import com.whatsnew.exception.JSONParsingException;
import com.whatsnew.exception.WhatsNewServiceException;
import com.whatsnew.model.BroadCastProgramme;
import com.whatsnew.model.Programme;
import com.whatsnew.util.JSONUtils;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * unit tests for WhatsNewService API
 * Created by Lakshmi on 02/04/14.
 */

public class TestWhatsNewService
{

	@Test
	public void testNewProgrammes() throws WhatsNewServiceException
	{
		IProgrammesThisWeekServiceStub programmesThisWeekServiceStub = new IProgrammesThisWeekServiceStub();
		IWhatsNewService whatsNewService = new WhatsNewService(new IProgrammesThisWeekServiceStub());

		String json = whatsNewService.newProgrammesThisWeek();
		List<Programme> newProgrammes = JSONUtils.fromJSON(json, new TypeReference<List<Programme>>()
		{
		});
		List<BroadCastProgramme> thisWeek = programmesThisWeekServiceStub.programmesThisWeek();
		//make sure none of the new programmes have first broadcast datetime
		for (BroadCastProgramme broadCastProgramme : thisWeek)
		{
			if (broadCastProgramme.getFirstBroadCaseDateTime() == null)
				assertTrue(newProgrammes.contains(broadCastProgramme.getProgramme()));
			else
				assertFalse(newProgrammes.contains(broadCastProgramme.getProgramme()));
		}
	}

	@Test
	public void testNoNewProgrammes() throws WhatsNewServiceException
	{
		IProgrammesThisWeekService emptyProgrammesThisWeek = new IProgrammesThisWeekService()
		{
			@Override public List<BroadCastProgramme> programmesThisWeek()
			{
				return Collections.emptyList();
			}
		};
		IWhatsNewService whatsNewService = new WhatsNewService(emptyProgrammesThisWeek);
		String json = whatsNewService.newProgrammesThisWeek();
		assertEquals("[]",json);

	}

	@Test(expected = WhatsNewServiceException.class)
	public void testExceptionScenario() throws WhatsNewServiceException {
		IWhatsNewService whatsNewService = new IWhatsNewService()
		{
			@Override public String newProgrammesThisWeek() throws WhatsNewServiceException
			{
				 throw new WhatsNewServiceException("Exception parsing JSON",new JSONParsingException());
			}
		};
		whatsNewService.newProgrammesThisWeek();
	}


}
