# Equals
```
public boolean equals(Object obj) {  
    return (this == obj);  
}  
```
 - Object里的是对两个对象的地址值进行的比较（is comparing the two objects's address value (equal address)）
 - String, Math, Integer, Double这些primitive type是比较value
 

# Hashcode
 - 求hashcode的值，hashtable用
 - equal的object的hashcode必然相同 
 - 所以重写equals的话也考虑重写hashcode
 - hashcode可能撞车但是概率极小
 - 注意object里面的hashcode是native方法（由非java语言实现）
