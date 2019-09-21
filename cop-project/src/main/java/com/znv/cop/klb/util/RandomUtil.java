package com.znv.cop.klb.util;

import java.util.UUID;

public class RandomUtil 
{
	
	public static String createLogId()
	{
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	

}
