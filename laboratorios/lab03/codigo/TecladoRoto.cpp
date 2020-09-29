#include <bits/stdc++.h>

#define D(x) cout << #x << ": " << x << endl;
#define forn(i,n) for(int i=0; i< (int)n; i++)
#define for1(i,n) for(int i=1; i<= (int)n; i++)
#define all(v) v.begin(),v.end()

using namespace std;

typedef long long ll;


int main(){
    ios::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cout<< setprecision(20)<< fixed;
    #ifdef LOCAL
        freopen("input.txt", "r", stdin);
    #else
        #define endl '\n'
    #endif

    string s;
    while (cin >> s){
        deque<string> deq;
        string s2 = "";
        int aux = 1;
        forn(i,s.size()){
            if (s[i] == '[' || s[i] == ']'){
                if (aux == 1){
                    deq.push_front(s2);
                    s2 = "";
                }else {
                    deq.push_back(s2);
                    s2 = "";
                }
                if (s[i] == '['){
                    aux = 1;
                }else {
                    aux = 2;
                }
            }else {
                s2 += s[i];
            }
        }
        if (aux == 1){
            deq.push_front(s2);
            s2 = "";
        }else {
            deq.push_back(s2);
        }
        for (string ss : deq){
            cout << ss;
        }
        cout << endl;
    }

    return 0;
}