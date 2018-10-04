import sys
import ReadData
import Distancefunctions
from random import shuffle

def displayDatapoints(allDatapoints):
    for i in range(0,len(allDatapoints)):
        print i+1, " ",allDatapoints[i]

def initialRepresentative(allDatapoints,k):
    #setup initial representatives
    representatives = []
    while True:
        choice = int(raw_input("Enter your choice for initial Representative selection\n1.Random from Datapoints\n2.Select from Datapoints"))
        if(choice == 1 or choice ==2):
            break;
        else:
            print "Invalid Choice"
    if(choice == 1):
        shuffle(allDatapoints)
        for i in range(0,k):
            representatives.append(allDatapoints[i])
    elif(choice == 2):
        while True:
            displayDatapoints(allDatapoints)
            x=raw_input("Enter ',' separated index of"+ str(k) +" data points: ")
            index = map(int,x.split(','))
            set_index = set(index)
            flag = False
            if(len(set_index) == k):
                for i in set_index:
                    if(i < 1 or i > len(allDatapoints)):
                        flag = True
            else:
                flag = True
            if(flag == False):
                for i in set_index:
                    representatives.append(allDatapoints[i - 1])
                break
            else:
                print "Invalid input index"
    print "Initial Seed Selected", representatives
    return representatives

def checkConvergence(first, second):
    for i in range(0,len(first)):
        for j in range(0,len(first[0])):
            if(first[i][j] != second [i][j]):
                return False
    return True


def getithrepresentative(list):
    ithrepresentative = []
    for col in range(0,len(list[0])):
        x = 0.0
        #print list[0]," + "
        for row in range(0,len(list)):
            x += list[row][col]
        ithrepresentative.append(float(x/len(list)))
    return ithrepresentative

def getnewRepresentative(clusterslist):
    representatives = []
    for i in range(0,len(clusterslist)):
        #print clusterslist[i],"cluster",i," level 2"

        representatives.append(getithrepresentative(clusterslist[i]))
    return representatives

def distance(X,Y,mode):
    dis = 0.0
    if mode == 0:
        dis = Distancefunctions.euclidean_dis(X,Y)
    elif mode == 1:
        dis = Distancefunctions.manhattan_dis(X,Y)
    return dis

def getClusters(allDatapoints,k,mode):
    S = initialRepresentative(allDatapoints,k)
    iter = 0
    while True:
        iter +=1
        clusterlist = []
        #dummylist = []
        for i in range(0, k):
            clusterlist.append([])
        for i in range(0,len(allDatapoints)):
            mindis = float(sys.maxint)
            index = 0
            for j in range(0,len(S)):
                dis = distance(allDatapoints[i],S[j],mode)
                '''if mode == 0:
                    dis = Distancefunctions.euclidean_dis(allDatapoints[i],S[j])
                elif mode == 1:
                    dis = Distancefunctions.manhattan_dis(allDatapoints[i],S[j])'''
                if (dis <= mindis):
                    index = j
                    mindis = dis
            #print S[index], allDatapoints[i],index,"list check 0 level"
            clusterlist[index].append(allDatapoints[i])
            #print clusterlist[index],"cluster check level 1\n"
        oldS = S
        S = getnewRepresentative(clusterlist)
        if (checkConvergence(oldS,S) == True):
            print "Iterations count: ",iter
            return clusterlist