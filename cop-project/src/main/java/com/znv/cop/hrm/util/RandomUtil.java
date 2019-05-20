package com.znv.cop.hrm.util;

import java.util.UUID;

public class RandomUtil 
{
	
	public static String createLogId()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	

}
