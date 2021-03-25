#include<iostream>
#include<vector>
using namespace std;

// Find the maximum value
int maximumElement(vector<int>& arr){
    int maxEle = -1e8;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] > maxEle){
            maxEle = arr[i];
        }
    }
    return maxEle;
}

// Find the minmum value
int minmumElement(vector<int>& arr){
    int minEle = 1e8;
    for(int i= 0;i< arr.size(); i++){
        if(arr[i] < minEle){
            minEle = arr[i];
        }
    }
    return minEle;
}

int spanOfArray(vector<int>& arr){
    return maximumElement(arr) - minmumElement(arr);
}


int main(int argc, char **argv){
    int n1; cin >> n1;
    vector<int> arr1(n1,0);
    for(int i = 0; i < arr1.size() ; i++){
        cin >> arr1[i];
    }
    
    cout << spanOfArray(arr1);
    return 0;
}