package com.example.spring3resilliance4j

import io.github.resilience4j.ratelimiter.annotation.RateLimiter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/test")
    @RateLimiter(name = "hello_test", fallbackMethod = "fallback")
    fun test():String {
        return "hello me!!!"
    }
    fun fallback(ex: Throwable):String {
        return "Oops, blocked by rate limiter!"
    }

}