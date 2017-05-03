package gigigo.com.kripton;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;

import gigigo.com.kmvp.KViewHolder;

/**
 * @author Juan Godínez Vera - 5/2/2017.
 */
public class HomeViewHolder
        extends KViewHolder<String> {

    TextView textViewMessage;

    public HomeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull String item) {
        super.onBindViewHolder(item);

        textViewMessage = (TextView) itemView.findViewById(R.id.textview_message);

        textViewMessage.setText(item);
    }
}
