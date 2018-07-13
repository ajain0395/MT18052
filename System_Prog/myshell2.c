#include<stdio.h>
#include<string.h>
#include<unistd.h>


int main()
{
    int j = 0;
    int pid = 1;
        char command[80];
    char* arr[] = {"cd", "Documents", NULL};
    do
    {
        pid = fork();
        if(pid == 0)
        {
            char *commands[10];
            //char tmp[80];
        printf("@> ");
            char tmp[80] = "/bin/sh";
            char tmp2[80] = "-c";
            //            commands[0] = command;
            //          commands[1] = NULL;
            //            printf("ashish_0 %s\n",command);
            int i = 0;
        fgets(command, 80, stdin);
            commands[i++] = tmp;
            commands[i++] = tmp2;
            commands[i++] = command;
            commands[i++] = NULL;
//            char *token = strtok(command," \n");
            //strcpy(commands[i++], token);
            //           commands[i++] = tmp;
            /*
            commands[i++] = token;
            while(token != NULL)
            {
                //                printf("ashish_ %s\n",token);
                //   strcpy(commands[i++], token);
                token = strtok(NULL," \n");
                commands[i++] = token;
            }
            token = strtok(NULL," ");
//            strcat(tmp,commands[0]);
  //          commands[0] = tmp;
            for(j = 0; j < i; j++)
            {
                printf("ashish_ %s\n",commands[j]);
            }*/
            int ret_val = execv(commands[0],(commands));
            printf("execv Returned %d",ret_val);
                signal();
            if(ret_val != -1)
            {
            }
            //    execvp(arr[0],arr);
        }
        else
        {
            int status = 0;
            {
                wait(&status);
//                printf("child exit status%d", status);
            }
        }
   }while(strcmp(command,"exit") != 0);
    return 0;
}
