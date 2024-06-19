package greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NMeetingScheduler {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }

    static class EndTimeComparator implements Comparator<Meeting> {

        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.getEnd() - o2.getEnd();
        }
    }

    public static int maxMeetings(int start[], int end[], int n) {
        // add your code here
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        meetings.sort(new EndTimeComparator());

        int countMeetings = 0;
        int lastEndTime = 0;

        for (Meeting meeting : meetings) {
            if (meeting.getStart() > lastEndTime) {
                countMeetings++;
                lastEndTime = meeting.end;
            }
        }
        return countMeetings;
    }


}
