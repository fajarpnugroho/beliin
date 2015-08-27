package in.beli.beliin;

public enum Injector {
    INSTANCE;

    private ApplicationComponent applicationComponent;

    Injector() {}

    void initializeComponent(BeliInApp app) {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationContextModule(new ApplicationContextModule(app)).build();
    }

    public ApplicationComponent getApplicationComponent() { return applicationComponent; }
}
