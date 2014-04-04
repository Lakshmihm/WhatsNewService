package com.whatsnew.service;

import com.whatsnew.exception.WhatsNewServiceException;

/**
 * Interface class for WhatsNewService API
 * Created by Lakshmi on 02/04/14.
 */
public interface IWhatsNewService
{

	/**
	 * @throws com.whatsnew.exception.WhatsNewServiceException
	 * @return List of new Programmes{@link com.whatsnew.model.Programme} as JSON String
	 */
	String newProgrammesThisWeek() throws WhatsNewServiceException;
}
