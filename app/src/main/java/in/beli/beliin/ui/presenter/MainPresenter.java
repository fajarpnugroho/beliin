package in.beli.beliin.ui.presenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import in.beli.beliin.Injector;
import in.beli.beliin.ui.router.MainRouter;
import in.beli.beliin.ui.MainView;

@Singleton
public class MainPresenter {

    private MainView view;

    @Inject MainRouter router;

    @Inject public MainPresenter() {
        Injector.INSTANCE.getApplicationComponent().inject(this);
    }

    public void setView(MainView view) { this.view = view; }

    public void setRouter() {
        router.setActivity(view.getContext());
    }

    public void searchProduct() {
        router.navigateToSearchActivity();
    }
}
