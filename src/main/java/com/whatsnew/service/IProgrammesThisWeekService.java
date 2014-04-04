package com.whatsnew.service;

import com.whatsnew.model.BroadCastProgramme;

import java.util.List;

/**
 * Interface class for ProgrammesThisWeek API
 * Created by Lakshmi on 02/04/14.
 */
public interface IProgrammesThisWeekService
{

	List<BroadCastProgramme> programmesThisWeek();
}
