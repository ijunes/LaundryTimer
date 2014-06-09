package com.ijunes.laundrytimer.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ijunes.laundrytimer.R;
import com.ijunes.laundrytimer.core.User;
import com.squareup.picasso.Picasso;

import butterknife.InjectView;

import static com.ijunes.laundrytimer.core.Constants.Extra.USER;

public class MachineActivity extends BootstrapActivity {

    @InjectView(R.id.iv_avatar) protected ImageView avatar;
    @InjectView(R.id.tv_name) protected TextView name;

    private User user;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_view);

        if (getIntent() != null && getIntent().getExtras() != null) {
            user = (User) getIntent().getExtras().getSerializable(USER);
        }

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Picasso.with(this).load(user.getAvatarUrl())
                .placeholder(R.drawable.gravatar_icon)
                .into(avatar);

        name.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));

    }


}
