#Ashish Jain
#MT18052
all : client server
  
client : MT18052_client.o
	gcc MT18052_client.o -o client

MT18052_client.o : MT18052_client.c 
	gcc -c MT18052_client.c

server : MT18052_server.o
	gcc MT18052_server.o -o server

MT18052_server.o : MT18052_server.c 
	gcc -c MT18052_server.c

clean : 
	rm -rf MT18052_client.o MT18052_server.o client server
