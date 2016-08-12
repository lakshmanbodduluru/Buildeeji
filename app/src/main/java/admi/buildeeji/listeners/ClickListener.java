package admi.buildeeji.listeners;

import android.os.Bundle;
import android.view.View;

/**
 * Created by Admin on 8/5/2016.
 */
public interface ClickListener {
    public void onClick(View view, int position, Bundle bundle);

    public void onLongClick(View view, int position);

    public void onClickMail(String toMail);

    public void onClickPhone(String phone);
}
