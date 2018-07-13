#include<stdio.h>
#include<string.h>
#include<unistd.h>


int main()
{
    int j = 0;
    char* arr[] = {"cd", "Documents", NULL};
    while(1)
    {
        int pid = fork();
        if(pid == 0)
        {
            char command[80];
            char *commands[10];
            //char tmp[80];
            printf("\n");
            char tmp[80] = "/bin/";
            printf("@> ");
            fgets(command, 80, stdin);
            //            commands[0] = command;
            //          commands[1] = NULL;
            //            printf("ashish_0 %s\n",command);
            char *token = strtok(command," \n");
            int i = 0;
            //strcpy(commands[i++], token);
            //           commands[i++] = tmp;
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
            for(j = i; j < i; j++)
            {
                printf("ashish_ %s\n",commands[j]);
            }
            int ret_val = execvp(commands[0],(commands));
            printf("execv Returned %d",ret_val);
            if(ret_val != -1)
            {
                signal();
            }
                _exit(0);
            //    execvp(arr[0],arr);
        }
        else
        {
            int status = 0;
            {
                wait(&status);
                printf("child exit status%d", status);
            }
        }
    }
    return 0;
}
