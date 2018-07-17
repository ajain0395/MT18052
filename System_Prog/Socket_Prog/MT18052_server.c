/*Ashish Jain MT180528*/
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

    while(1)
    {
        connfd = accept(listenfd, (struct sockaddr*)NULL, NULL); 
        readbytes=read(connfd, recvBuff, sizeof(recvBuff));
        recvBuff[readbytes] = 0;
        printf("\nAccepted a connection\n");
        printf("\nReceived Message : '%s' from Client\n",recvBuff);
        for(i = 0; i < readbytes - i - 1; i++)
        {
            tmp = recvBuff[i];
            recvBuff[i] = recvBuff[readbytes - i - 1];
            recvBuff[readbytes -i -1] = tmp;

        }
        snprintf(sendBuff, sizeof(sendBuff), "%s\n", recvBuff);
        write(connfd, sendBuff, strlen(sendBuff)); 

        close(connfd);
     }
}
