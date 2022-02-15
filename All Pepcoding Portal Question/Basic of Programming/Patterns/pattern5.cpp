#include <iostream>
using namespace std;

void printDiamond(int row){ // row = 5
    int nst = 1; // No. of star  = 1
    int nsp = row / 2; //No. of space = row/2  = 2
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "	";
        }

        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*	"; 
        }

        if(r <= row/2 ) { // 2 < 2
            nsp--; // 1 
            nst += 2; // 3
        }
        else {       
            nst-=2; // 
            nsp++;
        }
        cout << endl;
    }
}


int main(int argc, char **argv){
    int n;
    cin >> n;

    //write your code here

    printDiamond(n);
}