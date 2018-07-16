/*Ashish Jain MT18052
Sarosh Hasan MT18084*/


#include<stdio.h>
#include<string.h>
#include<unistd.h>
#include <sys/wait.h>
#include<stdlib.h>

#define MAX_BUFFER 150
int main()
{
    int i = 0,
        j = 0,
        nbytes = 0,
        pid = 1,
        status,
        fd[2];
    char readbuffer[MAX_BUFFER] = "",
         *token = NULL,
         command[MAX_BUFFER] = "";
    do
    {
        pipe(fd);
        /*creates  a pipe, a unidirectional data channel that can be used
          for interprocess communication.*/

        pid = fork();//create a new child process
        if(pid == 0) // check if current process is child process
        {
            char *commands[10];
            printf("user@myshell> "); //to print my shell is executing
            char tmp[10] = "/bin/sh"; //first command to execute command
            char tmp2[5] = "-c"; // parameter
            fgets(command, MAX_BUFFER, stdin); // taking input command from user
            commands[i++] = tmp;
            commands[i++] = tmp2;
            commands[i++] = command;
            commands[i++] = NULL;
            if(strstr(command,"cd") || strstr(command,"exit")) // checking if command to be executed is cd or exit
            {
                close(fd[0]);//closing the read end of pipe
                write(fd[1], command, (strlen(command)+1)); // passing command if cd or exit to parent process
            }
            int ret_val = execv(commands[0],(commands)); // executing commands 
            exit(0); // exiting child process if invalid command received
        }
        else
        {
            close(fd[1]);//closing the write end of pipe
            nbytes = read(fd[0], readbuffer, sizeof(readbuffer)); // reading message from pipe received fom child process
            wait(&status); // waiting for child process to complete execution
            if(nbytes > 0)
            {
                token = strtok(readbuffer," \n"); // tokenize data received from child process to recognise the command exit or cd
                if(strcmp(token,"cd") == 0)
                {
                    token = strtok(NULL," \n");
                    if(token == NULL)
                    {
                        token = getenv("HOME");//if cd received without any path specified then move to user home directory
                    }
                    chdir(token); // changing path to path received from child process in second token or switch to $HOME
                }
                else if(strcmp(token,"exit") == 0)
                {
                    break; // exiting from infinite loop if exit received from child process
                }
            }
        }
    }while(strcmp(readbuffer,"exit") != 0);
    return 0;
}
