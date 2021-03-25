#include<iostream>
#include<vector>
using namespace std;
bool isPrime(int n){
    for(int i = 2;i * i <= n;i++){
        if(n % i == 0) return true;
    }
    return false;
}
void removePrimes(vector<int>& arr){
    vector<int> ans;
    for(int i = 0 ; i < arr.size(); i++){
        if(isPrime(arr[i]))  ans.push_back(arr[i]);
    }
    
    cout << "[" << ans[0];
    for(int i = 1 ; i < ans.size() ; i++)  cout << ", " << ans[i];
    cout << "]";
}

int main(){
    int n ; cin >> n;
    vector<int> arr(n);
    for(int i = 0 ; i < arr.size(); i++)  cin >> arr[i];
    
    removePrimes(arr);
    return 0;
}