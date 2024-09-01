package com.example

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET

class HttpLatencyChecker {
    String checkLatency(String url) {
        def http = new HTTPBuilder(url)
        def startTime = System.currentTimeMillis()
        def latency = 0
        
        try {
            http.request(GET) { req ->
                response.success = { resp, reader ->
                    latency = System.currentTimeMillis() - startTime
                }
                response.failure = { resp ->
                    throw new Exception("Unexpected response status: ${resp.status}")
                }
            }
            return "Latency to $url: ${latency} ms"
        } catch (Exception e) {
            return "Error checking latency for $url: ${e.message}"
        }
    }
}