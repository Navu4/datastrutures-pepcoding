#include <iostream>
using namespace std;

void printTriangle(int row){
    int nst = 1; // No. of star
    for (int r = 1; r <= row ; r++){
        for ( int cst = 1 ; cst <= nst; cst++){
            cout << "*	"; 
        }
        nst++;
        cout << endl;
    }
}

int main(int argc, char **argv){
    int n;
    cin >> n;
    
   //write your code here
   printTriangle(n);
}