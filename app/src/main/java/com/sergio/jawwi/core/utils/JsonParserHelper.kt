package com.sergio.jawwi.core.utils

import org.json.JSONArray
import org.json.JSONObject

/**
 * A utility object for parsing JSON strings into Kotlin data structures.
 * 
 * This helper converts JSON objects and arrays into maps and lists, respectively,
 * while handling nested structures and null values.
 */
object JsonParserHelper {

    /**
     * Parses a JSON string into a [Map] representation.
     *
     * @param jsonStr The JSON string to parse.
     * @return A [Map] containing the parsed JSON data.
     */
    fun parseJsonString(jsonStr: String): Map<String, Any?> {
        val json = JSONObject(jsonStr)
        return parseJsonObject(json)
    }

    /**
     * Parses a [JSONObject] into a [Map].
     *
     * @param jsonObject The [JSONObject] to parse.
     * @return A [Map] containing the parsed JSON object data.
     */
    private fun parseJsonObject(jsonObject: JSONObject): Map<String, Any?> {
        val map = mutableMapOf<String, Any?>()
        val keys = jsonObject.keys()
        while (keys.hasNext()) {
            val key = keys.next()
            val value = jsonObject.get(key)
            map[key] = parseJsonValue(value)
        }
        return map
    }

    /**
     * Parses a JSON value into its corresponding Kotlin representation.
     *
     * - If the value is a [JSONObject], it is converted to a [Map].
     * - If the value is a [JSONArray], it is converted to a [List].
     * - If the value is `JSONObject.NULL`, it is converted to `null`.
     * - Otherwise, the value is returned as is.
     *
     * @param value The JSON value to parse.
     * @return The parsed value as a Kotlin object.
     */
    private fun parseJsonValue(value: Any?): Any? {
        return when (value) {
            is JSONObject -> parseJsonObject(value)
            is JSONArray -> parseJsonArray(value)
            JSONObject.NULL -> null
            else -> value
        }
    }

    /**
     * Parses a [JSONArray] into a [List].
     *
     * @param jsonArray The [JSONArray] to parse.
     * @return A [List] containing the parsed JSON array data.
     */
    private fun parseJsonArray(jsonArray: JSONArray): List<Any?> {
        val list = mutableListOf<Any?>()
        for (i in 0 until jsonArray.length()) {
            list.add(parseJsonValue(jsonArray.get(i)))
        }
        return list
    }
}
