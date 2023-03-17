package com.example.kotlinjpainheritanceissue

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KotlinJpaInheritanceIssueApplicationTests {

    @Autowired
    lateinit var entity2Repository: Entity2Repository

    @Test
    fun contextLoads() {
        entity2Repository.save(Entity2("value1Example", "value2Example"))

        val result = entity2Repository.findAll().first()

        Assertions.assertEquals("value1Example", result.value1)
        Assertions.assertEquals(null, result.value2)
    }
}
