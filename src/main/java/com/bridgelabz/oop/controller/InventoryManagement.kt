package com.bridgelabz.oop.controller

import com.bridgelabz.oop.model.InventoryDetails
import com.bridgelabz.oop.model.Pulses
import com.bridgelabz.oop.model.Rice
import com.bridgelabz.oop.model.Wheat
import com.bridgelabz.oop.repository.JsonUtil
import com.bridgelabz.oop.utility.Utility
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.io.IOException
import java.util.*
import kotlin.time.times


class InventoryManagement  {

    fun main(args: Array<String>) {
        var utility = Utility()
        var jsonUtil = JsonUtil()
        var name: String
        var weight: Int
        var price: Int
        var totalPriceOfWeight = 0
        var inventoryGrandTotal = 0
        println("!!!Add New Stock in the Inventory!!!")
        println("How much Inventory You want to add")
        val addInventory: Int = utility.integerInput()
        // Path Of json Files
        val path1 = "/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails.json"
        val path2 = "/home/admin94/Desktop/ObjectOrientedPrograms/Inventory Management/InventoryDetails2.json"
        var iDetails = InventoryDetails()
        val mapper = ObjectMapper()
        iDetails = mapper.readValue(File(path1), InventoryDetails::class.java)
        
        val riceList = ArrayList<Rice?>()
        val pulsesList = ArrayList<Pulses?>()
        val wheatList = ArrayList<Wheat?>()
//        iDetails.getRice()!![0].setTotalPriceOfWeightForRice(
//                iDetails.getRice()!![0].getWeightForRice() * iDetails.getRice()!![0].getTotalPriceOfWeightForRice())


        iDetails.getRice()!![0]?.totalPriceOfWeightOfRice(
                iDetails.getRice()!![0]?.totalPriceOfWeightOfRice?.times(iDetails.getRice()!![0]?.weightOfRice!!)
        )

        iDetails.getPulses()!![0]?.totalPriceOfWeightOfPulse(
                iDetails.getPulses()!![0]?.totalPriceOfWeightOfPulse?.times(iDetails.getPulses()!![0]?.weightOfPulse!!)
        )

        iDetails.getWheat()!![0]?.totalPriceOfWeightOfWheat(
                iDetails.getWheat()!![0]?.totalPriceOfWeightOfWheat?.times(iDetails.getWheat()!![0]?.weightOfWheat!!)
        )


        var riceSize = iDetails.getRice()!!.size
        var pulsesSize = iDetails.getPulses()!!.size
        var wheatSize = iDetails.getWheat()!!.size


        for (i in 0 until riceSize - 1) {
            inventoryGrandTotal += iDetails.getRice()!![riceSize - 1]?.totalPriceOfWeightOfRice ?:
            riceSize--
        }
        for (i in 0 until pulsesSize - 1) {
            inventoryGrandTotal += iDetails.getPulses()!![pulsesSize - 1]?.totalPriceOfWeightOfPulse ?:
            pulsesSize--
        }
        for (i in 0 until wheatSize - 1) {
            inventoryGrandTotal += iDetails.getWheat()!![wheatSize - 1]?.totalPriceOfWeightOfWheat ?:
            wheatSize--
        }
        riceList.addAll(iDetails.getRice()!!)
        pulsesList.addAll(iDetails.getPulses()!!)
        wheatList.addAll(iDetails.getWheat()!!)
        var choice: Int
        loop@ for (i in 0 until addInventory) {
            println("==Opearations to perform with the Inventory==")
            println("1) Rice")
            println("2) Pulses")
            println("3) Wheat")
            println("4) Exit")
            println("Enter Your choice")
            choice = utility.integerInput()
            when (choice) {
                1 -> {
                    val rice = Rice()
                    println("Enter the Rice Type")
                    name = utility.stringInput().toString()
                    println("Enter the Weight of Rice")
                    weight = utility.integerInput()
                    println("Enter the Price per kg of Rice")
                    price = utility.integerInput()
                    // calaculate total weight price
                    totalPriceOfWeight += weight * price
                    inventoryGrandTotal += totalPriceOfWeight
                    rice.nameOfRice = name
                    rice.weightOfRice(weight)
                    rice.priceOfRice(price)
                    rice.totalPriceOfWeightOfRice(totalPriceOfWeight)
                    riceList.add(rice)
                }
                2 -> {
                    val pulses = Pulses()

                    println("Enter the Pulse Type")
                    name = utility.stringInput().toString()
                    println("Enter the Weight of Pulse")
                    weight = utility.integerInput()
                    println("Enter the Price per kg of Pulse")
                    price = utility.integerInput()
                    // calaculate total weight price
                    totalPriceOfWeight += weight * price
                    inventoryGrandTotal += totalPriceOfWeight
                    pulses.nameOfPulse = name
                    pulses.weightOfPulse(weight)
                    pulses.priceOfPulse(price)
                    pulses.totalPriceOfWeightOfPulse(totalPriceOfWeight)
                    pulsesList.add(pulses)
                }
                3 -> {
                    val wheat = Wheat()
                    println("Enter the Wheat Type")
                    name = utility.stringInput().toString()
                    println("Enter the Weight of Wheat")
                    weight = utility.integerInput()
                    println("Enter the Price per kg of Wheat")
                    price = utility.integerInput()
                    // calaculate total weight price
                    totalPriceOfWeight += weight * price
                    inventoryGrandTotal += totalPriceOfWeight
                    wheat.nameOfWheat = name
                    wheat.weightOfWheat(weight)
                    wheat.priceOfWheat(price)
                    wheat.totalPriceOfWeightOfWheat(totalPriceOfWeight)
                    wheatList.add(wheat)
                }
                4 -> System.exit(0)
                else -> {
                    println("Invalid choice")
                    continue@loop
                }
            }
        }
        iDetails.setTotal(inventoryGrandTotal)
        iDetails.setRice(riceList)
        iDetails.setPulses(pulsesList)
        iDetails.setWheat(wheatList)
        println(jsonUtil.writeMapper(path2, iDetails))
        //System.out.println(JsonUtil.writeMapper(path2, iDetails));
        println("Inventory is added into new json File")
    }
}

private operator fun Int.invoke(times: Int?) {

}



