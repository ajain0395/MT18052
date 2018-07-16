all : myshell.exe
	
  
myshell.exe : myshell.o
	gcc myshell.o -o myshell.exe

myshell.o : myshell.c 
	gcc -c myshell.c

clean : 
	rm -rf myshell.o myshell.exe
