# KotlinJpaInheritanceIssue
This project provides a demo application to prove the inheritance bug with spring boot 3/hibernate 6 and kotlin 1.7.22/1.8.10 (This Project uses kotlin 1.7.22)

The [Entities](src/main/kotlin/com/example/kotlinjpainheritanceissue/Entities.kt) Entity2 extends Entity1 and overrides a simple value (value1, value2)

After loading Entity2 via Entity2Repository the value2 value is always null but the value is somehow stored inside the extended class Entity1 as proven with the value1 getter implementation

The [Test](src/test/kotlin/com/example/kotlinjpainheritanceissue/KotlinJpaInheritanceIssueApplicationTests.kt) proves the issue

This behaviour is unexpected and should behave the same as in spring 2.7.x

