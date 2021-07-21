#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

// Print the vector 
void display(vector<string> ans){
    int len = ans.size();
    cout << "[";
    for(int i = 0 ; i < len; i++){
        cout << ans[i] ;
        if( i < len - 1) cout << ", ";
    }
    cout << "]" << endl;
}

vector<string> pathOfLadder(int st , int dest , int jump){
    if(st == dest ){
        vector<string> base;
        base.push_back("");
        return base;
    }

    vector<string> ans;
    for(int move = 1 ; move <= dest - st && move <= jump ; move++){
        vector<string>  smallAns = pathOfLadder(st + move , dest , jump);
        for(string s : smallAns){
            ans.push_back(to_string(move) + s);
        }
    }
    return ans ;
} 

int main() {
    int n,m ; cin >> n >> m ;
    vector<string> ans = pathOfLadder(0 , n, m);
    cout << ans.size() << endl;
    
    display(ans);
    
    for(string s : ans){
        cout << s << endl;
    }
    return 0;
}
