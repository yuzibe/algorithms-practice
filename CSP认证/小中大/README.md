## Java 的坑

Java 的格式化输出不如 C 灵活, 格式化输出比较死板, 如果当你想判断整形原封不动输出, 而小数形保留输出, 则可以使用以下 cipher. 

```java
// cipher
if(mid == (int) mid){
    midStr = String.format("%.0f",mid);
}else{
    midStr = String.format("%.1f",mid);
}
```

而 Java 中的 String 格式化输出会为你自动四舍五入. 如果不需要四舍五入, 可以采用下面的方式. 

```java
// cipher
if (mid == (int) mid) {
    midStr = String.valueOf(mid).substring(0, String.valueOf(mid).indexOf("."));
} else {
    midStr = String.valueOf(mid).substring(0, String.valueOf(mid).indexOf(".") + 2);
}
```
这种比较方式比较巧妙. 