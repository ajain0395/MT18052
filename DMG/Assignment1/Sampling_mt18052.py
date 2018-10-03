import random

SAMPLE_S = 5
C = 0
finalSample = []

def display(head,array):
    for i in range(0,len(head)):
        print head[i] + "\t",
    print "\n",
    for i in range(0,len(array[0])):
        for j in range (0,len(array)):
            print str(array[j][i]) +"\t" ,
        print "\n",

def main2():
    allCounts = []
    all = []
    head = []
    #list for final printing
    all.append(["I1", "I2", "I3", "I4", "I5", "I6", "I7", "I8", "I9","I10", "I11", "I12", "I13", "I14", "I15", "I16", "I17", "I18", "I19", "I20"])
    global finalSample
    global C
    head.append(" ")
    #Loop for different iterations variations
    for j in range(0,4):
        count = [0] * 20
        #input count of iteration for jth variation
        print("Enter iterations Count:"),
        k = int(raw_input())
        head.append("N=" + str(k))
        for i in range (0,k):
            inputStream()
            for string in finalSample:
                count[int(string) - 1] +=1;
            finalSample = []
            C = 0
        allCounts.append(count)
        all.append(count)
    display(head,all)

#to create a sample of size 20 by calling getNextStream(20)
def inputStream():
		arr = getNextStream(20);
		for i in range(0,len(arr)):
			updateSample(arr[i], (i + 1))

def updateSample(streamItem,itemNumber):
    global C
    global finalSample
    if (itemNumber <= SAMPLE_S):
        if (C < SAMPLE_S):
            finalSample.append(streamItem)
            C += 1
    else:
        probInclude = float(SAMPLE_S) / float(itemNumber)
        pos=random.uniform(0,1)
        if(probInclude-pos>=0):
            posRemove = random.randint(0, len(finalSample) - 1)
            del finalSample[posRemove]
            finalSample.append(streamItem)

def getNextStream(n):
    # array of tweets assumed
    stream = ["1", "2", "3", "4", "5", "6", "7", "8", "9","10", "11", "12", "13", "14", "15", "16", "17", "18", "19","20"]
    # array storing random permutation of original array
    arr =[]

    # random permutation logic
    for i in range(0,n):
        position = random.randint(0,len(stream) - 1 )
        arr.append(stream[position])
        #print len(stream)
        stream.remove(stream[position]);
    return arr
main2()
