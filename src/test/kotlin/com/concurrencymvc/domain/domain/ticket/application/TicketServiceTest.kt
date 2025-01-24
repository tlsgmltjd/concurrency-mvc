package com.concurrencymvc.domain.domain.ticket.application

import com.concurrencymvc.domain.domain.ticket.persistence.TicketRepository
import com.concurrencymvc.domain.domain.ticket.persistence.TicketUserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.concurrent.Executors

@SpringBootTest
class TicketServiceTest @Autowired constructor(
 private val ticketService: TicketService,
 private val ticketRepository: TicketRepository,
 private val ticketUserRepository: TicketUserRepository
) {

 @Test
 fun testWithoutLock() {
  val threadCount = 300
  val executorService = Executors.newFixedThreadPool(threadCount)

  repeat(threadCount) {
   executorService.submit {
    ticketService.issueWithoutLock(1, 1)
   }
  }

  executorService.shutdown()
  while (!executorService.isTerminated) {
   Thread.sleep(100)
  }

  val ticketCount = ticketRepository.findById(1).get().count
  val ticketUserCount = ticketUserRepository.count()

  // 동시성 문제 발생
  // 기대: {result: count = 300, ticketUserCount = 300}
  // 실제: {result: count = 33, ticketUserCount = 300}
  println("result: count = $ticketCount, ticketUserCount = $ticketUserCount")
 }
}
