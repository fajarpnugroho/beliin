package in.beli.beliin;

import javax.inject.Singleton;

import dagger.Component;
import in.beli.beliin.ui.fragment.MainFragment;
import in.beli.beliin.ui.presenter.MainPresenter;

@Singleton
@Component (modules = ApplicationContextModule.class)
public interface ApplicationComponent extends ApplicationContextComponent{
    void inject(MainFragment fragment);

    void inject(MainPresenter presenter);
}
