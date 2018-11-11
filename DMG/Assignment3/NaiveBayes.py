import ReadData
import math
import random

def fx(x,u,sd):
    pi2 = 1.0/((math.sqrt(2.0 * math.pi)) * sd)
    enum = 0 - math.pow(( x - u),2)
    eden = 2 * math.pow(sd,2)
    result = pi2 * math.exp(enum/eden)
    return result

def classiftNB(testData):
    global rlen,dlen
    global rMean
    global rStandardDeviation
    global dMean
    global dStandardDeviation
    labels = []
    for i in range(0,len(testData)):
        rval = 1.0
        dval = 1.0
        for j in range(0,len(testData[i]) -1):
            rval *= (fx(testData[i][j], rMean[j], rStandardDeviation[j]))
            dval *= (fx(testData[i][j], dMean[j], dStandardDeviation[j]))

        rval *= (rlen / (rlen + dlen))
        dval *= (dlen / (dlen + rlen))
        print "hello ",rval,"\t",dval
        if (rval > dval):
            labels.append("R")
        else:
            labels.append("D")
    return labels

def valclassiftNB(testData):
    global rlen
    global dlen
    global rMean
    global rStandardDeviation
    global dMean
    global dStandardDeviation
    percent = 0.0
    for i in range(0,len(testData)):
        rval = 1.0
        dval = 1.0
        for j in range(0,len(testData[i]) -1):
            rval *= (fx(testData[i][j], rMean[j], rStandardDeviation[j]))
            dval *= (fx(testData[i][j], dMean[j], dStandardDeviation[j]))
        #print testData[i][len(testData[i]) -1],"\t",
        #print rval,"\t",dval
        #print "hello ",rval,"\t",dval
        rval *= (rlen/(rlen + dlen))
        dval *= (dlen/(dlen + rlen))
        #print "hello ",rval,"\t",dval,"\t",rlen,"\t",dlen
        print
        if (rval > dval):
            if(testData[i][len(testData[i]) -1] == "R"):
                percent += 1.0
        else:
            if(testData[i][len(testData[i]) -1] == "D"):
                percent += 1.0
    #print percent
    print (percent/(len(testData))) * 100.0

def meancol(trainData,index):
    sum = 0.0
    for i in range (0,len(trainData)):
        sum += trainData[i][index]
    return sum/len(trainData)

def standardDeviadioncol(trainData,index,mean):
    sum = 0.0
    for i in range (0,len(trainData)):
        sum += math.pow((trainData[i][index]  - mean),2)
    sum /= len(trainData)
    #print len(trainData)
    y = math.sqrt(sum)
    if y == 0:
        return 1.0
    return y

def getclassD(allData):
    Ddatatmp = []
    for i in range( 0 , len(allData)):
        if (allData[i][len(allData[i]) -1] == 'D'):
            Ddatatmp.append(allData[i])
    return Ddatatmp

def getclassR(allData):
    Rdatatmp = []
    for i in range( 0 , len(allData)):
        if (allData[i][len(allData[i]) -1] == 'R'):
            Rdatatmp.append(allData[i])
    return Rdatatmp


def trainNB(trainData):
    rData = getclassR(trainData)
    dData = getclassD(trainData)
    global rlen
    global dlen
    global rMean
    global rStandardDeviation
    global dMean
    global dStandardDeviation
    rlen = float(len(rData))
    dlen = float(len(dData))
    print rlen,"\t",dlen
    rMean = []
    rStandardDeviation = []
    dMean = []
    dStandardDeviation = []
    for i in range(0,len(rData[0]) -1):
        rMean.append(meancol(rData,i))
        rStandardDeviation.append(standardDeviadioncol(rData,i,rMean[i]))
    for i in range(0,len(dData[0]) -1 ):
        dMean.append(meancol(dData,i))
        dStandardDeviation.append(standardDeviadioncol(dData,i,dMean[i]))
    #print rMean

def mergelist(lisoflis, ommit):
    lis = []
    print ommit + 1
    for i in range(0,len(lisoflis)):
        if i == ommit:
            continue
        for j in range(len(lisoflis[i])):
            lis.append(lisoflis[i][j])
    #print lis,"\n\n\n"
    #print len(lis)
    return lis

def validation(allData,k):
    testSize = len(allData) / k
    random.shuffle(allData)
    global rlen
    global dlen
    dataSegments = []
    index = 0
    for i in range(0, k):
        dataSegments.append([])
        for j in range(0, testSize):
            dataSegments[i].append(allData[index])
            index += 1
    # print dataSegments
    for i in range(0, k):
        trainNB(mergelist(dataSegments, i))
        #print rMean
        valclassiftNB(dataSegments[i])

allData = ReadData.getDatawithlabels()


rMean = []
rStandardDeviation = []
dMean = []
dStandardDeviation = []
rlen = 0.0
dlen = 0.0
validation(allData,10)

testData = ReadData.getDatatesting()
#print testData
trainNB(allData)
res = classiftNB(testData)
rc = 0
dc = 0
for i in range(0,len(res)):
    #print res[i]
    if res[i] == "R":
        rc +=1
    else:
        dc +=1
print "R count: ",rc,"\tD count: ",dc
#print len(testData[0])
ReadData.writeOutput(res)
'''print 'size of r',len(rData)
print 'size of d',len(dData)'''

'''print rMean
print rStandardDeviation
print '\n',dMean
print  dStandardDeviation'''

