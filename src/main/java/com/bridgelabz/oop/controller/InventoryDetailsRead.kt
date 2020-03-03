package com.bridgelabz.oop.controller

import com.bridgelabz.oop.model.InventoryDetails
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import java.io.File

class InventoryDetailsRead {
    fun main(args : Array<String>) {
        var path1 : String = "/home/admin115/IdeaProjects/practice/src/Inventory.json"
        var path2 : String = "/home/admin115/IdeaProjects/practice/src/InventoryReader.json"
        val mapper = jacksonObjectMapper()

        var total = 0
        var iDetails = InventoryDetails()
        iDetails = mapper.readValue(File(path1), iDetails.javaClass)

        System.out.println("Rice " + (iDetails.getRice()?.get(0)?.nameOfRice))
        System.out.println("Price of Wheat" + (iDetails.getRice()?.get(0)?.priceOfRice ))
        total += iDetails.getRice()?.get(0)?.priceOfRice!!

        System.out.println("Pulses " + (iDetails.getPulses()?.get(0)?.nameOfPulse))
        System.out.println("Price of Pulses" + (iDetails.getPulses()?.get(0)?.priceOfPulse ))
        total += iDetails.getPulses()?.get(0)?.priceOfPulse!!


        System.out.println("Wheat " + (iDetails.getWheat()?.get(0)?.nameOfWheat  ))
        System.out.println("Price of Wheat"+ (iDetails.getWheat()?.get(0)?.priceOfWheat ))
        total += iDetails.getWheat()?.get(0)?.priceOfWheat!!

        println("Total Of all$total")
        iDetails.setTotal(total)
        mapper.writeValue(File(path2), iDetails)
        println("Writing into file completed")
    }
}