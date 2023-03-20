package com.example.kotlinjpainheritanceissue

import jakarta.persistence.EntityManagerFactory
import org.hibernate.SessionFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HibernateImplementationTests {

    @Autowired
    lateinit var entityManaFactory: EntityManagerFactory

    @Test
    fun contextLoads() {
        val sessionFactory = entityManaFactory.unwrap(SessionFactory::class.java)
        val session = sessionFactory.openSession()
        session.beginTransaction()
        val entity2 = Entity2("value1Example", "value2Example")
        session.persist(entity2)
        session.transaction.commit()

        val result = session.get(Entity2::class.java, entity2.id)
        Assertions.assertEquals("value1Example", result.value1)
        Assertions.assertEquals("value2Example", result.value2)
    }
}
