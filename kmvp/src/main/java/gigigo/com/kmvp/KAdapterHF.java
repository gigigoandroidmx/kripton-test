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

/**
 * Defines the adapter with base functionality
 *
 * @param <T> data type to use
 *
 * @author Juan Godínez Vera - 12/22/2016
 * @author Adan Gutierrez Ortiz - 9/5/2017
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class KAdapterHF<T> extends KBaseAdapterHF<T, KViewHolder<T>> {

    public KAdapterHF(Context context) {
        super(context);
    }

    @Override
    public void onBindDataItemViewHolder(KViewHolder<T> holder, int position) {
        if(isEmpty()) return;
        holder.onBindViewHolder(itemsSource.get(position));
    }
}
