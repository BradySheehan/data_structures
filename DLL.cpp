//
// DLL.cpp 
// 
// Written by Brady Sheehan
// Implementation of a doubly linked list
//

//#include "stdafx.h"
#include <iostream>
using namespace std;
template <class T>
class DLLNode {
public:
	T info;
	DLLNode<T> *prev, *next;
	DLLNode() {
		prev = next = 0;
	}
	DLLNode(T t, DLLNode<T> *n = 0, DLLNode<T> *p = 0) {
		info = t;
		next = n;
		prev = p;
	}
};

template <class T>
class DLL {
protected:
	DLLNode<T> *head, *tail;
public:
	DLL() {
		head = tail = 0;
	}
	void insertAtHead(T t) {
		head = new DLLNode<T>(t, head);
		if (head->next == 0)
			tail = head;
		else head->next->prev = head;
	}
	void insertAtTail(T t){ //written by me! :)
		if (tail != 0){
			tail = new DLLNode<T>(t, 0, tail);
			tail->prev->next = tail;
		}
		else
			head = tail = new DLLNode<T>(t);
	}
	T deleteFromTail() {
		if (head == 0)		// if list is empty;
			return 0;
		T t = tail->info;
		if (tail->prev == 0) {	// if there is only one node on the list;
			delete tail;
			tail = head = 0;
		}
		else {
			tail = tail->prev;
			delete tail->next;
			tail->next = 0;
		}
		return t;
	}
	bool isEmpty() {
		return head == 0;
	}
	
	template<class G>
	friend ostream& operator<<(ostream& out, DLL<G> dll);
};

template<class T>
ostream& operator<<(ostream& out, DLL<T> dll) {
	for (DLLNode<T> *p = dll.head; p != 0; p = p->next)
		out << p->info << ' ';
	return out;
}


int main()
{
	DLL<int> dll;
	dll.insertAtTail(10);
	dll.insertAtHead(5);
	cout << dll << endl;
	dll.insertAtTail(6);
	cout << dll << endl;
	cout << dll.deleteFromTail() << endl;
	cout << dll << endl;
	return 0;
}

