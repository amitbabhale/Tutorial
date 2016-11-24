package com.git.techolution;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class SatisfactionIndexProblem {

	public static void main(String[] args) {
		SatisfactionIndexProblem problem = new SatisfactionIndexProblem();		
		// Scanner for user input
		Scanner sc = new Scanner( System.in );		
		
		System.out.println("Enter complete path of the file containg input data:");
		String path = sc.next();		
		File file = new File(path);
		if(file.exists()){
			System.out.println("Input file path" + file.getAbsolutePath());
			System.out.println(problem.GetMaxSatisfaction(file));
		}else{
			System.out.println("File not found");
		}

	}

	// A utility function that returns maximum of two integers
	static int max(int a, int b) { return (a > b)? a : b; }

	//This is knapSack generic algorith to solve this problem.
	// Returns the maximum value that can be put in a knapsack of capacity W
	static int knapSack(int W, int wt[], int val[], int n)
	{
		// Base Case
		if (n == 0 || W == 0)
			return 0;

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (wt[n-1] > W)
			return knapSack(W, wt, val, n-1);

		// Return the maximum of two cases: 
		// (1) nth item included 
		// (2) not included
		else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
				knapSack(W, wt, val, n-1)
				);
	}
	
	
	/**
	 * 
	 * @param file : File containing user input data
	 * @return maximum satisfaction index
	 */
	public int GetMaxSatisfaction(File file){

		int t=0;
		int menuItems = 0;
		int[] satisfactionNumber = null;
		int[] time = null;
		System.out.println(file.getPath());
		int cnt = 0;
		int maxSatisfactiion=0;
		List<String> lines;
		try {
			//read all lines from given file path
			lines = Files.readAllLines(Paths.get(file.getPath()));

			for (String line : lines) {
				String[] var = line.split(" ");
				
				if(cnt == 0){
					//read number of menuItem and targeted time to achieve max satisfaction number
					t = Integer.parseInt(var[0]);
					menuItems = Integer.parseInt(var[1]);
					satisfactionNumber = new int[menuItems+1];
					time = new int[menuItems+1];
					System.out.println("line 0 + " + cnt + " " + t + " "+ menuItems);
					cnt++;				
				}else{
					satisfactionNumber[cnt]=Integer.parseInt(var[0]);
					time[cnt]=Integer.parseInt(var[1]);					
					System.out.println("line 1 + " + cnt + " " + satisfactionNumber[cnt] + " "+time[cnt] );
					cnt++;
				}

			}

			maxSatisfactiion=knapSack(t , time, satisfactionNumber, menuItems);
			System.out.println("Maximum Satisfaction count is "+ maxSatisfactiion);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxSatisfactiion;

	}
}
