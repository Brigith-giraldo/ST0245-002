#include <iostream>
#include <string>

using namespace std;
class Node{
  public:
    Node* left;
    Node* rigth;
    string nombre;
    string telefono;
    Node(string nombre, string telefono){
      this->nombre = nombre;
      this->telefono = telefono;
      this->left = NULL;
      this->rigth = NULL;
    }
};

class BinaryTree{
  public:
    Node* root;
    BinaryTree(){
      this->root = NULL;
    }
    ~BinaryTree(){}
    void insertar(string s,string telefono){
      Node* node = new Node(s,telefono);
      if (root == NULL){
        root = node;
      }else{
        Node* aux = root;
        while (true){
          if (s < aux->nombre){
            if (aux->left != NULL){
              aux = aux->left;
            }else{
              aux->left = node;
              break;
            }
          }else{
            if (aux->rigth != NULL ){
              aux = aux->rigth;
            }else{
              aux->rigth = node;
              break;
            }
          }
        }
      }
    }
    void imprimir(){
      cout << "digraph G {" << endl;
      imprimirAux(root);
      cout << "}" << endl;
    }
    void imprimirAux(Node *root){
       if (root != NULL) {
        if (root->left != NULL){
          cout <<"\"" << root->nombre << "\" -> " << "\"" << root->left->nombre<< "\"" << endl;;
        }
        if (root->rigth != NULL){
          cout << "\"" << root->nombre << "\" ->  " << "\"" << root->rigth->nombre  << "\"" << endl;
        }
        if (root->left != NULL){
          imprimirAux(root->left);
        }
        if (root->rigth != NULL){
          imprimirAux(root->rigth);
        }
      
      }

    }
    void buscar(string s){
      if (root == NULL){
        cout << "Arbol vacio" << endl;
      }else{
        Node* aux = root;
        while (true){
          if(s == aux->nombre){
            cout << s << " encontrado, su telefono es: " << aux->telefono << endl;
            break;
          }else if (s < aux->nombre){
            if (aux->left != NULL){
              aux = aux->left;
            }else{
              cout << s << " no encontrado" << endl;
              break;
            }
          }else{
            if (aux->rigth != NULL ){
              aux = aux->rigth;
            }else{
              cout << s << " no encontrado" << endl;
              break;
            }
          }
        }
      }
 
    }
};

int main(){
  BinaryTree *tree = new BinaryTree();
  tree->insertar("d","1");
  tree->insertar("a","2");
  tree->insertar("e","3");
  tree->insertar("b","4");
  tree->imprimir();
  tree->buscar("d");
  tree->buscar("a");
  tree->buscar("e");
  tree->buscar("b");
  tree->buscar("c");
  return 0;
}
