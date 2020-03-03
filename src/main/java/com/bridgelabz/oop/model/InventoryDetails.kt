package com.bridgelabz.oop.model

class InventoryDetails {
    private var rice: List<Rice?>? = null
    private var wheat: List<Wheat?>? = null
    private var pulses: List<Pulses?>? = null

    private var total = 0

    fun getRice(): List<Rice?>? {
        return rice
    }

    fun setRice(rice: List<Rice?>?) {
        this.rice = rice
    }

    fun getWheat(): List<Wheat?>? {
        return wheat
    }

    fun setWheat(wheat: List<Wheat?>?) {
        this.wheat = wheat
    }

    fun getPulses(): List<Pulses?>? {
        return pulses
    }

    fun setPulses(pulses: List<Pulses?>?) {
        this.pulses = pulses
    }

    fun getTotal(): Int {
        return total
    }

    fun setTotal(total: Int) {
        this.total = total
    }

    override fun toString(): String {
        return "InventoryDetails(rice=$rice, wheat=$wheat, pulses=$pulses, total=$total)"
    }

}