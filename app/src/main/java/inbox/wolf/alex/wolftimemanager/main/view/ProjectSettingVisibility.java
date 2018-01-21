package inbox.wolf.alex.wolftimemanager.main.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import inbox.wolf.alex.wolftimemanager.R;

public class ProjectSettingVisibility {

    private TextView title;
    private ImageView settingBtn;
    Context context;

    public ProjectSettingVisibility(TextView title, ImageView settingBtn, Context context) {
        this.title = title;
        this.settingBtn = settingBtn;
        this.context = context;
    }
    public void addTextChangedListener() {
        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(title.getText().toString().equals(context.getString(R.string.all_group_time))){
                    settingBtn.setVisibility(View.GONE);
                }else {
                    settingBtn.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


}
