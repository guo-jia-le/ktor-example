package com.example

import io.ktor.http.*
import io.ktor.server.plugins.*
import io.ktor.server.routing.*
import io.ktor.server.html.*
import kotlinx.html.*
import kotlinx.css.*
import org.slf4j.event.*
import io.ktor.server.request.*
import io.ktor.serialization.gson.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import java.time.Duration
import io.ktor.server.application.*
import io.ktor.server.response.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}