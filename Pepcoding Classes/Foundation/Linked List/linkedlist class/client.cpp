#include <iostream>
#include "linkedlist.h"
using namespace std;

int main()
{
    linkedlist ll;
    ll.addFirst(20);
    ll.addAt(0,10);
    ll.addLast(30);
    cout << ll.getLast()<<endl;
    ll.display();
    ll.addFirst(20);
    ll.addAt(0,10);
    ll.addLast(30);
    cout << ll.getFirst()<<endl;
    ll.display();
    return 0;
}