/*Ashish Jain MT18052*/
#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h> 

#define PORT 5555
int main(int argc, char *argv[])
{
    int sock = 0;
    struct sockaddr_in serv_addr; 
    char str[500];
    if(argc != 2)
    {
        printf("\n Usage: %s <Server IP address>\n",argv[0]);
        return -1;
    } 


    if((sock = socket(AF_INET, SOCK_STREAM, 0)) < 0)
    {
        printf("\n Socket creation error \n");
        return -1;
    } 

    memset(&serv_addr, '0', sizeof(serv_addr)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_port = htons(PORT); 

    if(inet_pton(AF_INET, argv[1], &serv_addr.sin_addr)<=0) //convert IPv4 and IPv6 addresses from text to binary form
    {
        printf("\nInvalid address/ Address not supported \n");
        return -1;
    } 

    if(connect(sock, (struct sockaddr *)&serv_addr, sizeof(serv_addr)) < 0)
    {
        printf("\nConnection Failed \n");
        return -1;
    } 
    char ex[10]="exit";
    while(1){
        /////////////////////////////////////////////////////////
        int readbytes = 0;
        char recvBuff[500];
        memset(recvBuff, '0',sizeof(recvBuff));//clearing buffer memory

        memset(str, '0', (sizeof(char) * 500)); 
        printf("\nClient: ");
        fgets(str,(sizeof(char) * 500), stdin); //message input from client
        send(sock , str , strlen(str) -1 , 0 );//sending message to server
        if(strcmp(str,"exit\n") == 0)
        {
            break;
        }

        ////////////////////////////////////////////////////////

        readbytes=read(sock, recvBuff, sizeof(recvBuff));//receiving message from server
        recvBuff[readbytes] = 0;
        printf("\nServer: %s\n",recvBuff);
        if(readbytes < 0)
        {
            printf("\n Read error \n");
        }

        if(strcmp(recvBuff,ex)==0)//if exit received from server terminate client
        {
            send(sock , ex , strlen(ex) , 0 );//sending exit to close connection from server side
            break;
        }
    }

    return 0;
}
