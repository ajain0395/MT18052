#Ashish Jain MT18052
import os.path

def getDatawithlabels():
    while 1:
        #filename = raw_input("Enter file name with path: ")
        filename = "data/train.txt"
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
            #print line[0:len(line) -2]
            linetmp = line.split(',')
            #print linetmp [:-1]
            datapoint = map(float,linetmp [:-1])
            #print (len(datapoint))
            label  = (linetmp[-1:][0][0])
            datapoint.append(label)
            #print datapoint
            alldatapoints.append(datapoint)
    return alldatapoints

def getDatawithoutlabels():
    while 1:
        #filename = raw_input("Enter file name with path: ")
        filename = "data/train.txt"
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
            #print line[0:len(line) -2]
            linetmp = line.split(',')
            #print linetmp [:-1]
            datapoint = map(float,linetmp [:-1])
            '''label  = (linetmp[-1:][0][0])
            datapoint.append(label)
            #print datapoint'''
            alldatapoints.append(datapoint)
    return alldatapoints

def getDatatesting():
    while 1:
        #filename = raw_input("Enter file name with path: ")
        filename = "data/test.txt"
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
            #print line[0:len(line) -2]
            linetmp = line.split(',')
            #print linetmp [:-1]
            datapoint = map(float,linetmp)
            #print datapoint
            alldatapoints.append(datapoint)
    return alldatapoints
def writeOutput(result):
    filename = "output.txt"
    filepointer = open(filename, "w")
    for i in result:
        filepointer.write(i)
        filepointer.write("\n")

#data = getDatawithlabels()
#print "rows",len(data)
#print data[0]
#print data