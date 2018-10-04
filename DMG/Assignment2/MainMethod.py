import ReadData
import RepresentativeClustering
alldatapoints = ReadData.getData()
print alldatapoints

#@param (allDatapoints,clustersize,mode)
#mode 0 = Kmeans
#mode 1 = Kmedian
print "K means"
list = RepresentativeClustering.getClusters(alldatapoints,2,0)
for i in range(0,len(list)):
    print "cluster",i+1,
    print list[i]
print "K median"
list = RepresentativeClustering.getClusters(alldatapoints,2,1)
for i in range(0,len(list)):
    print "cluster",i+1,
    print list[i]
#print list