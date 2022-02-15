#include <iostream>
using namespace std;

void printMirrorTriangle(int row){
    int nst = 1; // No. of star
    int nsp = row -1; //No. of space
    for (int r = 1; r <= row ; r++){
        for( int csp = 1; csp <= nsp; csp++){
            cout << "	";
        }

        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*	"; 
        }
        nsp--;
        nst++;
        cout << endl;
    }
}

int main(int argc, char **argv){
    int n;
    cin >> n;
    
    //write your code here
    printMirrorTriangle(n);
}