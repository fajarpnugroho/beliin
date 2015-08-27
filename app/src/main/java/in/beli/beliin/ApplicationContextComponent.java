package in.beli.beliin;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationContextModule.class)
public interface ApplicationContextComponent {}
