#include <bits/stdc++.h>

using namespace std;

int llenar(int n){
    if (n < 0){
        return 0;
    }
    if (n == 0){
        return 1;
    }
    return llenar(n-2) + llenar(n-1);
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;
    cout << llenar(n) << endl;

    return 0;
}