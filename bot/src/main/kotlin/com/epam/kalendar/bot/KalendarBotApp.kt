package com.epam.kalendar.bot

import com.epam.kalendar.dto.Message
import com.epam.kalendar.dto.User
import com.google.gson.Gson
import me.ivmg.telegram.bot
import me.ivmg.telegram.dispatch
import me.ivmg.telegram.dispatcher.text
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.net.InetSocketAddress
import java.net.Proxy
import java.util.*

val json : MediaType? = MediaType.parse("application/json; charset=utf-8")
const val backUrl = "http://localhost:8080"

fun main(args: Array<String>) {

    val inetSocketAddress = InetSocketAddress("localhost", 1122)
    val botProxy = Proxy(Proxy.Type.SOCKS, inetSocketAddress)
    val client = OkHttpClient()
    val gson = Gson()


    val bot = bot {
        token = "YOUR_TOKEN_HERE"
        proxy = botProxy
        timeout = 5
        dispatch {
            text { bot, update ->
                val from = update.message?.from
                val message = Message(Date().toString(),
                        User(from?.id, from?.firstName, from?.firstName, from?.username),
                        update.message?.text)

                val requestBody = RequestBody.create(json, gson.toJson(message))
                val request = Request.Builder()
                        .url(backUrl)
                        .post(requestBody)
                        .build()

                val response = client.newCall(request).execute()
                response.body().use {
                    bot.sendMessage(chatId = update.message!!.chat.id,
                            text = gson.fromJson(it?.string(), Message::class.java).message)
                }
            }
        }

    }
    bot.startPolling()
}