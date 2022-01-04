package moderate.exercises;

import java.util.Arrays;

/**
 * Living People Given a list of people with their birth and death years,
 * implement a method to compute the year with the most number of people alive.
 * If a person was alive during any portion of that year, they should be
 * included. #Intervals
 * 
 * APPROACH: 
 * We have to think of what we care about, and what we don't. For example: 
 * 
 * - Do we care about the birth year? (Yes, because it means someone
 * start to live in that time frame) 
 * - Do we care about the death year? (Yes! because it means, someone stop 
 * living during that time frame) 
 * - Do we care about which birth year corresponds to which death year? (it 
 * seems important, but...actually not, what actually matters is if someone 
 * gets it or out of the imeline, but whether that person lives longer or not...pff)
 * 
 * @author luisa
 */
public class ex10 {

	public static int getYearMostPeopleAlive(int[][] people) {
		// 1. Get birth and death years arrays and sort them
		int[] birth = new int[people.length];
		int[] death = new int[people.length];
		int c = 0;

		for (int[] p : people) {
			birth[c] = p[0];
			death[c] = p[1];
			c++;
		}
		Arrays.sort(birth);
		Arrays.sort(death);

		// 2. Loop over the array to compute who gets in and out
		int maxAlive = Integer.MIN_VALUE;
		int alivePeople = 0;
		int maxYear = 0;
		int i = 0;
		int j = 0;

		while (i < people.length && j < people.length) {
			// 2.1 Move on with the birth year as long as the next interval overlap, meaning I
			// can keep counting up
			if (birth[i] <= death[j]) {
				alivePeople++;
				i++;
				// 2.1.1 Update the data I want to monitor
				if (maxAlive < alivePeople) {
					maxAlive = alivePeople;
					maxYear = death[j];
				}
				// 2.2 When they stop overlapping, it means these people did not meet in the same
				// time line (:heart broken:)
			} else {
				j++;
				alivePeople--;
			}
		}

		return maxYear;
	}

	public static void main(String[] args) {
		int[][] people = { { 1978, 2005 }, { 1930, 2018 }, { 1910, 2016 }, { 1922, 2011 }, { 1971, 2014 },
				{ 1936, 1998 }, { 1925, 2001 }, { 1945, 2007 } };
		int yearMostAlive = getYearMostPeopleAlive(people);

		System.out.println(yearMostAlive);

	}

}
