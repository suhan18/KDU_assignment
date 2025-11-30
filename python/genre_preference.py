l=[]
d={}
for i in range(10):
    genre=input("Enter your genre preference: ")
    l.append(genre)
s=set(l);
for i in l:
    if i in d:
        d[i]+=1
    else:
        d[i]=1;
print("List: ",l)
print("Set: ",s)
print("Dictionary: ",d)
    