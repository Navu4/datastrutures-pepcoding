#include <iostream>
using namespace std;

void fib(int n){
    int a = 0;
    int b = 1;
    
    while(n-- > 0){
        cout << a << endl ;
        int temp = a;
        a = b;
        b = a + temp;
    }
}


int main(int argc, char **argv)
{
    int n;
    cin >> n;
    
    //write your code here
    fib(n);
    
}