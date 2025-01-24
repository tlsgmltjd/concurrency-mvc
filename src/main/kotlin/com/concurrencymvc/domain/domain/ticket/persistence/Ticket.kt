package com.concurrencymvc.domain.domain.ticket.persistence

import jakarta.persistence.*

@Entity
@Table(name = "tbl_ticket")
class Ticket(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    var count: Int,
    @Column(name = "limit_count")
    val limitCount: Int
) {
    fun addCount() {
        if (count >= limitCount) {
            throw RuntimeException("Count has reached the limit!")
        }
        count++
    }
}
