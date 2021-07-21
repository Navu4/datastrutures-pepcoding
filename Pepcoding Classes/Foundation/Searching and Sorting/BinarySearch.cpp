#include<iostream>
#include<vector>

using namespace std;

// void input(vector<int>& arr, int n){
//     for(int i = 0; i < n; i++){
//         cin >> arr[i];
//     }
// }
void output(vector<int>& arr){
    for(int i = 0; i < arr.size(); i++){
        cout << arr[i];
    }
}

int binarySearch(vector<int>& arr, int data, int st, int ei){

    while(st <= ei){

        int mid = (st + ei)/ 2;
        if(arr[mid] == data){
            return mid;
        }   
        else if (arr[mid] > data){
            ei = mid - 1;
        }   
        else {
            st = mid + 1;
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


    cout << binarySearch(arr, data, 0, arr.size() - 1) << endl;
    return 0;
}