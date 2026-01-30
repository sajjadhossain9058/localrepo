#include<iostream>
using namespace std;

void print(int arr[], int size){
    for (int i=0; i<size; i++){
        cout << arr[i] << " ";
    }
    cout << "\n" ;
}

double getmedian(int arr[], int n){
    if (n%2 != 0){
        return arr[n/2];
    }else{
        return (arr[(n/2)-1]+arr[n/2])/2;
    }
}

int main(){
    int arr[] = {6,3,7,3,8,1,9,2};
    int size = sizeof(arr)/sizeof(arr[0]);
    for(int i=0; i<getmedian(arr,size); i++){
       for(int j=0; j<size-i-1; j++){
        if(arr[j+1] > arr[j]){
            swap(arr[j+1],arr[j]);
        }
       }
       print(arr,size);
    }
}
