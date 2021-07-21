#include<iostream>
#include<vector>

using namespace std;

int linearSearch(vector<int>& arr, int data, int st, int ei){

    for(int i = st; i < ei; i++){
        if(arr[i] = data){
            return i;
        }
    }
    return -1;
}



int main(){

    int n; 
    cin >> n ;
    vector<int> arr (n,0);

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }

    int data; 
    cin >> data;


    cout << linearSearch(arr, data, 0, arr.size() - 1) << endl;
    return 0;
}