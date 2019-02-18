package soumyajitdas.com.roomviewmodelkotlinsample.DI.Component

import dagger.Component
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Module.ApiModule
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Module.AppModule
import soumyajitdas.com.roomviewmodelkotlinsample.Activity.MainActivityPresenter
import soumyajitdas.com.roomviewmodelkotlinsample.DI.Module.DBModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class), (DBModule::class)])
interface ApiComponent {

    fun inject(mainActivityPresenter: MainActivityPresenter)

}