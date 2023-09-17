import android.content.Context
import com.maddukuri.republicservices.data.source.remote.RemoteDataRepository
import com.maddukuri.republicservices.di.AppModule
import com.maddukuri.republicservices.network.RetrofitBuilder
import com.maddukuri.republicservices.view.mainscreen.MainActivity
import com.maddukuri.republicservices.view.routesscreen.RoutesActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Dagger Application Component to inject the places of dependencies
 */
@Singleton
@Component(modules = [RetrofitBuilder::class, AppModule::class])
interface ApplicationComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): ApplicationComponent
    }

    // Inject MainActivity to satisfy its dependencies
    fun inject(activity: MainActivity)

    // Inject RoutesActivity to satisfy its dependencies
    fun inject(activity: RoutesActivity)

    // Provide an instance of RemoteDataRepository
    val driverDataRepository: RemoteDataRepository
}
