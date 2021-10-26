package medium.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms2 {

	static class Meeting{
		int start;
		int end;
		
		public Meeting(int start, int end){
			this.start = start;
			this.end = end;
		}
		
		public String toString() {
			return "(" + this.start + ", " + this.end + ")";
		}
	}
	
	class MeetingComparator implements Comparator<Meeting>{

		@Override
		public int compare(Meeting o1, Meeting o2) {
			return o1.end - o2.end;
		}	
	}
	
	public static void main(String[] args) {
		int[][] intervals = {{0,7}, {1,3}, {4,5}, {6,8}, {9,11}, {10,12}};
		

		List<Meeting> meetings = new ArrayList<>();
		for(int[] interval: intervals) {
			Meeting m = new Meeting(interval[0], interval[1]);
			meetings.add(m);
		}
		
		//meetings.forEach(i -> System.out.print(i + ", "));
		
		PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
		endTimes.add(meetings.get(0).end);
		meetings.remove(0);
		
		for(Meeting meeting: meetings) {
			System.out.println(meeting.start + " is bigger than " + endTimes.peek() + "?");
			if(meeting.start >= endTimes.peek()) //if they DO NOT intersects
				endTimes.poll();
			
			endTimes.add(meeting.end);
		}
		
		System.out.println("N. Rooms: " + endTimes.size());
	}

}
