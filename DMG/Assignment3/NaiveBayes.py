'''
Ashish Jain
MT18052
Assignment 3
'''
import ReadData
import math
import random

'''
Linear Distribution
'''
def fx(x,u,sd):
    pi2 = 1.0/((math.sqrt(2.0 * math.pi)) * sd)
    enum = -((x - u) ** 2)
    eden = 2.0 * float(sd ** 2)
    result = float(pi2 * math.exp(enum/eden))
    return result

'''
classify test data
'''
def classiftNB(testData):
    global rlen
    global dlen
    global rMean
    global rStandardDeviation
    global dMean
    global dStandardDeviation
    for i in range(0,1):
        rval = 1.0
        dval = 1.0
        for j in range(0,len(testData)):
            rval *= (fx(testData[j], rMean[j], rStandardDeviation[j]))
            dval *= (fx(testData[j], dMean[j], dStandardDeviation[j]))
        rval *= rlen
        dval *= dlen
        if (rval > dval):
            return "R"
        else:
            return "D"

'''
Validation classification
'''
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
        rval *= rlen
        dval *= dlen
        if (rval > dval):
            if(testData[i][len(testData[i]) -1] in "R"):
                percent += 1.0
        else:
            if(testData[i][len(testData[i]) -1] in "D"):
                percent += 1.0
    return (percent/(len(testData))) * 100.0

'''
Calculate mean of feature
'''
def meancol(trainData,index):
    sum = 0.0
    for i in range (0,len(trainData)):
        sum += trainData[i][index]
    return float(sum/len(trainData))

'''
Calculate standard deviation of feature
'''
def standardDeviadioncol(trainData,index,mean):
    sum = 0.0
    for i in range (0,len(trainData)):
        sum += float(math.pow((trainData[i][index]  - mean),2))
    sum /= float(len(trainData))
    y = math.sqrt(sum)
    if y == 0.0:
        return 1.0
    else:
        return y

'''
Separate Training data as per label
'''
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

'''
Train Model according to datapoints passed
'''
def trainNB(trainData):
    rData = getclassR(trainData)
    dData = getclassD(trainData)
    global rlen
    global dlen
    global rMean
    global rStandardDeviation
    global dMean
    global dStandardDeviation
    rlen = float(len(rData))/((len(trainData)))
    dlen = float(len(dData))/((len(trainData)))
    rMean = []
    rStandardDeviation = []
    dMean = []
    dStandardDeviation = []
    for i in range(0,len(rData[0]) -1):
        rMean.append(meancol(rData,i))
        rStandardDeviation.append(standardDeviadioncol(rData,i,rMean[i]))
    for i in range(0,len(dData[0]) -1):
        dMean.append(meancol(dData,i))
        dStandardDeviation.append(standardDeviadioncol(dData,i,dMean[i]))

'''
Merge chunks for validation
'''
def mergelist(lisoflis, ommit):
    lis = []
    for i in range(0,len(lisoflis)):
        if i == ommit:
            continue
        for j in range(len(lisoflis[i])):
            lis.append(lisoflis[i][j])
    return lis

'''
Validation k fold
'''
def validation(allData,k):
    testSize = len(allData) / k
    random.shuffle(allData)
    global rlen
    global dlen
    avg = 0.0
    dataSegments = []
    index = 0
    for i in range(0, k):
        dataSegments.append([])
        for j in range(0, testSize):
            dataSegments[i].append(allData[index])
            index += 1
    for i in range(0, k):
        trainNB(mergelist(dataSegments, i))
        avg += valclassiftNB(dataSegments[i])
    print "Testing  Average: ",avg/k

'''
Read Data
'''
allData = ReadData.getDatawithlabels()
rMean = []
rStandardDeviation = []
dMean = []
dStandardDeviation = []

rlen = 0.0
dlen = 0.0
'''
Validation Start
'''
validation(allData,10)
'''
Validation End
'''
testData = ReadData.getDatatesting()
trainNB(allData)
res = []
'''
Classify Test Data Start
'''
for x in testData:
    res.append(classiftNB(x))
'''
Classify Test Data End
'''
rc = 0
dc = 0
for i in range(0,len(res)):
    if res[i] in "R":
        rc +=1
    else:
        dc +=1
print "R count: ",rc,"\tD count: ",dc
'''
Writing Result to File
'''
ReadData.writeOutput(res)


