package com.concurrencymvc.domain.domain.user.persistence

import jakarta.persistence.*

@Entity
@Table(name = "tbl_user")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val password: String
)
