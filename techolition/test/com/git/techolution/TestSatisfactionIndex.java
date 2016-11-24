package com.git.techolution;

import java.io.File;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

public class TestSatisfactionIndex {
	
	@Test	
	public void testGetMaxSatisfactionWithSet1() {
		String filename = "file/hoteldata2.txt";
		File file = getHotelDataDile(filename);
		SatisfactionIndexProblem problem = new SatisfactionIndexProblem();
		int actual = problem.GetMaxSatisfaction(file);
		Assert.assertEquals(11000, actual);
		
	}
	
	@Test	
	public void testGetMaxSatisfactionWithSet2() {
		String filename = "file/hoteldata.txt";
		File file = getHotelDataDile(filename);
		SatisfactionIndexProblem problem = new SatisfactionIndexProblem();
		int actual = problem.GetMaxSatisfaction(file);
		Assert.assertEquals(6000, actual);
		
	}
	
	@Test	
	public void testGetMaxSatisfactionWithEmptyFile() {
		String filename = "file/hoteldatabase.txt";
		File file = getHotelDataDile(filename);
		SatisfactionIndexProblem problem = new SatisfactionIndexProblem();
		int actual = problem.GetMaxSatisfaction(file);
		Assert.assertEquals(0, actual);
		
	}

	//Get the test file data from resource directory in class path.
	private File getHotelDataDile(String fileName) {
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		URL url = classLoader.getResource(fileName);
		File file=null;
		if(url!=null){
			file = new File(url.getFile());	
		}		
		return file;
	}
}
