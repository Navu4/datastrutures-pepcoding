#include <iostream>
#include <math.h>
using namespace std;

int countDigit(int n){
    int count = 0 ;
    int num = n;
    while(n > 0){
        n /= 10;
        count++;
    }
    return count;
}

int inverse(int n){
    int num = n;
    int len = countDigit(num);
    int res = 0;
    for(int i = 1;  i <= len ; i++){
        int digit = n % 10;
        n /= 10;
        res += i*pow(10,digit -1);
    }
    return res;
}

int main(int argc, char **argv){
    int n;
    cin >> n;

    //write your code here
    cout << inverse(n) << endl;
}