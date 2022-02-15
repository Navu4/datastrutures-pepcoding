#include <iostream>
using namespace std;

void pattern11(int row){
    int nst = 1;
    for( int r = 1; r <= row ; r++){
        for(int c = 1; c <= r ;c++ ){
            cout << nst << "	" ;
            nst++;
        }
        cout << endl;
    }
}

int main(int argc, char **argv){
    int n;
    cin >> n;
    
    //write your code here
    pattern11(n);   
}