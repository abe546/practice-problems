class Solution {
public:
    int minDays(int n) {
        static unordered_map<int,int> dp;
        if (n <=1) return n;
        return dp.count(n) ? dp[n] : dp[n] = 1 + min(n%2 + minDays(n/2), n%3 + minDays(n/3));
    }
};