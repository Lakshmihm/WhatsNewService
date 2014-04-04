package com.whatsnew.util;

import com.whatsnew.exception.JSONParsingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;

/**
 * Utility class to convert String to JSON and JSON to String
 * Uses the jackson api library
 * Created by Lakshmi on 02/04/14.
 */
public class JSONUtils
{

	private static final ObjectMapper MAPPER = new ObjectMapper();

	/**
	 * converts object to JSON String
	 * @throws  com.whatsnew.exception.JSONParsingException
	 *
	 * @return String
	 */
	public static String toJSON(Object obj)
	{
		try
		{
			return MAPPER.writeValueAsString(obj);
		} catch (IOException e)
		{
			throw new JSONParsingException(e);
		}
	}
	/**
	 * converts to object of specified type from String
	 * @throws  com.whatsnew.exception.JSONParsingException
	 * @param objType the class of the object
	 * @return T
	 */
	public static <T> T fromJSON(String json, Class<T> objType)
	{
		try
		{
			return MAPPER.readValue(json, objType);
		} catch (IOException e)
		{
			throw new JSONParsingException(e);
		}
	}

	/**
	 * converts from Object to String
	 * @param json JSON String
	 * @param objType TypeReference of the Object
	 * @param <T> Object Type
	 * @return T object of Type T
	 */
	public static <T> T fromJSON(String json, TypeReference<T> objType)
	{
		try
		{
			return MAPPER.readValue(json, objType);
		} catch (IOException e)
		{
			throw new JSONParsingException(e);
		}
	}



}
