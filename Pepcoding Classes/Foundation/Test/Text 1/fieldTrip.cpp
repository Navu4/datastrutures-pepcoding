#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool fieldTrip(vector<int>& arr){
    
    if(arr.size() <= 2) return true;
    vector<int> ans(9,0);
    int n = arr.size();
    for(int i = 0 ; i < n ; i++){
        ans[arr[i]]++;
    }
    
    int count = 0 ;
    int res_n = ans.size();
    for(int i = 1 ; i < res_n ; i++){
        if(ans[i] != 0){
            count = ans[i];
            break;
        }
    }
    for(int i = 1 ; i < res_n ; i++){
        if(ans[i] != 0 && ans[i] != count){
            return false;
        }
    }
    return true;
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int n; cin >> n;
    vector<int> arr(n,0);
    for(int i = 0 ; i < n ; i++) cin >> arr[i];
    
    if(fieldTrip(arr)){
        cout << "true" << endl;
    } else {
        cout << "false" << endl;
    }
    
    return 0;
}
