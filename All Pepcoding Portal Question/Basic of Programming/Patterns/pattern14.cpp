#include<iostream>
using namespace std;

void pattern14(int n){
    for(int i = 1; i <= 10 ; i++){
        cout << n << " * " << i << " = " << n*i << endl; 
    }
}

int main(int agrc, char** argv){
    int n;
    cin >> n;
    
    //write your code here
    pattern14(n);    
}