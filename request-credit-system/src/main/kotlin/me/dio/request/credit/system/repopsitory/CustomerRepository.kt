package me.dio.request.credit.system.repopsitory

import me.dio.request.credit.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository <Customer, Long>