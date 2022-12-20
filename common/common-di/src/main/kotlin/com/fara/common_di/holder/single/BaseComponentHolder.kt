package com.fara.common_di.holder.single

import com.fara.common_di.component.base.DIComponent

interface BaseComponentHolder<Component : DIComponent> {

    fun get(): Component

    fun set(component: Component)
}
