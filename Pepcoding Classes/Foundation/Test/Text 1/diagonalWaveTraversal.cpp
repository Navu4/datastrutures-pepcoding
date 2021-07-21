#include<iostream>
#include<vector>
using namespace std;

void input2DArray(vector<vector<int>>& arr){
    for(int i = 0 ;i < arr.size(); i++){
        for(int j = 0  ; j < arr[0].size() ; j++){
            cin >> arr[i][j];
        }
    }
}

void diagonalWaveTraversal(vector<vector<int>>& arr){
    int n = arr.size();
    int i = n - 1 , j = 0;

    bool dir = true; // Downward direction
    cout << "---------------------------------------------------" << endl;
    int k = n * n;
    for(int t = 0 ; t < k ; t++){
        if(dir){
            for( ; j < n && i < n ; i++, j++){
                cout << arr[i][j] << endl;
                k++;
            }

            if(j > n-1){
                j = n -1 ;
                i -= 2;
            }
            if(i > (n -1) && j < n ){
                i = n -1 ;
            }
            dir = false;
        }
        else {
            for( ; j >= 0 && i >= 0 ; i--, j--){
                cout << arr[i][j] << endl;
                k++;
            }

            if( i < 0 ){
                j += 2 ;
                i = 0 ;
            }
            if(i >= 0 && j < 0 ){
                j = 0 ;
            }
            dir = true;
        }   
    }
}

int main(){
    int n ; cin >> n;

    vector<vector<int>> arr(n,vector<int> (n,0));
    input2DArray(arr);

    diagonalWaveTraversal(arr);
    return 0;
}