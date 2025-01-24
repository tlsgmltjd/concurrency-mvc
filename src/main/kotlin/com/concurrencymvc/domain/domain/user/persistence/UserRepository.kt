package com.concurrencymvc.domain.domain.user.persistence

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>