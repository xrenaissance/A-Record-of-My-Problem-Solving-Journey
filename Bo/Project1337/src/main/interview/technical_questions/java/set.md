# Set
 - 不允许包含想同元素的集合（add => false)
 - 用equals判断相同

# HashSet
 - 无序，用hashcode决定存储位置
 - 用equals和hashcode判断相同

# LinkedHashSet
 - 用hashcode决定存储位置，但是用linked list维护插入顺序：iterate的时候会以插入顺序访问
 - iterate性能比HashSet好，插入性能比HashSet稍差

# TreeSet
 - SortedSet接口的唯一implementation。
 - 给元素进行了排序：自然排序（默认）和定制排序（comparator / comparable）
 - 用equals或者compareTo实现比较

 