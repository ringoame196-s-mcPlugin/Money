package com.github.ringoame196_s_mcPlugin

import java.util.UUID

class Account(val uuid: UUID, val name: String?) {
    var balance = MoneyManager.loadBalance(this)
        private set

    fun add(amount: Int) {
        balance += amount
        MoneyManager.saveBalance(this)
    }

    fun remove(amount: Int) {
        if (balance < amount) return
        balance -= amount
        MoneyManager.saveBalance(this)
    }

    fun getLog() {
    }
}
