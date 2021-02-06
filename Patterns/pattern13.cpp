#include <iostream>
using namespace std;

int fact(int n){
    int factorial = 1;
    for(int i = 2; i <= n; i++){
        factorial *= i;
    }
    return factorial;
}

int nCr(int n, int r){
    return fact(n)/(fact(r)*fact(n-r));
}
int main(int argc, char **argv){
    int n;
    cin >> n;
    
    //write your code here
    for(int i=0 ; i < n ; i++){
        for(int j=0 ; j <= i ; j++){
            cout << nCr(i,j) << "	";
        }
        cout << endl;
    }
}