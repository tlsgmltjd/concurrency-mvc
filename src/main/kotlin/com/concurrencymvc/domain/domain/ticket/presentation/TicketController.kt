package com.concurrencymvc.domain.domain.ticket.presentation

import com.concurrencymvc.domain.domain.ticket.application.TicketService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ticket")
class TicketController(
    private val ticketService: TicketService
) {

    @PostMapping("/issue")
    fun issue(
        @RequestParam("userId") userId: Long,
        @RequestParam("ticketId") ticketId: Long
    ): ResponseEntity<Void> {
        ticketService.issueWithoutLock(userId, ticketId)
        return ResponseEntity.ok().build()
    }

}
