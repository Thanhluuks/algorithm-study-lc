package Daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MincostTickets {
    static Set<Integer> isTravelNeeded = new HashSet<>();
    static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];
        int[] dp = new int[lastDay+1];
        Arrays.fill(dp, -1);

        for (int day : days) {
            isTravelNeeded.add(day);
        }
        return solve(dp,days,costs,1);

    }

    private static int solve(int[] dp, int[] days, int[] costs, int currDay) {
        if (currDay > days[days.length-1]) {
            return 0;
        }
        if (!isTravelNeeded.contains(currDay)) {
            return solve(dp,days,costs,currDay+1);
        }
        if (dp[currDay] != -1) {
            return dp[currDay];
        }
        int oneDayOption = costs[0] + solve(dp,days,costs, currDay+1);
        int sevenDayOption = costs[1] + solve(dp,days,costs,currDay+7);
        int oneMonthOption =  costs[2] + solve(dp, days, costs, currDay+30);
        return dp[currDay] = Math.min(oneDayOption, Math.min(sevenDayOption,oneMonthOption));
    }

    public static void main(String[] args) {

    }
}
