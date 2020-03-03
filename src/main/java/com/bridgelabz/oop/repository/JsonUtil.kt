package com.bridgelabz.oop.repository

import com.fasterxml.jackson.core.JsonGenerationException
import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.io.IOException


class JsonUtil {
        private var mapper: ObjectMapper? = null
        @Throws(JsonParseException::class, JsonMappingException::class, IOException::class)
        fun readMapper(path: String?, `object`: Any): Any {
            mapper!!.readValue(File(path), `object`.javaClass)
            return "Successfully reading from the file!!!"
        }

        @Throws(JsonGenerationException::class, JsonMappingException::class, IOException::class)
        fun writeMapper(path: String?, `object`: Any?): String {
            mapper!!.writeValue(File(path), `object`)
            return "Successfully writing into the file!!!"
        }

        init {
            mapper = ObjectMapper()
        }
}