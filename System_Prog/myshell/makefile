 ######################################################################
 #  FILENAME : interface.c
 #
 #  DESCRIPTION : main
 #
 #  INPUT : 
 #  
 #  OUTPUT :
 #
 #  AUTHOR : Ashish Jain
 #  
 #  EMPLOYEE CODE : 50388
 #  
 #  DATE : 30-12-2017
 #
 #
 # #####################################################################/



BIN =../bin
LIB =../lib
SRC =../src
OBJ =../obj
MAKE =../make
INC =../inc

CC = gcc
CFLAGS = -Wall -g -c
IFLAGS = -I$(INC)
LFLAGS = -L$(LIB)

all : myshell.exe
	
  
myshell.exe : myshell.o
	gcc myshell.o -o myshell.exe

myshell.o : myshell.c 
	gcc -c myshell.c

clean : 
	rm -rf myshell.o myshell.exe
 	 	 

