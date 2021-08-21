#include <stdio.h>

int main() {
    
    int length;
    
    char text[length]; 
    
    printf("Length: ");
    scanf("%d", &length);
    
    printf("Text: ");
    scanf("%s", &text);
    printf("");
    
    /*Give output*/
    /*printf("Sorted Word: ");*/
    
    /*Test*/
    printf("Length: ", "%d", &length, "\n");
    printf("%s","Text: ", text);
    
    return 0;
}
