package inbox.wolf.alex.wolftimemanager.view.view;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class TimerControlsVisibility {

    Button button;
    RelativeLayout layout;

    public TimerControlsVisibility(Button button, RelativeLayout layout) {
        this.button = button;
        this.layout = layout;
    }

    public void buttonVisibility() {
        button.setVisibility(View.VISIBLE);
        layout.setVisibility(View.GONE);
    }

    public void layoutVisibility() {
        layout.setVisibility(View.VISIBLE);
        button.setVisibility(View.GONE);
    }

}
