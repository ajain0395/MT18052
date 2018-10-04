import math


#Euclidean distance function
def euclidean_dis(a,b):
    x = 0.0
    for i in range(0,len(a)):
        x += math.pow(a[i] - b[i],2)
    return math.sqrt(x)

#Manhattan distance function
def manhattan_dis(a,b):
    x = 0
    for i in range(0,len(a)):
        x += math.fabs(a[i]-b[i])
    return x