## 领域模型

- 定义“系统能够做什么”这样的功能需求，重在解决沟通误解的问题
- 它关注项目中所有概念的“准确性”，需要建立描述问题领域的通用词汇表，来消除和增强概念的准确性。
- 词汇表会随着项目的进展，不断地完善和更新。



## 步骤

1. 找出领域类

   重要名词

   CityClock | UtcTime | PhoneClock | HotelEmployee

2. 领域模型类图

   Clock

   ```json
   @startuml
   HotelEmployee -> Clock
   Clock o-- UtcTime
   Clock o-- CityClock
   Clock o-- PhoneClock
   @enduml
   ```

   ![DomainClassUML](/Users/kingdomdong/Projects_Idea/java/kick-out-code-smell/doc/DomainClassUML.svg)








![Alt text](https://g.gravizo.com/svg?
  digraph G {
    aize ="4,4";
    main [shape=box];
    main -> parse [weight=8];
    parse -> execute;
    main -> init [style=dotted];
    main -> cleanup;
    execute -> { make_string; printf}
    init -> make_string;
    edge [color=red];
    main -> printf [style=bold,label="100 times"];
    make_string [label="make a string"];
    node [shape=box,style=filled,color=".7 .3 1.0"];
    execute -> compare;
  }
)

<img src='https://g.gravizo.com/svg?

@startuml
HotelEmployee -> Clock
Clock o-- UtcTime
Clock o-- CityClock
Clock o-- PhoneClock
@enduml

'>



