#include<iostream>
#include<vector>
using namespace std;

int decimalToBinary(int n){
    int res = 0;
    int pow = 1;

    while(n != 0){
        int rem = n % 1;
        n /= 2;

        res += rem*pow;
        pow *= 10;
    }
    return res;
}

int main(){
    int n; cin >> n;
    cout << decimalToBinary(n); 
}