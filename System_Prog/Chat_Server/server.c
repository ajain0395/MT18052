/*Ashish Jain MT18052
  Sarosh Hasan MT18084*/
#include <stdio.h>
#include <sys/socket.h>
#include <sys/types.h>
#include <netinet/in.h>
#include <netdb.h>
#include <string.h>
#include <stdlib.h>
#include <unistd.h>
#include <arpa/inet.h> 
#include <time.h> 

#define PORT 5555

int main(int argc, char *argv[])
{
    int listenfd = 0, connfd = 0;
    int i = 0;
    struct sockaddr_in serv_addr; 

    char sendBuff[500];

    listenfd = socket(AF_INET, SOCK_STREAM, 0);
    memset(&serv_addr, '0', sizeof(serv_addr)); 
    memset(sendBuff, '0', sizeof(sendBuff)); 

    serv_addr.sin_family = AF_INET;
    serv_addr.sin_addr.s_addr = htonl(INADDR_ANY);
    serv_addr.sin_port = htons(PORT); 

    bind(listenfd, (struct sockaddr*)&serv_addr, sizeof(serv_addr)); 

    listen(listenfd, 5); 
    printf("\nServer listening for connections!\n");

    time_t t_seconds;
    int readbytes = 0;
    char recvBuff[500];
    char tmp;
    memset(recvBuff, '0',sizeof(recvBuff));

    int pid;
    while(1)
    {
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 
        printf("\nAccepted a connection from %d\n",connfd);
        pid = fork();//creating a new child process when a new client connection request received
        if(pid == 0)//if child process then exit from while loop for communication
        {
            break;
        }//parent will still wait for other clients connection
    }
    if(pid == 0)//if child process communicate with client
    {
        do
        {
            if((readbytes=read(connfd, recvBuff, sizeof(recvBuff)))> 0)//receiving message from client
            {
                recvBuff[readbytes] = '\0';
                printf("\nReceived Message: '%s' of length:[%d] from Client:[%d]\n",recvBuff, (int)strlen(recvBuff),connfd);
            }

            if(strcmp(recvBuff, "exit") == 0)//if client sends connection termination message
            {
                strcpy(sendBuff,"exit");
                write(connfd, sendBuff, strlen(sendBuff));//send exit to client for confirmation
                printf("\nClosing connection with client[%d]",connfd);
                printf("\nServer is still listening for connections!\n");
                break;
            }
            printf("\n Enter Message to be send to Client[%d]:",connfd);
            fgets(sendBuff,500,stdin);//message input from server
            write(connfd, sendBuff, strlen(sendBuff) -1 );//sending message to client 
        }while(1);
        close(connfd);//closing client connection
        exit(0);//exit child process
    }
}
