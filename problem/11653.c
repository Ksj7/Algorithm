#include <stdio.h>
#include <stdlib.h>
//정수 N이 주어졌을 때, 소인수분해하는 프로그램을 작성하시오.
// 소인수 분해는 소수의 곱임.
static int a[10000001];
struct NODE{
    int data;
    struct NODE *next;
};

void savePrime(int i){
    int j, k;
    for(k = 2; k <= i;k++ ){
        for(j = 2; j < k; j++)
        {
            if(k % j == 0) {
                a[k] = 0;
                break;
            }
        }
        a[k] = 1;
    }
}
void findPrime(int i, struct NODE *answer){
    int j, k;
    
    for(j = 2; j <= i; j++){
        if(a[j] == 1){
            while(1){
                if(i % j != 0) break;
                i /= j;
                struct NODE *newNode = malloc(sizeof(struct NODE));
                newNode->data = j;
                newNode->next = NULL;
                answer->next = newNode;
                answer = answer->next;
            }
            if(i == 1) break;
        }
    }
}
int main(void) {
    int N;
    struct NODE *head = malloc(sizeof(struct NODE));
    struct NODE *answer = head;

    scanf("%d", &N);
    savePrime(N);
    findPrime(N, answer);
    for(head = head->next; head != NULL ; head = head->next){
        printf("%d\n", head->data);
    }
    return 0;
}
