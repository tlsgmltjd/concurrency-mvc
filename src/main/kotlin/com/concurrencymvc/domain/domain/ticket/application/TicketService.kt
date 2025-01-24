package com.concurrencymvc.domain.domain.ticket.application

import com.concurrencymvc.domain.domain.ticket.persistence.TicketRepository
import com.concurrencymvc.domain.domain.ticket.persistence.TicketUser
import com.concurrencymvc.domain.domain.ticket.persistence.TicketUserRepository
import com.concurrencymvc.domain.domain.user.persistence.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TicketService(
    private val userRepository: UserRepository,
    private val ticketRepository: TicketRepository,
    private val ticketUserRepository: TicketUserRepository
) {

    @Transactional
    fun issue(userId: Long, ticketId: Long) {
        val user = userRepository.findById(userId)
            .orElseThrow { RuntimeException() }

        val ticket = ticketRepository.findById(ticketId)
            .orElseThrow { RuntimeException() }

        ticket.addCount()
        val ticketUser = TicketUser.of(user)

        ticketRepository.save(ticket)
        ticketUserRepository.save(ticketUser)
    }

}
