f=open("watchlist.csv","r")
d={}
for line in f:
    row=line.strip().split(",")
    for movie in row:
        if movie in d:
            d[movie]+=1
        else:
            d[movie]=1
top3 = sorted(d.items(), key=lambda x: x[1], reverse=True)[:3]
print("Top 3 are :",top3)