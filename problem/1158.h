#include<cstdio>
using namespace std;
class Node{
public :
	Node(){
		next = NULL;
	};
	Node(const Node& orig){
		next = orig.next;
	   value = orig.value;
	};
	Node *getNext(){
		return next;
	}
	void setNext(Node* newThing){
		if(newThing == NULL)
			next = NULL;
		else
			next = newThing;
	}
	Node *getPrev(){
		return prev;
	}
	void setPrev(Node* prevThing){
		if(prevThing == NULL)
			prev = NULL;
		else
			prev = prevThing;
	}

	int getValue(){
		return value;
	}
	void setValue(int val){
		value = val;
	}
private:
		Node* next;
		Node* prev;
		int value;
};
int main(){
	int n, m;
	scanf("%d %d",&n ,&m);
	Node* start = new Node();
	Node* bridge = start;
	start->setValue(1);
	for(int count = 2; count < n; count++){
		Node* n = new Node();
		n->setValue(count);
		n->setNext(NULL);
		n->setPrev(bridge);
		bridge->setNext(n);
		bridge = n;
	}
	Node* end = new Node();
	end->setValue(n);
	end->setNext(start);
	end->setPrev(bridge);
	bridge->setNext(end);
	start->setPrev(end);

	Node* pointer = start;
	int count = 1;
	printf("<");
	while(pointer!=NULL){
		if(count % m == 0){
			if(pointer->getPrev()->getValue() != pointer->getValue()){
				printf("%d, ",pointer->getValue());
				count = 0;
				pointer->getPrev()->setNext(pointer->getNext());
				pointer->getNext()->setPrev(pointer->getPrev());
			}else{
				printf("%d>",pointer->getValue());
				break;
			}
		}
		pointer = pointer->getNext();
		count++;
	}
}