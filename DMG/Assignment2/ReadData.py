import os.path
import Distancefunctions

def getData():
    '''
    while 1:
        filename = raw_input("Enter File Name with path")
        if os.path.isfile(filename) == 0:
            print "invalid file Name or Path re enter file name "
        else:
            break
    filepointer = open(filename, "r")
    '''
    filepointer = open("inputfile.txt", 'r')
    list1 = []
    list2 = []
    alldatapoints = []
    for line in filepointer:
            datapoint = map(int,line.split(','))
            alldatapoints.append(datapoint)
    return alldatapoints
#data = getData()
#print data