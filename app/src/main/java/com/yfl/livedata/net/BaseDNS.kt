package com.yfl.livedata.net

import okhttp3.Dns
import java.net.InetAddress

/**
 * @Author : YFL  is Creating a porject in My Application
 * @Package com.yfl.livedata.net
 * @Email : yufeilong92@163.com
 * @Time :2020/12/31 19:28
 * @Purpose :
 */
class BaseDNS : Dns {
    override fun lookup(hostname: String): MutableList<InetAddress> {
        val inetAddress = mutableListOf<InetAddress>()
        var hostInetAddress: MutableList<InetAddress>? = null
        try {
            hostInetAddress = Dns.SYSTEM.lookup(hostname)

        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (!hostInetAddress.isNullOrEmpty()){
            inetAddress.addAll(hostInetAddress)
        }
        try {
          inetAddress.add(InetAddress.getByName(""))
        }catch (e:Exception){
            e.printStackTrace()
        }
        return inetAddress

    }
}