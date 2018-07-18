#Name: Ashish Jain, Sarosh Hasan
#Roll No.: MT18052, MT18084
all : client server
  
client : client.o
	gcc client.o -o client

client.o : client.c 
	gcc -c client.c

server : server.o
	gcc server.o -o server

server.o : server.c 
	gcc -c server.c

clean : 
	rm -rf client.o server.o client server
