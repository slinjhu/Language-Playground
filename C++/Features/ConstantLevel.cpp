#include<iostream>
using namespace std;

int main(){
  int number1 = 1, number2 = 2;
  const int & r1 = number1; // A reference to const int
  //r1 = 3; // ERROR: the referenced value can NOT be modified.

  cout << r1 << endl;

  
}
