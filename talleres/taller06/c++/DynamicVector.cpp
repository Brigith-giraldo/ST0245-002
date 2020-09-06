#include <bits/stdc++.h>

#define D(x) cout << #x << ": " << x << endl;
#define len(x) sizeof(x)/sizeof(x[0])
#define forn(i,n) for(int i=0; i< (int)n; i++)
#define for1(i,n) for(int i=1; i<= (int)n; i++)
#define all(v) v.begin(),v.end()

using namespace std;

typedef long long ll;

int *coords = new int[2];
int size = 0;


//Time complexity O(n)
void remove(int index){
    if (size > 0 && index >= 0){
        if (index < size){
            size -= 1;
            for(int i = index; i < size; i++){
                coords[i] =  coords[i+1];
            }
            coords[size] = 0;
        }else{
            size -= 1;
            coords[size] = 0;
        }
    }else{
        cout << "IndexOutOfBounds" << endl;
    }
}

//Time complexity O(n)
void add(int e){
    if (size < len(coords)){
        coords[size] = e;
        size += 1;
    }else{
        int *coords2 = new int[size*2];
        forn(i,size){
            coords2[i] = coords[i];
        }
        coords2[size] = e;
        delete [] coords;
        coords = coords2;
        size += 1;
    }
}


//Time complexity O(n)
void add(int e, int index){
    if (index < size && index >= 0){
        if (size >= len(coords)){
            int *coords2 = new int[size*2];
            forn(i,size){
                coords2[i] = coords[i];
            }
            delete [] coords;
            coords = coords2;
        }
        int aux;
        for(int i = index; i <= size; i++){
            aux = coords[i];
            coords[i] = e;
            if(i+1 <= size){
                e = aux;
            }
        }
        size += 1;
    }else{
        add(e);
    }
}

void print(){
    forn(i,size){
        cout << coords[i] << " ";
    }
    cout << endl;
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(NULL); cout.tie(NULL);
    cout<< setprecision(20)<< fixed;
    #ifdef LOCAL
        freopen("input.txt", "r", stdin);
    #else
        #define endl '\n'
    #endif
    
    add(0);
    add(1);
    add(2);
    add(3);
    add(4);
    add(5);
    
    print();

    add(20,1);

    print();

    remove(3);

    print();

    return 0;
}