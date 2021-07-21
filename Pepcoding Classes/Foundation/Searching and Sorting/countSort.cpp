#include<iostream>
#include<vector>
using namespace std;

void countSort(vector<int> &arr, int minEle, int maxEle)
{
    vector<int> freqArray(maxEle - minEle + 1, 0);

    for (int ele : arr)
        freqArray[ele - minEle]++;

    int itr = 0;
    for (int i = 0; i < freqArray.size(); i++)
    {
        int freq = freqArray[i];
        while (freq-- > 0)
        {
            arr[itr++] = i + minEle;
        }
    }
}

int main(){
    int n ; cin >> n;

    vector<int> arr(n,0);
    int minEle = 1e9;
    int maxEle = -1e9;
    for(int i= 0; i < arr.size(); i++ ){
        cin >> arr[i];
        minEle = min(arr[i],minEle);
        maxEle = max(arr[i],maxEle);
    }

    countSort(arr, minEle, maxEle);
    for(int i= 0; i < arr.size(); i++ ){
        cout << arr[i] << " ";
    }
    return 0;
}


