#include <iostream>
#include<cmath>

int countDigit(int n){
    int count = 0 ;
    int num = n;
    while(num > 0){
        num /= 10;
        count++;
    }
    return count;
}

int rotateDigits(int n, int r){
    int len = countDigit(n);
    r %= len;
    if( r < 0 ) r = (r + len) % len;

    int mul = 1, div = 1;
    for( int i = 1 ; i <= len ; i++){
        if( i <= r )    div *= 10; 
        else  mul *= 10;
    }

    int A = n % div;
    int B = n / div;

    return (A*mul + B);
}

using namespace std;
int main(){
    int n,k;
    cin>>n>>k;
    
    //write your code here
    cout << rotateDigits(n,k) << endl;
}