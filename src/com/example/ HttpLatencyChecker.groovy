package com.example

class HttpLatencyChecker {
    String checkLatency(String urlString) {
        URL url = new URL(urlString)
        HttpURLConnection connection = null
        long startTime = System.currentTimeMillis()
        long endTime
        
        try {
            connection = (HttpURLConnection) url.openConnection()
            connection.setRequestMethod("GET")
            connection.connect()
            
            int responseCode = connection.getResponseCode()
            endTime = System.currentTimeMillis()
            
            long latency = endTime - startTime
            return "Latency to $urlString: ${latency} ms (Response Code: $responseCode)"
        } catch (Exception e) {
            return "Error checking latency for $urlString: ${e.message}"
        } finally {
            if (connection != null) {
                connection.disconnect()
            }
        }
    }
}