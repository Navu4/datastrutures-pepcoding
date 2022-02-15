#include<iostream>
using namespace std;

void gradingSystem(int n){
    if(n > 90){
        cout << "excellent" << endl;
    } else if ((n > 80) && (n <= 90)){
        cout << "good" << endl;
    } else if ((n > 70) && (n <=80)){
        cout << "fair" << endl;
    } else if ((n > 60) && (n <= 70 )){
        cout << "meets expectations" << endl;
    } else {
        cout << "below par" << endl;
    }
}

int main(int argc, char**argv){
    int marks;
    cin>>marks;
    
    //write your code here
    gradingSystem(marks);
}