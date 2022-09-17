package com.thiago.coordinator.di

import com.thiago.navigation.AuthCoordinator
import com.thiago.navigation.NavigationManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApplicationScope

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DefaultDispatcher

@InstallIn(SingletonComponent::class)
@Module
object NavigationModule {

    @ApplicationScope
    @Singleton
    @Provides
    fun providesApplicationScope(
        @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
    ): CoroutineScope = CoroutineScope(SupervisorJob() + defaultDispatcher)

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Singleton
    @Provides
    fun providesNavigationManager(@ApplicationScope applicationScope: CoroutineScope): NavigationManager {
        return NavigationManager(applicationScope)
    }

    @Singleton
    @Provides
    fun providesAuthCoordinator(navigationManager: NavigationManager): AuthCoordinator {
        return AuthCoordinator(navigationManager)
    }
}
