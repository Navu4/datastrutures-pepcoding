#include<iostream>
#include<vector>
using namespace std;    

// print in decreasiong order
void printDecreasing(int n) {
    if(n == 0) return;
    
    cout << n << endl; 
    printDecreasing(n-1);
}

// Print in increasing order
void printIncreasing(int n) {
    if(n == 0) return;
    
    cout << (n-1) << endl;
    cout << n << endl;
}

// First Decreasing then Increasing
void pdi(int n) {
    if(n == 0) return; 
    
    cout << n << endl;
    pdi(n-1);
    cout << n << endl;
}

// Factorial of a number using recursion
int factorial(int n) {
    if(n <= 1) return 1;
    
    return n*factorial(n-1);
    
    // Or
    // return n == 0 ? 1 : n * factorial(n -1);
}

// Linear Power
int power(int x, int n) {
    if(n == 0) return 1;
    return x * power(x,n-1);
}

// log power 
int logPower(int x, int n) {
    if (n == 0) return 1;
    int smallAns = power(x, n / 2);
    smallAns *= smallAns;

    return (n % 2 == 0 ? smallAns : smallAns * x);
}


// Euler Fuction (Tree of recursion)
int eulerFunction(int n)
{
    if (n <= 1)
    {
        cout << "Base Case: " + to_string(n) << endl;
        return n;
    }

    int count = 0;

    cout << "pre: " + to_string(n) << endl;
    count += eulerFunction(n - 1);

    cout << "in: " + to_string(n) << endl;

    count += eulerFunction(n - 2);
    cout << "post: " + to_string(n) << endl;

    return count + 3;
}

// 