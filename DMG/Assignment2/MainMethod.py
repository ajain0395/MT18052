import ReadData
import RepresentativeClustering


alldatapoints = ReadData.getData()
print "Data Points Read ",alldatapoints

#@param (allDatapoints,clustersize,mode)
#mode 0 = Kmeans
#mode 1 = Kmedian
k = int(raw_input("Enter Clusters count: "))
if( k < 2 or k >len(alldatapoints)):
    print "Count should lie between 2 and ",len(alldatapoints)
    exit(0)
x = int(raw_input("Enter Algorithm to Run\n1.K Means\n2.K Medians\n: "))
if(x>2 or x<1 ):
    print "Invalid Algorithm Selected"
    exit(0)

list = RepresentativeClustering.getClusters(alldatapoints,k,x - 1)
for i in range(0,len(list)):
    print "cluster",i+1,
    print list[i]
#print list