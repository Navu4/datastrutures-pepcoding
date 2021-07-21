#include <bits/stdc++.h>
using namespace std;
#define int long long
int n, k;
int a[100005], dp[100005];

int func(int ind)
{
    if (ind == n)
    {
        return 0;
    }

    if (dp[ind] != -1)
        return dp[ind];

    int mini = 1e10;
    for (int i = ind + 1; i <= min(n, ind + k), i++)
    {
        mini = min(mini, ((a[i] - a[ind])*(a[i] - a[ind]) + k) + func(i));
    }

    return dp[ind] = mini;
}

int main()
{
    cin >> n >> k;

    for (int i = 1; i <= n; i++)
    {
        cin >> a[i];
        dp[i] = -1;
    }

    memset(dp, -1, sizeof dp);
    cout << func(1);

    return 0;
}