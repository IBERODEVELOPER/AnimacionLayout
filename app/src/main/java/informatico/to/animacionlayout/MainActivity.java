package informatico.to.animacionlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutAnimado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //llamamos a la imagen para el action bar
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        layoutAnimado = (LinearLayout)  findViewById(R.id.layoutanimado); }
    public void aparecer(View button) {
        if (layoutAnimado.getVisibility() == View.GONE) {
            animar("aparecer");
            layoutAnimado.setVisibility(View.VISIBLE); }}

    public void desaparecer(View button) {
        if (layoutAnimado.getVisibility() == View.VISIBLE) {
            animar("desaparecer");
            layoutAnimado.setVisibility(View.GONE); } }
    private void animar(String mostrar) {
        AnimationSet set = new AnimationSet(true);
        Animation animation = null;
        if (mostrar.equals("aparecer")) {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);}

        if (mostrar.equals("desaparecer")) {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.1f,
                    Animation.RELATIVE_TO_SELF, 0.1f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f);}
        //duración en milisegundosanimation.setDuration(500);
        set.addAnimation(animation);
        LayoutAnimationController controller = new LayoutAnimationController(set, 0.20f);
        layoutAnimado.setLayoutAnimation(controller);
        layoutAnimado.startAnimation(animation);
    }}