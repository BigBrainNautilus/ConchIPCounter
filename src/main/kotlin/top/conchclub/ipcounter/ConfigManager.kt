package top.conchclub.ipcounter

import taboolib.common.LifeCycle
import taboolib.common.platform.Awake
import taboolib.module.configuration.Config
import taboolib.module.configuration.ConfigFile

object ConfigManager {

    @Config("iplist.yml")
    lateinit var IPList: ConfigFile

    @Awake(LifeCycle.ENABLE)
    fun info(){
        taboolib.common.platform.function.info("ConchIPCounter 已启动, 作者QQ 345880606")
    }
}