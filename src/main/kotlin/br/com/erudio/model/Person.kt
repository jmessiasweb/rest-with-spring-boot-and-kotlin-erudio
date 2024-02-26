package br.com.erudio.model

import org.springframework.boot.autoconfigure.domain.EntityScan
import javax.persistence.*


@Table(name = "person_table")
data class Person(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @Column(name = "first_name", nullable = false, length = 80)
    var firtName: String,

    @Column(name = "last_name", nullable = false, length = 80)
    var lastName: String,

    @Column(nullable = false, length = 100)
    var addres: String,

    @Column(nullable = false, length = 6)
    var gender: String
)

