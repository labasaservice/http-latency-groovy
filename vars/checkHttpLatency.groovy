import com.example.HttpLatencyChecker

def call(String url) {
    def checker = new HttpLatencyChecker()
    return checker.checkLatency(url)
}