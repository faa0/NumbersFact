package com.fara.common_di.holder.single

import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.ClearedComponentHolder
import java.lang.ref.WeakReference

abstract class FeatureComponentHolder<Component : DIComponent> : BaseComponentHolder<Component>,
    ClearedComponentHolder {

    private var component: WeakReference<Component>? = null

    override fun get(): Component {
        return component?.get() ?: build().also { component = WeakReference(it) }
    }

    override fun set(component: Component) {
        this.component = WeakReference(component)
    }

    protected abstract fun build(): Component

    override fun clear() {
        component = null
    }
}
