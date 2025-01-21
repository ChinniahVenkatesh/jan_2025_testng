package TestScript;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.annotations.Test;


import Base.testBase;

public class TestScript002 extends testBase{

	
	
	@Test
	public void TC004() throws IOException
	{
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("MM_dd_yyyy_HH_mm_ss");
		sdf.format(d);
		System.out.println(sdf.format(d));
	}
	
	
	@Test
	public void TC005()
	{
		String password = "Password@12345";
		System.out.println(password);
	}
}
