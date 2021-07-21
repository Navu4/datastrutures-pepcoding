#include <iostream>
using namespace std;

void pattern12(int row){
    int a = 0;
    int b = 1;
    for( int r = 1; r <= row ; r++){
        for(int c = 1; c <= r ;c++ ){
            cout << a << "	" ;
            int sum = a + b; 
            a = b;
            b = sum;
        }
        cout << endl;
    }
}

int main(int argc, char **argv){
    int n;
    cin >> n;
    
    //write your code here  
    pattern12(n);    
}