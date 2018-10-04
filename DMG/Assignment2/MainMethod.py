import ReadData
import RepresentativeClustering


alldatapoints = ReadData.getData()
print "Data Points Read ",alldatapoints

#@param (allDatapoints,clustersize,mode)
#mode 0 = Kmeans
#mode 1 = Kmedian
k = int(raw_input("Enter Clusters count: "))
print "K means"
list = RepresentativeClustering.getClusters(alldatapoints,k,0)
for i in range(0,len(list)):
    print "cluster",i+1,
    print list[i]
print "K median"
list = RepresentativeClustering.getClusters(alldatapoints,k,1)
for i in range(0,len(list)):
    print "cluster",i+1,
    print list[i]
#print list