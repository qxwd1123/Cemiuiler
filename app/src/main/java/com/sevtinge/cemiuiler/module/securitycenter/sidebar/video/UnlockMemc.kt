package com.sevtinge.cemiuiler.module.securitycenter.sidebar.video

import com.github.kyuubiran.ezxhelper.EzXHelper.classLoader
import com.github.kyuubiran.ezxhelper.HookFactory.`-Static`.createHook
import com.sevtinge.cemiuiler.module.base.BaseHook
import com.sevtinge.cemiuiler.module.securitycenter.SecurityCenterDexKit
import com.sevtinge.cemiuiler.utils.DexKit.closeDexKit
import com.sevtinge.cemiuiler.utils.DexKit.initDexKit
import com.sevtinge.cemiuiler.utils.DexKit.safeDexKitBridge
import java.util.Objects

object UnlockMemc : BaseHook() {
    override fun init() {
        initDexKit(lpparam)
        try {
            val result = Objects.requireNonNull(
                SecurityCenterDexKit.mSecurityCenterResultClassMap["FrcSupport"]
            )
            for (descriptor in result) {
                val frcSupport = descriptor.getClassInstance(lpparam.classLoader)
                log("frcSupport class is $frcSupport")
                var counter = 0
                safeDexKitBridge.findMethod {
                    methodDeclareClass = frcSupport.name
                    methodReturnType = "boolean"
                    methodParamTypes = arrayOf("java.lang.String")
                }.forEach { methods ->
                    counter++
                    if (counter == 5) {
                        methods.getMethodInstance(classLoader).createHook {
                            returnConstant(true)
                        }
                    }
                }
            }
        } catch (e: Throwable) {
            logE("FrcSupport", e)
        }
        closeDexKit()
    }
}
