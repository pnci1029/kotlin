`코틀린의 Collection`

- ![img_1.png](img_1.png)

```
    자바의 경우 String, list, array의 내장 함수들이 다르다.
    그래서 혼합하여 사용할 경우 형변환이 자주 일어난다.
    
    그러나 코틀린은 Collection(Array, Sequence, Map, Set, List)이 
    Iterator를 상속받고 있기 때문에 함수들이 통일되어있다.
```

<br />
<br />

`코틀린의 Annotation`
```
    사용하자는 입장
        - 컴파일시 동작하지만 클래스나 함수에 영향을 주지 않는다
        - 주석이나 문서를 만들 수 있지만 그것은 아무도 보지않는다..
        
    회의적인 입장
        - 위 장점들은 이해하나 어노테이션을 외우고 있는 상황에서만 사용이 가능하다
            ex) controller autowired 모르면 사용 불가능...
```