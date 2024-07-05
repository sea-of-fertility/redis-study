# 프로젝트 소개
spring, redis의 공식 문서를 base로 공부한 프로젝트 입이다.

# 목적
accessToken를 redis로 구현할 정도의 기능을 학습한다.

# 학습 내용
1. [TTL](##TTL)
   1. [적용방법](###적용-방법)
   2. [적용](###적용)
2. [Secondary Indexes](##Secondary Indexes)


## 1. TTL(Time To Live)
### 적용 방법
+ TTL을 적용하는 방법으로는 4가지가 존재한다. 
1. @RedisHash(timeToLive=…)
2. [KeyspaceSettings](https://docs.spring.io/spring-data/redis/reference/redis/redis-repositories/keyspaces.html)
3. @TimeToLive annotation on a property 
4. @TimeToLive annotation on a method:

### 적용
가장 간단하게 사용하는 것으로 3번, 4번이 있다. 아래 코드는 4번을 적용한 코드이다.

[Hello](src/main/java/com/example/redisstudy/domain/Hello.java)의 TTL을 1초로 적용했다.
~~~ java
   @TimeToLive
    public long getTimeToLive() {
        return 1L;
    }
~~~

## 2. Secondary Indexes
### 2-1. Annotation driven indexing
Secondary Indexes로 사용하고 싶은 property에 적용한다.
~~~ java
@RedisHash("people")
public class Person {

  @Id 
  String id;
  @Indexed 
  String firstname;
  String lastname;
  Address address;
}
~~~
추가) [Address](src/main/java/com/example/redisstudy/domain/Address.java)와 같은 nested elements에서도 사용이 가능하다.



# 학습 자료 링크
+ [Spring Data Redis](https://docs.spring.io/spring-data/redis/reference/index.html)
+ [redis Quick starts](https://redis.io/docs/latest/develop/get-started/)





