package com.concurrencymvc.domain.domain.ticket.persistence

import com.concurrencymvc.domain.domain.user.persistence.User
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "tbl_ticket_user")
class TicketUser(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,
    val createTime: LocalDateTime = LocalDateTime.now()
) {
    companion object {
        fun of(user: User): TicketUser {
            return TicketUser(user = user)
        }
    }
}
