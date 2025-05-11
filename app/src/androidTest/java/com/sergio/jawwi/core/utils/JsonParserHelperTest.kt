package com.sergio.jawwi.core.utils

import org.json.JSONException
import org.junit.Assert.assertEquals
import org.junit.Test

class JsonParserHelperTest {

    @Test
    fun testParseJsonStringWithSimpleObject() {
        val jsonStr = """
            {
                "name": "John",
                "age": 30,
                "isStudent": true
            }
        """.trimIndent()
        
        val result = JsonParserHelper.parseJsonString(jsonStr)

        assertEquals(3, result.size)
        
        assertEquals("John", result.get("name"))
        assertEquals(30, result["age"])
        assertEquals(true, result["isStudent"])
    }

    @Test
    fun  testParseJsonStringWithNestedObjects() {
        val jsonStr = """
            {
                "user": {
                    "name": "John",
                    "address": {
                        "city": "New York",
                        "zipCode": "10001"
                    }
                }
            }
        """.trimIndent()
        
        val result = JsonParserHelper.parseJsonString(jsonStr)
        
        val user = result["user"] as Map<*, *>
        val address = user["address"] as Map<*, *>
        
        assertEquals("John", user["name"])
        assertEquals("New York", address["city"])
        assertEquals("10001", address["zipCode"])
    }

    @Test
    fun testParseJsonStringWithArrays() {
        val jsonStr = """
            {
                "numbers": [1, 2, 3],
                "names": ["John", "Jane"],
                "mixed": [1, "two", true]
            }
        """.trimIndent()
        
        val result = JsonParserHelper.parseJsonString(jsonStr)
        
        val numbers = result["numbers"] as List<*>
        val names = result["names"] as List<*>
        val mixed = result["mixed"] as List<*>
        
        assertEquals(3, numbers.size)
        assertEquals(1, numbers[0])
        assertEquals(2, names.size)
        assertEquals("Jane", names[1])
        assertEquals(true, mixed[2])
    }

    @Test
    fun testParseJsonStringWithNestedArrays() {
        val jsonStr = """
            {
                "matrix": [
                    [1, 2],
                    [3, 4]
                ],
                "users": [
                    {"name": "John"},
                    {"name": "Jane"}
                ]
            }
        """.trimIndent()
        
        val result = JsonParserHelper.parseJsonString(jsonStr)
        
        val matrix = result["matrix"] as List<*>
        val users = result["users"] as List<*>
        
        assertEquals(2, matrix.size)
        assertEquals(2, (matrix[0] as List<*>).size)
        assertEquals(2, (matrix[0] as List<*>)[1])
        assertEquals("Jane", (users[1] as Map<*, *>)["name"])
    }

    @Test(expected = JSONException::class)
    fun testParseJsonStringWithInvalidJson() {
        val invalidJson = """
            {
                "name": "John",
                "age": 
            }
        """.trimIndent()
        
        JsonParserHelper.parseJsonString(invalidJson)
    }
}