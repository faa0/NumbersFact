package com.fara.common_di.holder.single

import com.fara.common_di.holder.ClearedComponentHolder
import com.fara.common_di.component.base.DIComponent

abstract class DataComponentHolder<Component : DIComponent, Data : Any> :
    BaseComponentHolder<Component>, ClearedComponentHolder {

    private var component: Component? = null

    override fun get(): Component {
        return requireNotNull(component) { "${javaClass.simpleName} — component not found" }
    }

    fun init(data: Data) {
        component ?: build(data).also { component = it }
    }

    override fun set(component: Component) {
        this.component = component
    }

    override fun clear() {
        component = null
    }

    protected abstract fun build(data: Data): Component
}
