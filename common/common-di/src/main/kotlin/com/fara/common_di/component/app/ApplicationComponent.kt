package com.fara.common_di.component.app

import android.content.Context
import com.fara.common_di.component.base.DIComponent
import com.fara.common_di.holder.single.DataComponentHolder
import dagger.BindsInstance
import dagger.Component

interface ApplicationComponent : DIComponent {

    fun context(): Context
}

@Component
internal interface ApplicationComponentInternal : ApplicationComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): ApplicationComponent
    }
}

object ApplicationComponentHolder : DataComponentHolder<ApplicationComponent, ApplicationComponentDependencies>() {

    override fun build(data: ApplicationComponentDependencies): ApplicationComponent {
        return DaggerApplicationComponentInternal.factory().create(context = data.context)
    }
}
