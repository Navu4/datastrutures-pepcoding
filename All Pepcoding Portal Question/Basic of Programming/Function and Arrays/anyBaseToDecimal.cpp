#include<iostream>
#include<vector>
using namespace std;

int decimalToBinary(int n,int b){
    int res = 0;
    int pow = 1;

    while(n != 0){
        int rem = n % 10;
        n /= 10;

        res += rem*pow;
        pow *= b;
    }
    return res;
}

int main(){
    int n,b; cin >> n >> b;
    cout << decimalToBinary(n,b); 
}