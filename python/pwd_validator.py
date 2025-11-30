pwd=input("Enter your password:")
confirmation=input("Enter your password again to confirm:")
print("Length 1: ",len(pwd))
print("Length 2: ",len(confirmation))
if(len(pwd)==len(confirmation)):
    print("Lengths match: True")
if(pwd==confirmation):
    print("Strings match: True")

