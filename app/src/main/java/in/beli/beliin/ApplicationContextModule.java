package in.beli.beliin;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModule {
    private final BeliInApp application;

    public ApplicationContextModule(BeliInApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    BeliInApp provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }
}
