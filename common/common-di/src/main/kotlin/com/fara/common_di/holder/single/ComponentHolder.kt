package com.fara.common_di.holder.single

import com.fara.common_di.holder.ClearedComponentHolder
import com.fara.common_di.component.base.DIComponent

abstract class ComponentHolder<Component : DIComponent> : BaseComponentHolder<Component>, ClearedComponentHolder {

    private var component: Component? = null

    override fun get(): Component {
        return component ?: build().also { component = it }
    }

    override fun set(component: Component) {
        this.component = component
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
