#include <stdio.h>
#include<linux/kernel.h>
#include<sys/syscall.h>
#include<unistd.h>

int main()
{
    long long int amma = syscall(548);
    printf("Sys_hello %lld", amma);

    return 0;
}
