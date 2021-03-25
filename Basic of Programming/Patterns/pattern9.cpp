#include <iostream>
using namespace std;

void pattern9(int row) {


    for (int r = 1; r <= row; r++) {
        for (int c = 1; c <= row; c++) {
            if (r == c) {
                cout << "*	";
            } else if ((c+r) == (row+1)) {
                cout << "*	";
            } else {
                cout << "	";
            }
        }
        cout << endl;
    }
}

int main(int argc, char **argv){
    int n;
    cin >> n;

    //write your code here
    pattern9(n);
}