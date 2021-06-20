package ermilov.qr_reader.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import ermilov.qr_reader.feature.data.MyRepository
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
class MainModule {
    @Provides
    @Singleton
    fun provideRepo() : MyRepository{
        return MyRepository()
    }
}