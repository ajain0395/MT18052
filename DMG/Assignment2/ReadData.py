#Ashish Jain MT18052
import os.path

def getData():
    while 1:
        filename = raw_input("Enter file name with path: ")
        if os.path.isfile(filename) == 0:
            print "invalid file Name or Path re enter file name "
        else:
            break
    filepointer = open(filename, "r")
    #filepointer = open("input1.txt", 'r')
    list1 = []
    list2 = []
    alldatapoints = []
    for line in filepointer:
            datapoint = map(float,line.split(','))
            alldatapoints.append(datapoint)
    return alldatapoints
#data = getData()
#print data