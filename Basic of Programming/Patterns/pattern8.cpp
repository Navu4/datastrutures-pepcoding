#include <iostream>
using namespace std;

void pattern8(int row){
    int nsp = row - 1;
    for( int r = 1; r <= row; r++){
        for(int csp = 1; csp <= nsp ; csp++){
            cout << "	"; 
        }
        cout << "*	" << endl; 
        nsp--;
    }
}


int main(int argc, char **argv)
{
    int n;
    cin >> n;

    //write your code here
    pattern8(n);
}