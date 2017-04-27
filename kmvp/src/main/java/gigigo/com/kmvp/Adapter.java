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

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Juan Godínez Vera - 4/26/2017.
 */
public abstract class Adapter<T>
        extends RecyclerView.Adapter<ViewHolder<T>>
        implements IEnumerable<T> {

    private List<T> itemsSource = new ArrayList<>();


    /**
     * Called by RecyclerView to display the data at the specified position
     * @param holder view which should be updated to represent the contents of the item
     * @param position position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(ViewHolder<T> holder, int position) {
        if(isEmpty()) return;
        holder.onBindViewHolder(itemsSource.get(position));
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return itemsSource != null ? itemsSource.size() : 0;
    }

    /**
     * Returns if the data set are empty
     * @return <code>true</code>, whether the items in the data set are null, otherwise <code>false</code>
     */
    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    /**
     * Obtains the LayoutInflater from the given context
     * @param parent view parent
     * @param resourceId layout resource
     * @return a layout XML
     */
    public View getView(ViewGroup parent, @LayoutRes int resourceId) {
        return LayoutInflater.from(parent.getContext()).inflate(resourceId, parent, false);
    }

    //region IEnumerable members

    /**
     * Adds an object to the end of the sequence
     *
     * @param item
     */
    @Override
    public void add(T item) {
        add(Collections.singletonList(item));
    }

    /**
     * Adds the elements of the specified collection to the end of the sequence
     *
     * @param items
     */
    @Override
    public void add(Iterable<T> items) {
        if(items == null) return;

        for (T item : items) {
            itemsSource.add(item);
        }

        notifyDataSetChanged();
    }

    /**
     * Updates the first occurrence of a specific object from the sequence
     *
     * @param item
     */
    @Override
    public void update(T item) {
        if(isEmpty()) return;
        int position = itemsSource.indexOf(item);
        if(position == -1) return;
        itemsSource.set(position, item);
        notifyDataSetChanged();
    }

    /**
     * Removes the first occurrence of a specific object from the sequence
     *
     * @param item
     */
    @Override
    public void remove(T item) {
        if(isEmpty()) return;
        int position = itemsSource.indexOf(item);
        if(position == -1) return;
        itemsSource.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    /**
     * Retrieves all the elements that match the conditions defined by the specified predicate.
     *
     * @param predicate
     * @return
     */
    @Override
    public Iterable<T> where(IPredicate<T> predicate) {
        return null;
    }

    /**
     * Removes all elements from the sequence
     */
    @Override
    public void clear() {
        itemsSource.clear();
        notifyDataSetChanged();
    }

    /**
     * Gets all elements from the sequence
     *
     * @return
     */
    @Override
    public Iterable<T> items() {
        return itemsSource;
    }

    //endregion
}
