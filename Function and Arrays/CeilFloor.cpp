#include<iostream>
#include<vector>

using namespace std;

void binarySearch(vector<int>& arr, int data, int st, int ei){

    while(st <= ei){

        int mid = (st + ei)/ 2;
        if (arr[mid] > data){
            ei = mid - 1;
        }   
        else {
            st = mid + 1;
        }
    }
    cout << arr[st] << endl;
    cout << arr[ei] << endl;
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


    binarySearch(arr, data, 0, arr.size() - 1);
    return 0;
}