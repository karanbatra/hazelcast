/*
 * Copyright (c) 2008-2013, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.queue;

import com.hazelcast.spi.impl.SerializableCollection;

/**
 * @author ali 12/18/12
 */
public class IteratorOperation extends QueueOperation {

    public IteratorOperation() {
    }

    public IteratorOperation(String name) {
        super(name);
    }

    public void run() {
        response = new SerializableCollection(getOrCreateContainer().getAsDataList());
    }

    public void afterRun() throws Exception {
        getQueueService().getLocalQueueStatsImpl(name).incrementOtherOperations();
    }

    public int getId() {
        return QueueDataSerializerHook.ITERATOR;
    }
}
