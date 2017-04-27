/* Copyright (c) 2016 Gigigo Android Development Team México
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gigigo.com.kmvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

/**
 * Defines an item view about its place within the RecyclerView
 *
 * @param <T> data type to use
 *
 * @author Juan Godínez Vera - 12/22/2016
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class ViewHolder<T>
        extends RecyclerView.ViewHolder {

    private T item;
    private Context context;

    public ViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
    }

    /**
     *
     * @param actionCommand
     */
    public void setActionCommand(final IAction actionCommand) {
        if(actionCommand != null) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actionCommand.invoke(getItem());
                }
            });
        }
    }

    /**
     *
     * @param item
     */
    public void onBindViewHolder(@NonNull T item) {
        this.item = item;
    }

    /**
     *
     * @return
     */
    public T getItem() {
        return this.item;
    }

    /**
     *
     * @return
     */
    public Context getContext() {
        return this.context;
    }

    /**
     *
     * @param message
     */
    public void showToastMessage(String message) {
        Toast toast = Toast.makeText(this.context, message, Toast.LENGTH_LONG);

        if(toast != null && !toast.getView().isShown()) {
            toast.show();
        }
    }
}
