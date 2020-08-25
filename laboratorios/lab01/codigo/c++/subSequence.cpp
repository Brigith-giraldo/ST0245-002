#include <bits/stdc++.h>

using namespace std;

    int subSequence(int i, int len, string s1, string s2){
        if (i < s1.length()){
            int s = s2.find(s1[i]);
            if (s >= 0){
                return subSequence(i+1, len+1, s1, s2.substr(s));
            }
        }
        return len;
    }

    void sub(string s1, string s2){
        int max_len = 0;
        for (int i  = 0; i < s1.length(); i++){
            if (max_len < s1.length()-i){
                int max = subSequence(i, 0, s1, s2);
                if (max > max_len){
                    max_len = max;
                }
            }
        }
        cout << "Mayor largo del subString: " << max_len << "\n";
    }

int main(){
    #ifdef LOCAL
        freopen("input", "r", stdin);
    #else
        #define endl '\n'
    #endif
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s1,s2;
    for (int i = 0;i < 20 ;i++){
        cin >> s1; 
        cin >> s2;
        int end,start;
        cout << s1.length() << endl;
        cout << s2.length() << endl;
        start = time(0);
        sub(s1,s2);
        end = time(0);
        cout << end-start << endl;
    }
    return 0;
}