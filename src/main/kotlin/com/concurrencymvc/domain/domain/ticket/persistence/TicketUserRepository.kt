package com.concurrencymvc.domain.domain.ticket.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface TicketUserRepository : JpaRepository<TicketUser, Long>