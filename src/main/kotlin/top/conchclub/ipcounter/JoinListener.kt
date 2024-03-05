package top.conchclub.ipcounter

import net.md_5.bungee.api.event.LoginEvent
import taboolib.common.platform.event.SubscribeEvent
import taboolib.module.configuration.util.getMap

object JoinListener {

    @SubscribeEvent
    fun onJoin(e: LoginEvent) {
        val ip = e.connection.socketAddress.toString().split(':')[0].replace("/", "").replace(".", "-")
        val player = e.connection.name
        val ipMap = ConfigManager.IPList.getMap<String, List<String>>("")
        if (ipMap.keys.contains(ip)) {
            val playerList = ipMap[ip]
            if (playerList?.contains(player) == false) {
                ConfigManager.IPList[ip] = playerList + player
                ConfigManager.IPList.saveToFile()
            }
        } else {
            ConfigManager.IPList[ip] = listOf(player)
            ConfigManager.IPList.saveToFile()
        }
    }
}