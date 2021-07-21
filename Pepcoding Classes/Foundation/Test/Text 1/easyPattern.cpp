#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

void easyPattern(int row){
    int val = 1 ;
    for(int r = 1 ; r <= row ; r++){
        int cval = val;
        for(int j = 1 ; j <= row ; j++){
            cout << cval << " ";
            cval++;
        }
        
        if(row % 2 != 0){
            if(r <= row/2){
                val += row*2;
            } else {
                if (r == row/2 + 1){
                    val -= row;
                } else
                {
                    val -= row*2;
                }
            }
        }
        else {
            if(r < row/2 ){
                val += row*2;
            } else {
                if( r == row/2 ){
                    val += row;
                } else {
                    val -= row*2;
                }
            }
        }
        cout << endl;
    }
}
int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    int num ; cin >> num;
    
    easyPattern(num);
    return 0;
}
