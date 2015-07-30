package in.beli.beliin.view.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import in.beli.beliin.R;
import in.beli.beliin.view.MainView;
import in.beli.beliin.view.activity.MainActivity;

public class MainFragment extends Fragment implements MainView {

    @Bind(R.id.logo) ImageView logo;
    @Bind(R.id.search) EditText search;
    @Bind(R.id.action_bar) Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).setupToolbar(toolbar);

        animateLogoUp();
        animateEditTextFadeInUpBounce();
        animatedToolbarFadeIn();
    }

    @Override
    public void animateLogoUp() {
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator logoUp = ObjectAnimator.ofFloat(logo, "translationY", 0,
                        -logo.getY() + 56);
                ObjectAnimator logoScaleDownX = ObjectAnimator.ofFloat(logo, "scaleX", 1f,  0.8f);
                ObjectAnimator logoScaleDownY = ObjectAnimator.ofFloat(logo, "scaleY", 1f, 0.8f);

                AnimatorSet animatorLogo = new AnimatorSet();
                animatorLogo.play(logoUp).with(logoScaleDownX).with(logoScaleDownY);
                animatorLogo.setDuration(800);
                animatorLogo.start();
            }
        }, 1000);
    }

    @Override
    public void animateEditTextFadeInUpBounce() {
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator fadeInButtonContainer = ObjectAnimator.ofFloat(search, "alpha",
                        0f, 1f);
                ObjectAnimator buttonUp = ObjectAnimator.ofFloat(search, "translationY", 250, -30);
                ObjectAnimator bounceButton = ObjectAnimator.ofFloat(search, "y",
                        search.getY() - 30, search.getY());
                bounceButton.setInterpolator(new BounceInterpolator());

                AnimatorSet animatorButtonContainer = new AnimatorSet();
                animatorButtonContainer.play(buttonUp).with(fadeInButtonContainer)
                        .before(bounceButton);
                animatorButtonContainer.setDuration(300);
                animatorButtonContainer.start();
            }
        }, 1500);
    }

    @Override
    public void animatedToolbarFadeIn() {
        new Handler(Looper.myLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                toolbar.setVisibility(View.VISIBLE);
                ObjectAnimator fadeInAnimator = ObjectAnimator.ofFloat(toolbar, "alpha", 0f, 1f);

                AnimatorSet animatorToolbar = new AnimatorSet();
                animatorToolbar.play(fadeInAnimator);
                animatorToolbar.setDuration(400);
                animatorToolbar.start();
            }
        }, 1600);
    }
}
