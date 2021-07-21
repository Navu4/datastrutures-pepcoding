#include<iostream>
#include<vector>
#include<algorithm> // sort function

using namespace std;


void targetSum(vector<int>& arr, int data, int si, int ei){

    sort(arr.begin(), arr.end());
    while(si < ei){

        int sum = arr[si] + arr[ei];
        if(sum > data){
            ei--;
        }   
        else if (sum < data){
            si++;
        }   
        else {
            cout << arr[si] << ", " << arr[ei] << endl;
            si++;
            ei--; 
        }
    }
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

    targetSum(arr, data, 0, arr.size() - 1);
    return 0;
}
