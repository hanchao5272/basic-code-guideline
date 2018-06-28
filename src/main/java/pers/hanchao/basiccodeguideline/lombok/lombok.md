# lombok简笔

简单注解消除常用编码如setter、getter等方法的编写。

## @Setter @Getter

- 生成`setter`和`getter`方法
- 默认`setter`和`getter`都是`public`的，可以通过`AccessLevel.PRIVATE`进行指定。
- `final`字段不会生成`settr`方法

```java
@Setter
@Getter(AccessLevel.PRIVATE)
private String id;
```

## @NonNull

- 生成空值检查语句，类似如下

    ```java
    public void setId(@NonNull String id) {
        if (id == null) {
            throw new NullPointerException("id");
        } else {
            this.id = id;
        }
    }
    ```

- 影响`@RequiredArgsConstructor`的生成结果

```java
@NonNull
private String id;
```

## @ToString

- 生成`toString()`方法
- 通过`exclude`排除部分字段

```java
@ToString(exclude = {"id", "name"})
public class Person {
	//...
}
```

## @EqualsAndHashCode

- 生成`equals()`和`hashCode()`方法
- 通过`exclude`排除部分字段

```java
@EqualsAndHashCode(exclude = {"name","age"})
public class Person {
	//...
}
```

## @NoArgsConstructor

- 生成无参数构造函数

```Java
@NoArgsConstructor
public class Person {
	//...
}
```

## @AllArgsConstructor

- 生成全参数构造函数

```Java
@AllArgsConstructor
public class Person {
	//...
}
```

## @RequiredArgsConstructor

- 生成带部分参数的构造函数，参数的入选规则：用`@NonNull`注解的字段
```java
@RequiredArgsConstructor
public class Person {
	//...
}
```

## @Data

- 包含`@Setter`、`@Getter`

- 包含`@ToString`

- 包含`@EqualsAndHashCode`

- 包含`@RequiredArgsConstructor`

```java
@Data
public class Person {
	//...
}
```
## @Builder

- 生成构建器API

```java
@ToString
@Builder
public class Person {
	//...
}
```

```java
public static void main(String[] args) {
    Person person = Person.builder().id("11").name("David").age(12).build();
    System.out.println(person.toString());
}
```

```properties
Person(id=11, name=David, age=12)
```

